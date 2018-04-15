package interviewBit.backtracking;

import java.util.ArrayList;

public class Permutations {
	public static ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		int arr[]={1,2,3,4};
		ArrayList<Integer> b=new ArrayList<Integer>();
		for(int i:arr)
			b.add(i);
		System.out.println(permute(b));
	}
	
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		permuteRec(A, new ArrayList<Integer>());
		return ans;
    }
	
	public static void permuteRec(ArrayList<Integer> A,ArrayList<Integer> B) {
		if(A.size()==1)
		{
			B.add(A.get(0));
			ans.add(B);
		}
		else
		{
			for(int i=0;i<A.size();i++)
			{
				ArrayList<Integer> D=new ArrayList<Integer>(B);
				B.add(A.get(i));
				ArrayList<Integer> C=new ArrayList<Integer>(A);
				C.remove(i);
				permuteRec(C,B);
				B=D;
			}
		}
		
    }
	
}
