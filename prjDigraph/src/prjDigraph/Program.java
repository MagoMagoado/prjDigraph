package prjDigraph;

import java.util.Scanner;

/**
 * @author Isabella
 *
 */

public class Program {
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter the path of the file that you want to export as a digraph:");
			String namePath = s.nextLine();
			Digraph obj = new Digraph(namePath);

			//obj.readFile();
			obj.treatFile();
			obj.convertToDigraph();
			obj.exportAsCVS();
		}
	}
}
