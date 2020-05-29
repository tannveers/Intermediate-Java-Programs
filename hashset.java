import java.util.*;

public class index{
	public static void main(String[] args) {
		String[] names = {"Adam", "ed", "Bob", "Adam", "Sheeran"};
		List<String> ls = Arrays.asList(names);
		Set<String> s = new HashSet<String>(ls);
		System.out.println(s);
	}
}