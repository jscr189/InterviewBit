package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MaxContinuousSeriesOfOnes {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(1);c.add(1);c.add(0);c.add(1);c.add(1);c.add(0);c.add(1);c.add(1);c.add(0);c.add(1);c.add(1);c.add(1);c.add(1);c.add(1);
		System.out.println(maxone(c,2));	
		}
	
	public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
	    
	    int m = b;
	    int msum = 0;
	    int s = 0, ms = 0, me = 0;
	    for(int i = 0; i < a.size(); i++){
	        if(a.get(i) == 0 && m > 0)
	            m--;
	        else if(a.get(i) == 0){
	            while(a.get(s) != 0 && s < i)
	                s++;
	            s++;
	        }
	        if(i - s + 1 > msum){
	           ms = s;
	           me = i;
	           msum = i - s + 1;
	       }
	    }
	    for(int i = ms; i <= me; i++)
	        ans.add(i);
	    return ans;
    }

}
