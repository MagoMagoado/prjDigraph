/**
 * 
 */
package prjDigraph;

import java.io.IOException;

/**
 * @author Valterci
 *@apiNote Class Controller. used to command all the classes that will interact with the Digraph class.
 */
public class Controller {
	private String filePath;

	/** 
	 *@apiNote Controller constructor's class.
	 */
	public  Controller(String filePath) {
		this.filePath = filePath;
	};

	/**
	 *@apiNote method that call the FileRead class.
	 */
	public void CallReaderFile() {
		try {
			FileRead.leitor(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *@apiNote method that call the TreatFile class.
	 */
	public void CallTreatFile() {
		TreatFile callTreatFile = new TreatFile(filePath);
		callTreatFile.transformFile();
	}

	/**
	 *@apiNote method that call the ConvertToDigraph class.
	 */
	public void CallCovertoToDigraph() {
		ConvertToDigraph convertToDiagraph = new ConvertToDigraph("treatedFile.txt");
		convertToDiagraph.generateDigraph();
	}

	/**
	 *@apiNote method that call the ExportAsCSV class.
	 */
	public void CallExportAsCSV() {
		ExportAsCSV callExportAsCSV = new ExportAsCSV("digraphFile.txt");
		callExportAsCSV.exportCSV();
	}
}
