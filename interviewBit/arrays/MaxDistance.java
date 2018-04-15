package interviewBit.arrays;

import java.util.TreeMap;

public class MaxDistance {

	public static void main(String[] args) {
		int[] A={-1,-1,-1 };
		System.out.println(maximumGap(A));

	}
	
	public static int maximumGap(final int[] A) {
		if(A.length==0)
			return -1;
        if(A.length==1)
			return 0;
        TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
		for(int i=0;i<A.length;i++)
		{
			if(!tm.containsKey(A[i]))
				tm.put(A[i], i+1);
		}
		if(tm.size()==1&&A.length>1)
			return A.length-1;
		int minKey=Integer.MIN_VALUE,max=0;
		for(Integer i:tm.keySet())
		{	
			if(minKey==Integer.MIN_VALUE||tm.get(minKey)>tm.get(i))
				minKey=i;
			else
			{
				if(tm.get(minKey)<tm.get(i))
					max=Math.max(max, tm.get(i)-tm.get(minKey));
			}
		}
		return max;
    }

}
