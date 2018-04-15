package interviewBit.backtracking;

import java.util.ArrayList;

public class NQueensProblem {
	public static ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
	public static void main(String[] args) {
		System.out.println(solveNQueens(4));
	}
	
	public static ArrayList<ArrayList<String>> solveNQueens(int a) {
		ArrayList<ArrayList<String>> al1=new ArrayList<ArrayList<String>>();
		for(int i=0;i<a;i++)
		{
			al1.add(new ArrayList<String>());
			for(int j=0;j<a;j++)
				al1.get(i).add(".");
		}
		solveNQueensRecur(al1,a,0);
		return res;
	}

	private static void solveNQueensRecur(ArrayList<ArrayList<String>> al, int a,int row) {
		ArrayList<ArrayList<String>> al1= new ArrayList<ArrayList<String>>(al.size());
		for(ArrayList<String> al2:al)
			al1.add((ArrayList<String>) al2.clone());
		for(int i=0;i<a;i++)
		{
			al1.get(row).set(i, "Q");
			if(isMoveValid(al1))
			{
				if(row==a-1)
					res.add(convert(al1));
				else
					solveNQueensRecur(al1, a, row+1);
			}
			al1= new ArrayList<ArrayList<String>>(al.size());
			for(ArrayList<String> al2:al)
				al1.add((ArrayList<String>) al2.clone());
		}
		
	}

	private static ArrayList<String> convert(ArrayList<ArrayList<String>> al1) {
		ArrayList<String> al=new ArrayList<String>();
		int n=al1.size();
		for(int i=0;i<n;i++)
		{
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<n;j++)
				sb.append(al1.get(i).get(j));
			al.add(sb.toString());
		}
			
		return al;
	}

	private static boolean isMoveValid(ArrayList<ArrayList<String>> al1) {
		int n=al1.size();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(al1.get(i).get(j).equals("Q"))
				{
					int p=i+1;
					while(p<n)
					{
						if(al1.get(p++).get(j).equals("Q"))
							return false;
					}
					p=i+1;
					int q=j+1;
					while(p<n&&q<n)
					{
						if(al1.get(p++).get(q++).equals("Q"))
							return false;
					}
					p=i-1;
					q=j+1;
					while(p>=0&&q<n)
					{
						if(al1.get(p--).get(q++).equals("Q"))
							return false;
					}
				}
			}
		}
		return true;
	}

}
