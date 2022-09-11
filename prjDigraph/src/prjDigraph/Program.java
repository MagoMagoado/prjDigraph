package prjDigraph;

/**
 * @author 
 *
 */


public class Program {
	public static void main(String[] args) {		
		TreatFile file = new TreatFile("Texto001.txt");
		file.transformFile();
		ConvertToDigraph file2 = new ConvertToDigraph("treatedFile.txt");
		file2.generateDigraph();
	}
}
