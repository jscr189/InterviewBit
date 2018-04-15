package interviewBit.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FindDuplicate {

	public static void main(String[] args) {
		List<Integer> A=new ArrayList<Integer>();
		A.add(3);
		A.add(4);
		A.add(1);
		A.add(4);
		A.add(1);
		System.out.println(repeatedNumber(A));

	}
	public static int repeatedNumber(final List<Integer> a) {
		TreeSet<Integer> ts=new TreeSet<Integer>();
	    for(int i:a)
	    {
	        if(!ts.add(i))
	            return i;
	    }
		return -1;
	}
	
}
