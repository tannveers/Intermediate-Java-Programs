import java.util.*;

public class index{
	public static void main(String[] args) {
		Character[] arr1 = {'t', 'a', 'n','v','e','e','r'};
		Integer[] arr2 = {1,2,3,4,5};
		
		display(arr1);
		display(arr2);
	}
	public static <T> void display(T[] x) {
		for(T a : x)System.out.printf("%s",a);
	}
}