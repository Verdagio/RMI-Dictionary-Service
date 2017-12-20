package ie.gmit.sw.ds;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface DictionaryService extends Remote{
	
	public String wordSearch(String s) throws RemoteException;
	public Map<String, String> populateDict() throws RemoteException, IOException;
	public boolean isReadyState();
}
