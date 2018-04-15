package interviewBit.bitManipulation;

import java.util.Arrays;

public class MinXor {

	public static void main(String[] args) {
		int A[] = { 1000000000, 400000000, 700000000, 900000000 };
		System.out.println(findMinXor(A));
	}

	public static int findMinXor(int[] A) {
		int min=Integer.MAX_VALUE;
		Arrays.sort(A);
		for(int i=0;i<A.length-1;i++)
		{
			int x=Integer.MAX_VALUE;
			if(A[i]==0)
				x=A[i+1];
			else if(A[i+1]==0)
				x=A[i];
			else
				x=A[i]^A[i+1];
			
			if(x<min)
			{
				min=x;
			}
		}
		return min;
	}

}
