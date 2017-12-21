package ie.gmit.sw.ds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {

	private static final long serialVersionUID = 1L;
	private Map<String, String> dict;
	private BufferedReader br;
	private File file;

	public DictionaryServiceImpl(String filename) throws RemoteException {
		dict = new HashMap<>();
		file = new File(filename);
	}// construct

	public void populateDict() throws RemoteException, IOException {
		br = new BufferedReader(new FileReader(file));				// read in the file
		String line = null;
		
		while ((line = br.readLine()) != null) {					// whle the line is not null
			String[] el = line.split(",");							// split from the ,
			dict.put(el[0].toUpperCase(), el[1].toUpperCase());		// put the elements into the dictionary key / value

			//System.out.println(line);								// just checking
		}//while		
	}// pop dict

	public String wordSearch(String word) throws RemoteException, IOException {
		String result = "";											// the result which will be our response
		
		populateDict();
		
		if(dict.containsKey(word.toLowerCase()) || dict.containsKey(word.toUpperCase())) {								// check if the dictionary contains our word
			result = "Word: " + word + "<br>Definition: " + dict.get(word);								// set the response
		}// if 
		else {
			result = "no definition found for " + word + " :(";
		}
		return result;			// send the response back to InQueue.dispatch()
	}// wordSearch
	

}//class
