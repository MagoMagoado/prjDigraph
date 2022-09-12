package prjDigraph;
/**
 * @author 
 *
 */


public class Program {
	public static void main(String[] args) {
		Digraph obj = new Digraph("Texto001.txt");
		obj.readFile();
		obj.convertToDigraph();
		obj.exportAsCVS();
		}
	}
