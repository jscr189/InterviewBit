package interviewBit.arrays;

import java.util.LinkedList;

public class AntiDiagonals {

	public static void main(String[] args) {
		int[][] A={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		A=diagonal(A);
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<A[i].length;j++)
				System.out.print(A[i][j]+" ");
			System.out.println();
		}
	}
	
	public static int[][] diagonal(int[][] A) {
		int B[][]=new int[2*A.length-1][];
		int sr=0,er=A.length,sc=0,ec=A.length;
		int k=0;
		for(int i=sc;i<ec;i++)
		{
			B[k++]=getDiagonal(A,sr,i);
		}
		sr++;
		for(int i=sr;i<er;i++)
		{
			B[k++]=getDiagonal(A,i,ec-1);
		}
		
		return B;
    }

	private static int[] getDiagonal(int[][] a, int i, int j) {
		int p=i,q=j;
		LinkedList<Integer> ll=new LinkedList<Integer>();
		while(p<a.length&&q>=0)
		{
			ll.add(a[p++][q--]);
		}
		int B[]=new int[ll.size()];
		int r=0;
		for(int x:ll)
		{
			B[r++]=x;
		}
		return B;
	}

}
