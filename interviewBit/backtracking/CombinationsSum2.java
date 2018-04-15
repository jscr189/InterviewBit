package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationsSum2 {
	public static ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		int arr[]={2,3,6,7};
		ArrayList<Integer> b=new ArrayList<Integer>();
		for(int i:arr)
			b.add(i);
		System.out.println(combinationSum(b,9));
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		combinationSumRecur(A, B,new ArrayList<Integer>(),0);
		return res;
    }

	private static boolean combinationSumRecur(ArrayList<Integer> a, int b, ArrayList<Integer> aux,int sum) {
		if(sum==b&&!res.contains(aux))
			res.add(aux);
		else if(sum<b)
		{
			ArrayList<Integer> p=new ArrayList<Integer>(a);
			while(p.size()>0)
			{
				ArrayList<Integer> q=new ArrayList<Integer>(aux);
				q.add(p.get(0));
				int newSum=sum+p.get(0);
				p.remove(0);
				boolean flag=combinationSumRecur(p, b, q, newSum);
				if(!flag)
					break;
			}
		}
		else
			return false;
		return true;
	}

}
