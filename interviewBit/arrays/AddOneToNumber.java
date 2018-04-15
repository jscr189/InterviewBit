package interviewBit.arrays;

public class AddOneToNumber {

	public static void main(String[] args) {
		int A[]={9,9,9,9};
		A=plusOne(A);
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
	}
	
	public static int[] plusOne(int[] A) {
		int leadingZeroes=0;
		for(int i=0;i<A.length&&A[i]==0;i++)
		{
			leadingZeroes++;
		}
		if(leadingZeroes!=0)
		{
			int B[]=new int[A.length-leadingZeroes];
			for(int j=leadingZeroes;j<A.length;j++)
				B[j-leadingZeroes]=A[j];
			A=B;
		}
		int carry=1;
		for(int i=A.length-1;i>=0&&carry!=0;i--)
		{
				if(A[i]==9)
				{
					A[i]=0;
					carry=1;
				}
				else
				{
					A[i]++;
					carry=0;
				}
		}
		if(carry!=0)
		{
			int B[]=new int[A.length+1];
			B[0]=carry;
			for(int j=1;j<=A.length;j++)
				B[j]=A[j-1];
			carry=0;
			A=B;
		}
		
		return A;
    }

}
