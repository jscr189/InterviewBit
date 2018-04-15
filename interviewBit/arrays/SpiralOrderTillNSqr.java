package interviewBit.arrays;

import java.util.LinkedList;

public class SpiralOrderTillNSqr {
	public static void main(String[] args) {
		int spriralOrder[][]=generateMatrix(3);
		for(int i=0;i<spriralOrder.length;i++)
			for(int j=0;j<spriralOrder[i].length;j++)
				System.out.print(spriralOrder[i][j]+" ");
	}
	
	public static int[][] generateMatrix(int A) {
		int[][] arr=new int[A][A];
		int k=1,sr=0,sc=0,er=A-1,ec=A-1,p=0,q=0;
		while(k<=A*A)
		{
			for(int i=sc;i<=ec;i++)
				arr[sr][i]=k++;
			sr++;
			for(int i=sr;i<=er;i++)
				arr[i][ec]=k++;
			ec--;
			for(int i=ec;i>=sc;i--)
				arr[er][i]=k++;
			er--;
			for(int i=er;i>=sr;i--)
				arr[i][sc]=k++;
			sc++;			
		}
		
		return arr;
    }

}
