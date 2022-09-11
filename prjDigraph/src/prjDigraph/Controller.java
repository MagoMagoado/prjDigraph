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
	
	public void CallReaderFile(String filePath) throws IOException {
		FileRead.leitor(filePath);
	}
	public void CallTreatFile(String filePath) {
		TreatFile treatFile = new TreatFile(filePath);
		treatFile.transformFile();
		
	}
	public void CallCovertoToDigraph(String filePath) {
		ConvertToDigraph convertToDigraph = new ConvertToDigraph(filePath);
		convertToDigraph.convertToDigraph();
	}
	public void CallExportAsCVS(String filePath) {
		
	}
}