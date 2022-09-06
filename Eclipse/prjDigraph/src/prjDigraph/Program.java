package prjDigraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 
 *
 */
public class Program {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Pc/Downloads/Texto01.txt"));
			String line;
			while((line = reader.readLine()) != null) {
				for(int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == ' ') {
		                espaço++;
		            }
				}
				System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
