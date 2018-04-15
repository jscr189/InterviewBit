package interviewBit.arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class MinStepsInInfiniteGrid {

	public static void main(String[] args) {
		final int A[]={4, 8, -7, -5, -13, 9, -7, 8};
		final int B[]={4, -15, -10, -3, -13, 12, 8, -8};
		System.out.println("Min Steps:"+coverPoints(A, B));
	}
	
	public static int coverPoints(int[] A, int[] B) {
		int count=0;
		
		for(int i=0;i<A.length-1;i++)
		{
			count+=stepsNeeded(A[i],B[i],A[i+1],B[i+1]);
		}
		
		return count;
    }
	
	private static int stepsNeeded(int srcX, int srcY, int destX, int destY) {
		return Math.max(Math.abs(destX-srcX), Math.abs(destY-srcY));
	}

}
