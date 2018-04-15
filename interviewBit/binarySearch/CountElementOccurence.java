package interviewBit.binarySearch;

public class CountElementOccurence {

	public static void main(String[] args) {
		int arr[]={5,7,7,7,8,8,9,10};
		System.out.println(findCount(arr,8));
	}
	
	public static int findCount(final int[] A, int B) {
		int count=0,l=0,r=A.length-1;
		return binarySearch(A,B,l,r,count);
    }
	public static int binarySearch(int[] A,int B,int l,int r,int count)
	{
		while(l<=r)
		{
			int m=(l+r)/2;
			if(A[m]==B)
			{
				count++;
				count=binarySearch(A,B,l,m-1,count);
				count=binarySearch(A,B,m+1,r,count);
				return count;
			}
			else if(A[m]<B)
				l=m+1;
			else if(A[m]>B)
				r=m-1;
		}
		return count;
	}
}
