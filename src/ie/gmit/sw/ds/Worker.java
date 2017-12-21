package ie.gmit.sw.ds;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Worker {
	
	public Worker() {}
	
	public static void main(String[]args) throws Exception {
		
		DictionaryService stub = new DictionaryServiceImpl("dictionary.txt"); // load the dictionary into the obj	
		LocateRegistry.createRegistry(1099);								// set the service active on this port
		Naming.rebind("dictionaryService", stub);							// add the dictionary service to the lookup table	
		System.out.println("Server " +stub+" Ready");
	}//main
}//class
