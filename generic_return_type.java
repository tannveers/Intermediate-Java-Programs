import java.util.*;

public class index{
	
	public static void main(String[] args) {
		System.out.println(max(23,12,50));
		System.out.println(max("abc","def","bcd"));
	}
	public static <T extends Comparable<T>> T max(T a, T b, T c) {
		T max = a;
		if(b.compareTo(a)>0)max = b;
		if(c.compareTo(max)>0)max = c;
		return max;
	}
}