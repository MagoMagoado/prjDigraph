/**
 * 
 */
package prjDigraph;

/**
 * @author 
 *
 */
public class Controller {
	ReaderFile reader;
	TreatFile treat;
	ExportDigraph digraph;
	
	public void CallReaderFile(String fileName, String filePath) {
		reader = new ReaderFile(fileName, filePath);
	}
}
