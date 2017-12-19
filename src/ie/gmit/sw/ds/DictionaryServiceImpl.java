package ie.gmit.sw.ds;

import java.io.BufferedReader;
import java.io.File;
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

	public DictionaryServiceImpl() throws RemoteException {
		super();
		dict = new HashMap<>();
	}
	public void populateDict() {
		String line = null;
		String[] el;
		
		// read each line of the dictionary and split on the comma populating the map with the key (word) value(definition)
		try {
			while((line = br.readLine()) != null) {
				el =  line.split(",");
				dict.put(el[0], el[1]);
				
				System.out.println(el);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String wordSearch(String word) throws RemoteException {
		
		
		
		return " ";
	}
}
