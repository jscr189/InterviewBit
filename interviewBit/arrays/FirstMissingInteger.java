package interviewBit.arrays;

import java.util.HashSet;

public class FirstMissingInteger {

	public static void main(String[] args) {
		int A[]={2,4,3,1};
		System.out.println(firstMissingPositive(A));
	}
	
	public static int firstMissingPositive(int[] A) {
		int min=1;
		HashSet<Integer> hs=new HashSet<Integer>();
		for(int i=0;i<A.length;i++)
		{
			if(A[i]>0&&A[i]<=A.length&&A[i]!=min)
			{
				hs.add(A[i]);
			}
			else if(A[i]>0&&A[i]<=A.length&&A[i]==min)
			{
				do
				{
					min++;
				}while(hs.contains(min));
			}
				
		}
		return min;
    }

}
