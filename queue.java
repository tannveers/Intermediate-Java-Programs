import java.util.*;

public class index{
	public static void main(String[] args) {
		
		// The "offer" sets the priority queue in alphabetical order, and acts accordingly.
		
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.offer("alpha");
		q.offer("channel");
		q.offer("alphb");
		
		System.out.printf("%s",q);
		System.out.println();
		
		q.poll();
		System.out.printf("%s",q);

		System.out.println();
		
		q.poll();
		System.out.printf("%s",q);
	
		
	}
}