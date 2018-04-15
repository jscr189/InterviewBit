package interviewBit.arrays;

public class MaxSumContiguousSubArray {

	public static void main(String[] args) {
			int A[]={-2,1,-3,4,-1,4,1,5,4};
			System.out.println("Max Sum:"+maxSubArray(A));
	}
	
	public static int maxSubArray(final int[] A) {
		int maxSum=A[0],maxTillIndexI=A[0];
		for(int i=1;i<A.length;i++)
		{
			maxTillIndexI=Math.max(maxTillIndexI+A[i], A[i]);
			maxSum=Math.max(maxTillIndexI, maxSum);
		}
		
		return maxSum;
    }

}
