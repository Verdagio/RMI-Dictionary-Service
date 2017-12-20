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
	}
	
	public Map<String, String> populateDict() throws RemoteException, IOException {
			br = new BufferedReader(new FileReader(file));
			String line = null;
		// read each line of the dictionary and split on the comma populating the map with the key (word) value(definition)
			while((line = br.readLine()) != null) {
				String[] el = line.split(",");
				dict.put(el[0].toUpperCase(), el[1].toUpperCase());
				
				System.out.println(line);
			}

		return dict;
	}

	public String wordSearch(String word) throws RemoteException {
		
		return " hi " + word;
	}
}
