package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {
	public static ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		System.out.println(combine(4,3));
	}
	
	public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=1;i<=A;i++)
			al.add(i);
		combineRec(al,B,new ArrayList<Integer>());
		return res;
    }

	private static void combineRec(ArrayList<Integer> a, int b,ArrayList<Integer> aux) {
		if(aux.size()==b)
			res.add(aux);
		else
		{
			ArrayList<Integer> p=new ArrayList<Integer>(a);
			while(p.size()>0)
			{
				ArrayList<Integer> q=new ArrayList<Integer>(aux);
				q.add(p.get(0));
				p.remove(0);
				combineRec(p, b, q);
			}
		}
	}
	

}
