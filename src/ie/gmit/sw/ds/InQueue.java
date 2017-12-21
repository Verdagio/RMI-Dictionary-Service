package ie.gmit.sw.ds;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.http.HttpServletResponse;

public class InQueue implements Runnable {

	private Queue<String> q;
	private Worker w;
	private String response;

	public InQueue(String word) {
		w = new Worker();
		q = new LinkedList<>();
		q.add(word);
	}

	public void dispatch() {
		System.out.println("running. . . " + this.hashCode());
		try {
			System.out.println("Please wait. . .");
			if (q.peek() != null) { // Check that there is actually something in the queue
				System.out.println("Pulling request from Queue. . .");
				DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService"); // get remote obj
				System.out.println("Dispatching job to remote object");
				this.response = ds.wordSearch(q.poll().toUpperCase()); // get the response
				System.out.println(response); // checking what the result is here
			} else {
				System.out.println("Que empty... ");
			} // if else the queue is populated
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try cactch
		
	}// dispatch method
	
	public String getResponse() {
		return response;
	}

	public void run() {
		dispatch();
	}
}
