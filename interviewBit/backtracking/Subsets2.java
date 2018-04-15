package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets2 {
	public static ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		int arr[]={1,2,2};
		ArrayList<Integer> b=new ArrayList<Integer>();
		for(int i:arr)
			b.add(i);
		System.out.println(subsets(b));
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		Collections.sort(A);
		res.add(new ArrayList<Integer>());
		subsetsRecur(A,new ArrayList<Integer>());
				
		return res;
    }

	public static boolean subsetsRecur(ArrayList<Integer> A,ArrayList<Integer> B) {
		if(A.size()==0)
			return false;
		else
		{
			ArrayList<Integer> C=new ArrayList<Integer>(A);
			while(C.size()>0)
			{
				ArrayList<Integer> D=new ArrayList<Integer>(B);
				D.add(C.get(0));
				if(!res.contains(D))
					res.add(D);
				C.remove(0);
				boolean flag=subsetsRecur(C,D);
				if(!flag)
					break;
			}
		}
		return true;
	}

}
