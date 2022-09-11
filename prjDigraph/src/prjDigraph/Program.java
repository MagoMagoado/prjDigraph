package prjDigraph;

/**
 * @author 
 *
 */


public class Program {
	public static void main(String[] args) {		
		ConvertToDigraph file1 = new ConvertToDigraph("treatedFile.txt");
		file1.generateDigraph();
	}
}
