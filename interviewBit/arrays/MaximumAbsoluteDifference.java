package interviewBit.arrays;

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		int A[]={1,3,-1};
		System.out.println("Max Sum:"+maxArr(A));
	}
	
	public static int maxArr(int[] A) {
		int maxSum=0;
		
		for(int i=0;i<A.length-1;i++)
		{
			for(int j=i+1;j<A.length;j++)
			{
				maxSum=Math.max(Math.abs(A[i]-A[j])+Math.abs(i-j),maxSum);
			}
		}
		
		return maxSum;
    }

}
