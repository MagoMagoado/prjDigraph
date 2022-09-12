/**
 * 
 */
package prjDigraph;

import java.io.IOException;

/**
 * @author Val
 *
 */
public class Controller {
	private String filePath;

	public  Controller(String filePath) {
		this.filePath = filePath;
	};

	public void CallReaderFile() {
		try {
			FileRead.leitor(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void CallTreatFile() {
		TreatFile callTreatFile = new TreatFile(filePath);
		callTreatFile.transformFile();
	}
	
	public void CallCovertoToDigraph() {
		ConvertToDigraph convertToDiagraph = new ConvertToDigraph(filePath);
		convertToDiagraph.generateDigraph();
	}
	
	public void CallExportAsCSV() {
		ExportAsCSV callExportAsCSV = new ExportAsCSV(filePath);
		callExportAsCSV.exportCSV();
	}
}
