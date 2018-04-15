package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class Sudoku {
	public static ArrayList<ArrayList<Character>> res=new ArrayList<ArrayList<Character>>();
	public static void main(String[] args) {
		ArrayList<ArrayList<Character>> a=new ArrayList<ArrayList<Character>>();
		String arr[]={"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
		//String arr[]={"...4","2...","..2.",".4.2"};
		int row=0;
		for(String s:arr)
		{
			a.add(new ArrayList<Character>());
			for(int i=0;i<s.length();i++)
				a.get(row).add(s.charAt(i));
			row++;
		}
		solveSudoku(a);
		System.out.println(a);
	}
	
	public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
		solveSudokuRecur(a);
		for(int i=0;res.size()>0&&i<a.size();i++)
			for(int j=0;j<a.get(i).size();j++)
				a.get(i).set(j, res.get(i).get(j));
	}

	private static void solveSudokuRecur2(ArrayList<ArrayList<Character>> a,int row) {
		int y=row;
		if(res.size()>0)
			return;
		ArrayList<ArrayList<Character>> b=new ArrayList<ArrayList<Character>>(a.size());
		for(ArrayList<Character> al:a)
			b.add((ArrayList<Character>) al.clone());
		ArrayList<Character> c=new ArrayList<Character>();
		for(int i=1;i<=a.get(row).size();i++)
		{
			c.add((char)('0'+i));
		}
		for(int i=0;i<a.get(row).size();i++)
		{
			c.remove(a.get(row).get(i));
		}
		for(int i=0;row<b.size()&&i<b.get(row).size()&&res.size()==0;i++)
		{
			ArrayList<Character> d=new ArrayList<Character>(c);
			if(b.get(row).get(i)=='.')
			{
				char x=d.get(0);
				d.remove(0);
				b.get(row).set(i, x);
				if(isMoveValid(b))
				{
					if(d.size()==0)
						row++;
					if(row==b.size())
					{
						res=b;
						break;
					}
					else
						solveSudokuRecur2(b, row);
				}
				else
				{
					b=new ArrayList<ArrayList<Character>>(a.size());
					for(ArrayList<Character> al:a)
						b.add((ArrayList<Character>) al.clone());
					row=y;
					i--;
				}
			}
		}
		
	}
	
	private static boolean solveSudokuRecur(ArrayList<ArrayList<Character>> a) {
		int row=-1,col=-1;
		for(int i=0;i<a.size();i++)
		{
			for(int j=0;j<a.get(i).size();j++)
				if(a.get(i).get(j)=='.')
				{
					row=i;col=j;
					break;
				}
			if(row!=-1&&col!=-1)
				break;
		}
		if(row==-1&&col==-1){
			res=a;
			return true;
		}
		
		for(int k=1;k<=a.size();k++)
		{
			if(isMoveValid(a,row,col,k))
			{
				a.get(row).set(col, (char)('0'+k));
				if(solveSudokuRecur(a))
					return true;
				a.get(row).set(col, '.');
			}
		}
		return false;
	}

	
	private static boolean isMoveValid(ArrayList<ArrayList<Character>> a, int row, int col, int k) {
		ArrayList<ArrayList<Character>> b=new ArrayList<ArrayList<Character>>(a.size());
		for(ArrayList<Character> al:a)
			b.add((ArrayList<Character>) al.clone());
		b.get(row).set(col, (char)('0'+k));
		for(int i=0;i<b.size();i++)
		{
			HashSet<Character> hs=new HashSet<Character>();
			for(int j=0;j<b.size();j++)
			{
				char c=b.get(j).get(i);
				if(c!='.')
				{
					if(hs.contains(c))
						return false;
					else
						hs.add(c);
				}
			}
		}
		for(int i=0;i<b.size();i++)
		{
			HashSet<Character> hs=new HashSet<Character>();
			for(int j=0;j<b.size();j++)
			{
				char c=b.get(i).get(j);
				if(c!='.')
				{
					if(hs.contains(c))
						return false;
					else
						hs.add(c);
				}
			}
		}
		HashSet<Character> hs=new HashSet<Character>();
		for(int i=row-row%3,r=0;r<3;r++)
		{
			for(int j=col-col%3,c=0;c<3;c++)
			{
				char ch=b.get(i+r).get(j+c);
				if(ch!='.')
				{
					if(hs.contains(ch))
						return false;
					else
						hs.add(ch);
				}
			}
		}
		return true;
	}

	private static void solveSudokuRecur1(ArrayList<ArrayList<Character>> a,int row) {
		int y=row;
		if(res.size()>0)
			return;
		ArrayList<ArrayList<Character>> b=new ArrayList<ArrayList<Character>>(a.size());
		for(ArrayList<Character> al:a)
			b.add((ArrayList<Character>) al.clone());
		ArrayList<Character> c=new ArrayList<Character>();
		for(int i=1;i<=a.get(row).size();i++)
		{
			c.add((char)('0'+i));
		}
		for(int i=0;i<a.get(row).size();i++)
		{
			c.remove(a.get(row).get(i));
		}
		
		ArrayList<Character> d=new ArrayList<Character>(c);
		int i=0;
		while(d.size()>0)
		{
			if(i<a.size()&&b.get(row).get(i)=='.')
			{
				char x=d.get(0);
				d.remove(0);
				b.get(row).set(i, x);
				if(isMoveValid(b))
				{
					i=0;
					if(d.size()==0)
						row++;
					if(row==b.size())
					{
						res=b;
						break;
					}
					else
						solveSudokuRecur1(b, row);
				}
				else
				{
					b=new ArrayList<ArrayList<Character>>(a.size());
					for(ArrayList<Character> al:a)
						b.add((ArrayList<Character>) al.clone());
					if(c.size()!=1)
						d=new ArrayList<Character>(c);
					row=y;
					i++;
				}
			}
			else if(i>=a.size()&&d.size()>0)
				i=0;
			else
				i++;
		}
		
	}
	
	
	private static boolean isMoveValid(ArrayList<ArrayList<Character>> b) {
		for(int i=0;i<b.size();i++)
		{
			HashSet<Character> hs=new HashSet<Character>();
			for(int j=0;j<b.size();j++)
			{
				char c=b.get(j).get(i);
				if(c!='.')
				{
					if(hs.contains(c))
						return false;
					else
						hs.add(c);
				}
			}
		}
		return true;
	}

}
