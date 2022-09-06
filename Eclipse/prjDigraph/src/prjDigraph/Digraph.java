/**
 * 
 */
package prjDigraph;

/**
 * @author 
 *@apiNote Class Digraph. Used to upload files and export as a digraph.
 */
public class Digraph {
	private String fileName;
	private String filePath;
	private Controller controller;
	
	/** 
	 *@apiNote Constructor of the class Digraph.
	 */
	Digraph() {
		controller = new Controller();
	};
	
	/**
	 *@param fileName name of the file that you want to read.
	 *@param filePath path of the file that you want to read.
	 *@apiNote method used to read the file.
	 */
	public void ReadFile(String fileName, String filePath) {
		controller.CallReaderFile(fileName, filePath);
	}
}
