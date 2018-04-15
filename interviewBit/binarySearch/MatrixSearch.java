package interviewBit.binarySearch;

import java.util.ArrayList;

public class MatrixSearch {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>() {
			 {
			    add(1);
			    add(2);
			    add(3);
			    add(4);
			    add(5);
			    add(6);
			    add(7);
			    add(8);
			 }
			};
			matrix.add(row);
		System.out.println(searchMatrix(matrix,15));

	}
	public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		int l=0,r=a.size()*a.get(0).size();
		while(l<=r)
		{
			int m=(l+r)/2;
			int el=a.get(m/a.get(0).size()).get(m%a.get(0).size());
			if(el==b)
			{
				return 1;
			}
			else if(el<b)
			{
				l=m+1;
			}
			else if(el>b)
				r=m-1;
		}
		return 0;
	}
}
