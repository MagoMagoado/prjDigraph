/**
 * 
 */
package prjDigraph;

/**
 * @author Val
 *@apiNote Class Digraph. Used to upload a file, treat it and export as a digraph.
 */
public class Digraph {
	@SuppressWarnings("unused")
	private String filePath;
	private Controller controller;
	
	/** 
	 *@apiNote Digraph constructor's class.
	 */
	Digraph(String filePath) {
		this.filePath = filePath;
		Controller controller = new Controller(filePath);
		this.controller = controller;
	};
	
	/**
	 *@apiNote method used to read the file.
	 */
	public void readFile() {
		controller.CallReaderFile();
	}
	/**
	 *@apiNote method used to normalize the file by removing all the special characters and lower the characters.
	 */
	public void treatFile() {
		controller.CallTreatFile();
	}
	/**
	 *@apiNote method used to generate a output to the Console of the text in a digraph form and export an .txt of it.
	 */
	public void convertToDigraph() {
		controller.CallCovertoToDigraph();
	}
	/**
	 *@apiNote method that will export the file digraphCSV.csv and show it in console.
	 */
	public void exportAsCVS() {
		controller.CallExportAsCSV();
	}
	
}
