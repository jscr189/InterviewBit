package interviewBit.math;
/*
 * Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.
 * For example,
 * HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).
 * Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
 * Return the answer modulo 1000000007.
 */
public class HammingDistance {

	public static void main(String[] args) {
		//doing ^ operation sets all different bits to 1
		System.out.println("numOfBitsSet:"+numOfBitsSet(7^2));
		
		int A[]={2,4,6};
		System.out.println(hammingDistance(A));
	}
	
	public static int hammingDistance(final int[] A) {
		int count=0;
		for(int i=0;i<A.length-1;i++)
			for(int j=i+1;j<A.length;j++)
				{
					count=(count+(2*numOfBitsSet(A[i]^A[j])))%1000000007;
				}
		return count;
    }
	
	public static int numOfBitsSet(int n)
	{
		int count=0;
		while(n>0)
		{
			count+=n&1;
			n=n>>1;
		}
		return count;
	}
}
