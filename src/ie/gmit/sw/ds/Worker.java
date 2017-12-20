package ie.gmit.sw.ds;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Worker {
	
	public Worker() {}
	
	public static void main(String[]args) throws Exception{
		
		DictionaryService stub = new DictionaryServiceImpl("dictionary.txt");
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("dictionaryService", stub);	
		
		System.out.println("Server " +stub+" Ready");
		
	}//main
	
	
}
