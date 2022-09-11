/**
 * 
 */
package prjDigraph;

import java.io.BufferedReader;
import java.io.FileReader;
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

	public void generateDigraph() {
		String[] array  = stringToArray();
		String[] arrayAlphabetical  = arrayAlphabetical(array);
		String[] subArray = {};
		
		for (int i = 0; i<arrayAlphabetical.length-1; i++) {
			
			//if is the first interaction
			if(i == 0) {
				System.out.print(arrayAlphabetical[0]);
				System.out.print(removeEmptyArray("z"));
			}
			else {
				//if the value of the array is not equal to previous value array
				if((arrayAlphabetical[i].equals(arrayAlphabetical[i-1])) == false) {
					//System.out.print("\n"+arrayAlphabetical[i]);
					//reset the subValues
					subArray = deleteElementsArray(subArray);
				}
			}
			
			for (int j = 0; j<array.length-1; j++) {
				if(array[j] == arrayAlphabetical[i]) {
					//test if the word is not being repeated in the line, if isn't append it in the subArray and show it in screen
					if((stringInArray(array[j+1], subArray)) == false) {
						subArray = appendToStringArray(subArray, array[j+1]);
						//System.out.print(", "+lastElementArray(subArray));
					}
				}
			}
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
	
	protected String removeEmptyArray(String array) {
		String resultado = null;
			if(array.equals("[a-z]") == false) {
				resultado = "não é uma letra de a-z";
		}
		
		return resultado; 
	}
	

	protected boolean stringInArray(String string, String[] array) {
		boolean condition = false;
		for(int i = 0; i<array.length; i++) {
			if(array[i].equals(string)) {
				condition = true;
			}
		}
		return condition;
	}

	protected String[] appendToStringArray(String[] array, String element) {
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		list.add(element);

		return list.toArray(new String[0]);
	}
	
	protected String lastElementArray(String[] array) {
		int lastElement = array.length - 1;

		return array[lastElement];
	}
	
	protected String[] deleteElementsArray(String[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = "";
		}

		return array;
	}

}
