package interviewBit.backtracking;

import java.util.ArrayList;

public class LetterCombinations {
	public static ArrayList<String> arr=new ArrayList<String>();
	public static void main(String[] args) {
		System.out.println(letterCombinations("304"));
	}
	
	public static ArrayList<String> letterCombinations(String A) {
		ArrayList<ArrayList<String>> al=new ArrayList<ArrayList<String>>();
		for(int i=0;i<A.length();i++)
		{
			al.add(letterCombinations((int)(A.charAt(i)-'0')));
		}
		
		letterCombinationsRec(al,0,0,new StringBuilder());
		
		return arr;
    }
	
	private static void letterCombinationsRec(ArrayList<ArrayList<String>> al,int button,int ind,StringBuilder sb) {
		if(sb.length()==al.size())
			arr.add(sb.toString());
		else
		{
			int button1=button;
			ArrayList<String> al1=new ArrayList<String>(al.get(button1));
			while(al1.size()>0)
			{
				StringBuilder sb1=new StringBuilder(sb);
				sb1.append(al1.get(0));
				letterCombinationsRec(al, button1+1, ind, sb1);
				if(button==0&&al1.isEmpty())
					break;
				else
					al1.remove(0);
			}
		}
	}

	public static ArrayList<String> letterCombinations(int i) {
		ArrayList<String> a=new ArrayList<String>();
		if(i<2)
			a.add(i+"");
		else if(i<7)
		{
			int x=97+(i-2)*3;
			StringBuilder sb=new StringBuilder();
			while(a.size()<3)
			{
				a.add((char)x+"");
				x++;
			}
		}
		else if(i==7)
		{
			int x=97+(i-2)*3;
			StringBuilder sb=new StringBuilder();
			while(a.size()<4)
			{
				a.add((char)x+"");
				x++;
			}
		}
		else if(i==8)
		{
			int x=97+(i-2)*3+1;
			StringBuilder sb=new StringBuilder();
			while(a.size()<3)
			{
				a.add((char)x+"");
				x++;
			}
		}
		else if(i==9)
		{
			int x=97+(i-2)*3+1;
			StringBuilder sb=new StringBuilder();
			while(a.size()<4)
			{
				a.add((char)x+"");
				x++;
			}
		}
		
		return a;
    }

}
