package interviewBit.arrays;

import java.util.TreeSet;

public class MaxConsecutiveGap {

	public static void main(String[] args) {
		int[] A={1,10,5};
		System.out.println(maximumGap(A));
	}
	
	public static int maximumGap(final int[] A) {
		int ret=0,min=-1,max=-1;
		if(A.length<2)
			return 0;
		TreeSet<Integer> ts=new TreeSet<Integer>();
		for(int j:A)
			ts.add(j);
		int old=-1;
		for(int i:ts)
		{
			if(min==-1)
				min=i;
			else if(max==-1)
			{
				max=i;
				ret=max-min;
			}
			else
			{
				if (i-old > ret) {
					min = max;
					ret = i-old;
					max = i;
				}
			}
			old=i;
		}
		
				
		return ret;
    }

}
