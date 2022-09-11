/**
 * 
 */
package prjDigraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 
 *
 */
public class ConvertToDigraph {
	private String filePath;

	/**
	 * @param filePath name of the path to the file .txt that you convert to a digraph.
	 * @apiNote ConvertToDigraph constructor's class.
	 */
	public ConvertToDigraph(String filePath) {
		this.filePath = filePath;
	};

	/**
	 * @apiNote Generate a output to the Console of the text in a digraph form and export an .txt of it.
	 */
	public void generateDigraph() {
		String[] array  = stringToArray();
		String[] arrayAlphabetical  = arrayAlphabetical(array);
		String[] subArray = {};
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("digraphFile.txt"));
			for (int i = 0; i<arrayAlphabetical.length-1; i++) {

				//if is the first interaction
				if(i == 0) {
					System.out.print(arrayAlphabetical[0]);
					writer.write(arrayAlphabetical[0]);

				}
				else {
					//if the value of the array is not equal to previous value array
					if((arrayAlphabetical[i].equals(arrayAlphabetical[i-1])) == false) {
						System.out.print("\n"+arrayAlphabetical[i]);
						writer.write("\n"+arrayAlphabetical[i]);
						//reset the subValues
						subArray = deleteElementsArray(subArray);
					}
				}

				for (int j = 0; j<array.length-1; j++) {
					if(array[j] == arrayAlphabetical[i]) {
						//test if the word is not being repeated in the line, if isn't append it in the subArray and show it in screen
						if((stringInArray(array[j+1], subArray)) == false) {
							subArray = appendToStringArray(subArray, array[j+1]);
							System.out.print(", "+lastElementArray(subArray));
							writer.write(", "+lastElementArray(subArray));
						}
					}
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @apiNote This method turn which word of the file .txt in an ordered array of strings.
	 */
	public String[] stringToArray() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			// list that holds strings of a file
			List<String> listOfStrings = new ArrayList<String>();
			String line;
			String[] temp;
			int i;
			while((line = reader.readLine()) != null) {
				temp = line.split("\\s");
				for(i = 0; i <temp.length; i++) {
					listOfStrings.add(temp[i]);
				}
			}
			reader.close();

			// storing the data in arraylist to array
			String[] array = listOfStrings.toArray(new String[0]);
			return array;

		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] error = null;
		return error;
	}

	/**
	 * @param array Request a ListArray
	 * @return A copy of the parameter in an alphabetically ordered array.
	 */
	protected String[] arrayAlphabetical(String[] array) {
		List<String> alphabeticArray = new ArrayList<String>();
		Collections.addAll(alphabeticArray, array);
		Collections.sort(alphabeticArray);
		String[] ordenedArray = alphabeticArray.toArray(new String[0]);
		return ordenedArray; 
	}

	/**
	 * @param string string that you want to test if exist in the array.
	 * @param array  array that you want to manipulate.
	 * @return Returns a boolean if the element exist in the array.
	 */
	protected boolean stringInArray(String string, String[] array) {
		boolean condition = false;
		for(int i = 0; i<array.length; i++) {
			if(array[i].equals(string)) {
				condition = true;
			}
		}
		return condition;
	}

	/**
	 * @param array array that you want to manipulate.
	 * @param element element that you want to append to to array.
	 * @return Returns the same array appended with the parameter String element.
	 */
	protected String[] appendToStringArray(String[] array, String element) {
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		list.add(element);

		return list.toArray(new String[0]);
	}

	/**
	 * @param array array that you want to manipulate.
	 * @return Returns the last element of parameter array.
	 */
	protected String lastElementArray(String[] array) {
		int lastElement = array.length - 1;

		return array[lastElement];
	}

	/**
	 * @param array array that you be cleared.
	 * @return Returns the same array but without it's elements.
	 */
	protected String[] deleteElementsArray(String[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = "";
		}

		return array;
	}

}
