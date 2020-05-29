import java.util.*;

public class index{
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0 ; i<6 ; i++)s.push(i);
		System.out.println(s);
		while(!s.empty()) {
			s.pop();
			System.out.println("Element popped");
		}
	}
}