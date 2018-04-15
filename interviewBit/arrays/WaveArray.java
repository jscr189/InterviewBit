package interviewBit.arrays;

import java.util.Arrays;

public class WaveArray {

	public static void main(String[] args) {
		int[] A={1,2,3,5};
		A=wave(A);
		for(int i=0;i<A.length;i++)
			System.out.println(A[i]+" ");

	}
	
	public static int[] wave(int[] A) {
		int min;
		Arrays.sort(A);
		for(int i=0;(i+1)<A.length;i+=2)
		{
			int tmp=A[i];
			A[i]=A[i+1];
			A[i+1]=tmp;
		}
		return A;
    }
}
