package interviewBit.stacksAndQueues;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/b/a/.."));
	}
	
	public static String simplifyPath(String A) {
		StringBuilder sb=new StringBuilder("");
		StringBuilder s=new StringBuilder();
		Stack<String> st=new Stack<String>();
		for(int i=0;i<A.length();i++)
		{
			char c=A.charAt(i);
			if(c!='/')
				s.append(c);
			else
			{
				if(s.toString().equals(".."))
				{
					if(!st.isEmpty())
						st.pop();
				}
				else if(s.length()>0&&!s.toString().equals("."))
					st.push(s.toString());
				s=new StringBuilder();
			}
		}
		
		if(s.toString().equals(".."))
		{
			if(!st.isEmpty())
				st.pop();
		}
		else if(s.length()>0&&!s.toString().equals("."))
			st.push(s.toString());
		
		while(!st.isEmpty())
			sb.insert(0,"/"+st.pop());		
		return sb.length()==0?"/":sb.toString();
    }

}
