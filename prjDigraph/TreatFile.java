/**
 * 
 */
package prjDigraph;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		this.filePath = filePath;
	};
	
	/**
	 * @apiNote method that will generate another .txt file as a copy of parameter .txt, but without accent, punctuation and as lower case.
	 */
	public void transformFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter("treatedFile.txt"));
			String line;
			while((line = reader.readLine()) != null) {
				//turn all the character in lower case from the line
				line = line.toLowerCase();
				line = line.replaceAll("\\n", "");
				line = removePunct(line);
				line = removeAccents(line);
				line = removeBreakPoints(line);
				
				writer.write(line);
				if(reader.ready()) {
					writer.newLine();
				}
			}
			reader.close();
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
	 * @param line parameter that will be convert to a String without \n.
	 * @return return a String that will remove all the breaking points.
	 */
	protected String removeBreakPoints(String line) {
		Pattern pattern = Pattern.compile("\n");
	    //pattern.matcher: will find where is the match of the regex to text that we pass as param
	    return pattern.matcher(line).replaceAll("");
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
