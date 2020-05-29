import java.util.*;

public class index{
	public static void main(String[] args) {
	String[] arr = {"Dennis", "Ed","Justin", "Drake"};
	String[] ar2 = {"GFY", "Perfect", "Sorry", "In my Feelings"};
	
	//converting array to list
	List<String> l1 = Arrays.asList(arr);
	
	System.out.println(l1);
	
	//sorting the list
	
	Collections.sort(l1);
	
	//sorting a list : reverse order
	Collections.sort(l1, Collections.reverseOrder());
	
	//converting list to array
	String[] temp = l1.toArray(new String[l1.size()]);
	
	for(String a : temp)
		System.out.println(a);
	
	List<String> l2 = Arrays.asList(ar2);
	ArrayList<String> l3 = new ArrayList<String>();
	
	for(String x : ar2)l3.add(x);
	
	//Replacing all elements of list with desired element 
	Collections.fill(l2,"X");
	System.out.println(l2);
	
	//appending elements of one list to another list
	Collections.addAll(l3,ar2);
	System.out.println(l3);
		
	//Count occurence of an element in the list
	System.out.println(Collections.frequency(l2, "X"));
	}

	
	
}