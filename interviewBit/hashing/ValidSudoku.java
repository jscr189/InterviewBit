package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {

	public static void main(String[] args) {
		List<String> A=Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79");
		System.out.println(isValidSudoku(A));
	}
	
	public static int isValidSudoku(final List<String> A) {
		ArrayList<ArrayList<Character>> a=new ArrayList<ArrayList<Character>>();
		int row=0;
		for(String s:A)
		{
			a.add(new ArrayList<Character>());
			for(int i=0;i<s.length();i++)
				a.get(row).add(s.charAt(i));
			row++;
		}
		return isValid(a);
    }

	private static int isValid(ArrayList<ArrayList<Character>> a) {
		HashSet<Character> hs=new HashSet<Character>();
		for(int i=0;i<9;i++)
		{
			hs=new HashSet<Character>();
			for(int j=0;j<9;j++)
			{
				if(a.get(i).get(j)!='.')
				{
					if(hs.contains(a.get(i).get(j)))
						return 0;
					else
						hs.add(a.get(i).get(j));
				}
			}
		}
		for(int i=0;i<9;i++)
		{
			hs=new HashSet<Character>();
			for(int j=0;j<9;j++)
			{
				if(a.get(j).get(i)!='.')
				{
					if(hs.contains(a.get(j).get(i)))
						return 0;
					else
						hs.add(a.get(j).get(i));
				}
			}
		}
		for(int i=0;i<9;i=i+3)
		{
			for(int j=0;j<9;j=j+3)
			{
				int p=i,q=j;
				hs=new HashSet<Character>();
				while(p<i+3)
				{
					q=j;
					while(q<j+3)
					{
						if(a.get(p).get(q)!='.')
						{
							if(hs.contains(a.get(p).get(q)))
								return 0;
							else
								hs.add(a.get(p).get(q));
						}
						q++;
					}
					p++;
				}
			}
		}
		return 1;
	}

}
