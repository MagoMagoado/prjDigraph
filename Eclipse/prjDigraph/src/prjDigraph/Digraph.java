/**
 * 
 */
package prjDigraph;

/**
 * @author 
 *@apiNote Class Digraph. Used to upload a file, treat it and export as a digraph.
 */
public class Digraph {
	private String filePath;
	private Controller file;
	
	/** 
	 *@apiNote Digraph constructor's class.
	 */
	Digraph(String filePath) {
		this.filePath = filePath;
		Controller file = new Controller(filePath);
		this.file = file;
	};
	
	/**
	 *@apiNote method used to read the file.
	 */
	public void readFile() {
		file.CallReaderFile();
	}
	/**
	 *@apiNote method used to normalize the file by removing all the special characters and lower the characters.
	 */
	public void treatFile() {
		file.CallTreatFile();
	}
	/**
	 *@apiNote 
	 */
	public void convertToDigraph() {
	}
	/**
	 *@apiNote 
	 */
	public void exportAsCVS() {
	}
	
}
