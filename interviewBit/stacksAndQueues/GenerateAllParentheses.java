package interviewBit.stacksAndQueues;

import java.util.Stack;

public class GenerateAllParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("({[]})"));
	}
	
	public static int isValid(String A) {
		Stack<Character> s=new Stack<Character>();
		for(int i=0;i<A.length();i++)
		{
			char c=A.charAt(i);
			if(c=='('||c=='{'||c=='[')
				s.push(c);
			else
			{
				if(s.isEmpty())
					return 0;
				char top=s.peek();
				if((c==')'&&top=='(')||(c=='}'&&top=='{')||(c==']'&&top=='['))
					s.pop();
				else
					return 0;
			}			
		}
		return s.isEmpty()?1:0;
    }

}
