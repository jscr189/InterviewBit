package interviewBit.heapsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class NMaxPairCombinations {

	public static void main(String[] args) {
		int a[]={36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28};
		ArrayList<Integer> A=new ArrayList<Integer>();
		for(int i:a)
			A.add(i);
		ArrayList<Integer> B=new ArrayList<Integer>();
		int b[]={38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43};
		for(int i:b)
			B.add(i);
		System.out.println(solve(A, B));
	}
	
	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> al=new ArrayList<Integer>(A.size());
		
		Collections.sort(A,Collections.reverseOrder());
		Collections.sort(B,Collections.reverseOrder());
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		
		for(int i=0;i<A.size();i++)
		{
			for(int j=0;j<B.size();j++)
			{
				int sum=A.get(i)+B.get(j);
				if(pq.size()<A.size())
					pq.add(sum);
				else
				{
					if(sum>pq.peek())
					{
						pq.poll();
						pq.add(sum);
					}
					else
						break;
				}
			}
		}
		
		while(pq.size()>0)
		{
			al.add(pq.poll());
		}
		Collections.sort(al,Collections.reverseOrder());
		return al;
    }

}
