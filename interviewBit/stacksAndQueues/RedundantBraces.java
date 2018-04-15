package interviewBit.stacksAndQueues;

import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		System.out.println(braces("(a+(((b*c)+d)))"));
	}
	
	public static int braces(String A) {
		Stack<Character> st=new Stack<Character>();
		char prev='\0';
		for(int i=0;i<A.length();i++)
		{
			char c=A.charAt(i);
			if(c=='+'||c=='-'||c=='*'||c=='/'||c=='(')
			{
				st.push(c);
			}
			else if(c==')'&&st.peek()!='(')
			{
				while(st.peek()!='(')
					st.pop();
				st.pop();
			}
			else if(c==')'&&st.peek()=='(')
				return 1;
		}
		int c=0;
		prev='\0';
		while(!st.isEmpty())
		{
			char x=st.pop();
			if(x==')')
				c++;
			else if(x=='('&&prev=='('&&c>=2)
				return 1;
			else if(prev=='('&&x!='('&&c>=1)
				c--;
			else if(prev!='('&&c>=1)
				c--;
			prev=x;
		}
		
		
		return 0;
    }

}
