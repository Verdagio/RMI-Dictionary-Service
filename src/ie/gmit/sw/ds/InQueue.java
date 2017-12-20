package ie.gmit.sw.ds;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.Queue;

public class InQueue implements Runnable {

	private Queue<String> q;
	private Worker w;
	private boolean complete;

	public InQueue(String word) {
		w = new Worker();
		q = new LinkedList<>();
		q.add(word);
		complete = false;
	}

	public void dispatch() {

		System.out.println("running. . .");
		try {
			System.out.println("Please wait. . .");
			// Thread.sleep(10000);

			if (q.peek() != null) { // Check that there is actually something in the queue
				System.out.println("Pulling request from Queue. . .");
				// get a remote object
				DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
				do {
					if (ds.isReadyState()) { // check its state
						System.out.println("Dispatching job to remote object");
						System.out.println(ds.wordSearch(q.poll().toUpperCase())); // checking what the result is here
						System.out.println("dispatched"); // Confirmation
						complete = true;
					} else {
						ds.populateDict(); // empty dictionary needs to be populated
						System.out.println("Populating Dictionary. . . ");
					} // if else
				} while (!complete); // do while not complete
			} else {
				System.out.println("Que empty... ");
			} // if else the queue is populated
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try cactch

	}// dispatch method

	public void run() {
		dispatch();

	}
}
