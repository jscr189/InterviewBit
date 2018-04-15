package interviewBit.arrays;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		int A[]={1, 2, 5, -7, 2, 3,2,1};
		A=maxset(A);
		for(int i:A)
			System.out.println(i+" ");
	}
	
	public static int[] maxset(int[] A) {
		long maxSum=0,newSum=0;
		LinkedList<Integer> maxList=new LinkedList<Integer>();
		LinkedList<Integer> newList=new LinkedList<Integer>();
		for(int i=0;i<A.length;i++)
		{
			if(A[i]>=0)
			{
				newList.add(A[i]);
				newSum+=(long)A[i];
			}
			if(A[i]<0||i==A.length-1)
			{
				if(maxSum<newSum)
				{
					maxSum=newSum;
					maxList=newList;
				}
				else if(maxSum==newSum)
				{
					if(maxList.size()<newList.size())
					{
						maxList=newList;
					}
				}
				newSum=0;
				newList=new LinkedList<Integer>();
			}
		}
		
		int B[]=new int[maxList.size()];
		int j=0;
		for(int i:maxList)
			B[j++]=i;
		
		return B;
    }

}
