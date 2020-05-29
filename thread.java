//MAIN CLASS


public class tannveers {
	public static void main(String args[]) {
		Thread t1 = new Thread(new index("First"));
		Thread t2 = new Thread(new index("Second"));
		Thread t3 = new Thread(new index("Third"));
		Thread t4 = new Thread(new index("Fourth"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}




//THREAD CLASS

import java.util.*;

public class index implements Runnable{

	String name;
	int time;
	Random r = new Random();
	
	public index(String x) {
		name = x;
		time = r.nextInt(999);
	}
	public void run() {
		try {
			System.out.printf("%s is sleeping for %d",name,time);
			System.out.println();
			Thread.sleep(time);
			System.out.printf("%s is done",name);
			System.out.println();
		}
		catch(Exception e) {
			
		}
	}
	
}