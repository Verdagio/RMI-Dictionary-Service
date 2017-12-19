package ie.gmit.sw.ds;

import java.io.BufferedReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {

	private static final long serialVersionUID = 1L;
	private Map<String, String> dict;
	private BufferedReader br;

	protected DictionaryServiceImpl() throws RemoteException {
		super();
		dict = new HashMap<>();
	}

	public String wordSearch(String word) throws RemoteException {
		
		
		
		return " ";
	}
}
