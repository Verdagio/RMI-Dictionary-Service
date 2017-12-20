package ie.gmit.sw.ds;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.Queue;

public class InQueue implements Runnable {
	
	private Queue<String> q;
	private Worker w;
	
	public InQueue(String word) {
		w = new Worker();
		q = new LinkedList<>();
		q.add(word);
	}
	
	public void dispatch() {
		System.out.println("running. . .");

		try {

			//Thread.sleep(10000);
			
			if(q.peek() != null) { // Check that there is actually something in the queue
				
				DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
				System.out.println(ds.toString());
				
				
				System.out.println(ds.wordSearch(q.poll().toUpperCase()));
				System.out.println("dispatched");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		dispatch();

	}
}
