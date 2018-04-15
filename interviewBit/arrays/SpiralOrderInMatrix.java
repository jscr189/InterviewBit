package interviewBit.arrays;

import java.util.Arrays;

public class SpiralOrderInMatrix {

	public static void main(String[] args) {
		final int[][] A={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<A[i].length;j++)
				System.out.print(A[i][j]+" ");
			System.out.println();
		}
		
		int spriralOrder[]=spiralOrder(A);
		for(int j=0;j<spriralOrder.length;j++)
			System.out.print(spriralOrder[j]+" ");
	}
	
	public static int[] spiralOrder(final int[][] A) {
		int rowsEn=A.length;
		int colsEn=A[0].length;
		int spriralOrder[]=new int[rowsEn*colsEn];
		int k=0,i=0,j=0,rowsSt=0,colsSt=0;
		while(k<spriralOrder.length)
		{
			if(A[i][j]!=-1)
			{
				if(i==rowsSt&&j==colsSt)
				{
					spriralOrder[k++]=A[i][j];
					//System.out.println(A[i][j]);
					while(j<colsEn-1&&k<spriralOrder.length)			
					{
						spriralOrder[k++]=A[i][++j];
						//System.out.println(A[i][j]);
						A[i][j]=-1;
					}
				}
				
				if(i==rowsSt&&j==colsEn-1)
				{
					while(i<rowsEn-1&&k<spriralOrder.length)			
					{
						spriralOrder[k++]=A[++i][j];
						//System.out.println(A[i][j]);
						A[i][j]=-1;
					}
					rowsSt++;
				}
				
				if(i==rowsEn-1&&j==colsEn-1)
				{
					while(j>colsSt&&k<spriralOrder.length)			
					{
						spriralOrder[k++]=A[i][--j];
						//System.out.println(A[i][j]);
						A[i][j]=-1;
					}
					colsEn--;
				}
				
				
				if(i==rowsEn-1&&j==colsSt)
				{
					while(i>rowsSt&&k<spriralOrder.length)			
					{
						spriralOrder[k++]=A[--i][j];
						//System.out.println(A[i][j]);
						A[i][j]=-1;
					}
					rowsEn--;j++;colsSt++;
				}
				
			}
		}
		
		return spriralOrder;
    }

}
