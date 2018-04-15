package interviewBit.arrays;

import java.math.BigInteger;
import java.util.TreeSet;

public class RepeatAndMissingNumberArray {

	public static void main(String[] args) {
		int A[]={3,1,2,4,3};
		
		for(int i=0;i<A.length;i++)
		{
			if(A[Math.abs(A[i])]>0)
				A[Math.abs(A[i])]=-A[Math.abs(A[i])];
			else
				System.out.println(Math.abs(A[i]));
		}
		
		A=repeatedNumber(A);
		for(int i:A)
			System.out.println(i+" ");
	}
	
	public static int[] repeatedNumber(final int[] A) {
		int[] B=new int[2];
		BigInteger calSum=BigInteger.ZERO;
		BigInteger actSum=((BigInteger.valueOf(A.length)).multiply(BigInteger.valueOf(A.length+1))).divide(BigInteger.valueOf(2));
		TreeSet<Integer> ts=new TreeSet<Integer>();
		for(int i=0;i<A.length;i++)
		{
			if(ts.add(A[i]))
				calSum=calSum.add(BigInteger.valueOf(A[i]));
			else
				B[0]=A[i];
		}
		B[1]=actSum.subtract(calSum).intValue();
		return B;
    }
	
}
