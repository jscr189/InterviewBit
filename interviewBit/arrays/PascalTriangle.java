package interviewBit.arrays;

public class PascalTriangle {

	public static void main(String[] args) {
		int pascal[][]=generate(7);
		for(int i=0;i<pascal.length;i++)
		{
			for(int j=0;j<pascal[i].length;j++)
				System.out.print(pascal[i][j]+" ");
			System.out.println();
		}

	}
	
	public static int[][] generate(int A) {
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
		return arr;
    }

}
