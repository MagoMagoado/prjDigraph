package prjDigraph;

/**
 * @author 
 *
 */


public class Program {
	public static void main(String[] args) {
		Digraph file = new Digraph("C:/Users/Pc/Downloads/Texto001.txt");
		file.treatFile();
		file.readFile();
		
		ConvertToDigraph file1 = new ConvertToDigraph("treatFile.txt");
		file1.generateDigraph();
	}
}
