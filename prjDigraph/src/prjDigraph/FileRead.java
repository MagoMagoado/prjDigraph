package prjDigraph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Rhuan
 * @apiNote This class you read an file .txt in the console.
 */
public class FileRead{

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				System.out.println(linha);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
}