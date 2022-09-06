/**
 * 
 */
package prjDigraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author
 *
 */
public class ReaderFile {
	private String fileName;
	private String filePath;
	
	public void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Pc/Downloads/Texto01.txt"));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
