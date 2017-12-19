package ie.gmit.sw.ds;

import java.util.Map;

public class Worker {

	private boolean isReady;
	
	
	public Worker() {
		isReady = true;
	}
	
	public boolean onReadyState() {	
		return isReady;
	}
	
	public Map<String, String> receiveItem(String word) throws InterruptedException {
		
		// set is ready to false
		
		// get the string being passed in and compare it against dictionary service remote object
		
		// create a temp object and store word & definition
		
		// return the key value pair from dictionary service
		
		
		return null;
	}//receive item
	
	
}
