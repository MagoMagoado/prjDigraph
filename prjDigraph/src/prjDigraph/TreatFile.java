/**
 * 
 */
package prjDigraph;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * @author Isabella
 * @apiNote This class will normalize the file by removing all the special characters and lower the characters.
 */
public class TreatFile {
	private String filePath;

	/**
	 * @param filePath name of the path to the file .txt that you want to treat.
	 * @apiNote TreatFile constructor's class.
	 */
	public TreatFile(String filePath) {
		this.filePath= filePath;
	};

	/**
	 * @apiNote method that will generate another .txt file as a copy of parameter .txt, but without accent, punctuation and as lower case.
	 */
	public void transformFile() {
		try {      
			BufferedWriter writer = new BufferedWriter(new FileWriter("treatedFile.txt"));

			//remove all the Breaking points
			String txt = new String(Files.readAllBytes(Path.of(filePath)));
			int i = 0;
			for (String line: txt.split("\\n+")) {
				if(i != 0) {
					writer.newLine();
					//System.out.print("\n");
				}
				line = line.toLowerCase();
				line = removePunct(line);
				line = removeAccents(line);
				//System.out.print(line);
				writer.write(line);
				i++;
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param line parameter that will be convert to a String without punctuation.
	 * @return return a String that will remove all the characters punctuation.
	 */
	protected String removePunct(String line) {
		//remove all the punct from the line
		return line.replaceAll("\\p{Punct}", "");
	}

	/**
	 * @param line parameter that will be convert to a String without accents.
	 * @return return a String that replace all the characters with accents without them.
	 */
	protected String removeAccents(String line) {
		String normalized = Normalizer.normalize(line, Normalizer.Form.NFD);
		//Pattern.compile: will use [^\\p{ASCII}] as reference to regex  
		Pattern pattern = Pattern.compile("[^\\p{ASCII}]");
		//pattern.matcher: will find where is the match of the regex to text that we pass as param
		return pattern.matcher(normalized).replaceAll("");
	}
}
