/**
 * 
 */
package prjDigraph;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Marinho
 * @apiNote This class will export an .txt as an .csv file.
 */
public class ExportAsCSV {
	private String filePath;

	/**
	 * @param filePath name of the path to the file digraph.txt that you want to export as .csv.
	 * @apiNote ExportAsCSV constructor's class.
	 */
	public ExportAsCSV(String filePath){
		this.filePath = filePath;
	}

	/**
	 * @apiNote method that will export the file digraphCSV.csv and show it in console.
	 */
	public void exportCSV() {
		try {
			Writer writer = Files.newBufferedWriter(Paths.get("digraphCSV.csv"));
			String txt = new String(Files.readAllBytes(Path.of(filePath)));
			txt  = txt.replaceAll("\\n+", ";");
			txt  = txt.replaceAll("\\p{Punct}", ";");
			txt  = txt.replaceAll("\\s+", "");
			for (String line: txt.split("\\n+")) {
				//System.out.print(line);
				writer.write(line);				
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
