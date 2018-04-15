package interviewBit.arrays;

import java.util.Arrays;

public class NobleInteger {

	public static void main(String[] args) {
		int[] A={-4, -2, 0, -1, -6};
		System.out.println(solve(A));
	}
	
	public static int solve(int[] A) {
		int x=-1;
		Arrays.sort(A);
		for(int i=0;i<A.length-1;i++)
		{
			if(A[i]<A[i+1]&&A[i]==A.length-i-1)
				return 1;
		}
		if(A[A.length-1]==0)
		    return -1;
		
		return x;
    }

}
