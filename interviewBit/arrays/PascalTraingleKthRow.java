package interviewBit.arrays;

public class PascalTraingleKthRow {
	public static void main(String[] args) {
		int pascal[]=getRow(7);
			for(int j=0;j<pascal.length;j++)
				System.out.print(pascal[j]+" ");
			System.out.println();

	}
	
	public static int[] getRow(int A) {
		int arr[][]=new int[A][];
		for(int i=0;i<A;i++)
		{
			arr[i]=new int[i+1];
			arr[i][0]=arr[i][i]=1;
			if(i>=2)
			{
				for(int j=1;j<i;j++)
				{
					arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
				}
			}
		}
		return arr[A-1];
    }
}
