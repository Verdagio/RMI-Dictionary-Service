package ie.gmit.sw.ds;

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
		int i =0;
		try {
			do {
			Thread.sleep(1000);
			System.out.println(i);
			i++;
			} while(!w.onReadyState());
			
			if(q.peek() != null) { // Check that there is actually something in the queue
				System.out.println(q.poll().toString() + " dispatched");
				w.receiveItem(q.poll().toString().toUpperCase()); // send the item to the worker
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		System.out.println("running. . .");
		dispatch();
	}
}
