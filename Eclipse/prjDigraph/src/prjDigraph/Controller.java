/**
 * 
 */
package prjDigraph;

import java.io.IOException;

/**
 * @author 
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CallTreatFile() {
		TreatFile file = new TreatFile(filePath);
		file.transformFile();
	}
	public void CallCovertoToDigraph() {
		ConvertToDigraph convertToDiagraph = new ConvertToDigraph(filePath);
		convertToDiagraph.generateDigraph();
	}
	public void CallExportAsCSV() {
		CallExportAsCSV callExportAsCSV = new CallExportAsCSV(filePath);
		callExportAsCSV.callExportAsCSV();
	}
}
