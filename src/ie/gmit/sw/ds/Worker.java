package ie.gmit.sw.ds;

public class Worker {

	private boolean isReady;
	private DictionaryServiceImpl dsi;
	
	public Worker() {
		isReady = true;
	}
	
	public boolean onReadyState() {	
		return isReady;
	}
	
	public void receiveItem(String s) throws InterruptedException {

		
		
		
		
	}
	
	
}
