package interviewBit.math;

import java.util.ArrayList;
import java.util.Collections;

public class AllFactorsOfN {
	
	public static void main(String[] args) {
		ArrayList<Integer> al = allFactors(38808);
		System.out.println(al);
	}
	
	public static ArrayList<Integer> allFactors(int a) {
	    ArrayList<Integer> arr=new ArrayList<Integer>();
	    arr.add(1);
	    if(a!=1)
	        arr.add(a);
	    for(int i=2;i<=Math.sqrt(a);i++)
	    {
	        if(a%i==0)
	        {
	            arr.add(i);
	            if(i!=Math.sqrt(a))
	                arr.add(a/i);
	        }
	    }
	    Collections.sort(arr);
	    return arr;
	}
}
