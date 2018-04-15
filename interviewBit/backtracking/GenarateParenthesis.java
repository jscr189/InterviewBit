package interviewBit.backtracking;

import java.util.ArrayList;

public class GenarateParenthesis {
	public static ArrayList<String> al=new ArrayList<String>();
	public static void main(String[] args) {
		System.out.println(generateParenthesis(4));
	}
	
	public static ArrayList<String> generateParenthesis(int A) {
		genParenRecur(A,A,new StringBuilder());
		return al;
    }

	public static void genParenRecur(int a1, int a2,StringBuilder sb) {
		if(a1==0&&a2==0)
			al.add(sb.toString());
		else
		{
			StringBuilder sb1=new StringBuilder(sb);
			if(a1>0)
			{
				sb1.append("(");
				genParenRecur(a1-1, a2, sb1);
			}
			StringBuilder sb2=new StringBuilder(sb);
			if(a2>a1)
			{
				sb2.append(")");
				genParenRecur(a1, a2-1, sb2);
			}
		}
	}

}
