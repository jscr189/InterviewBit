package interviewBit.stacksAndQueues;

import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseString("sharath"));
	}
	
	public static String reverseString(String A) {
		Stack<Character> s=new Stack<Character>();
		for(int i=0;i<A.length();i++)
		{
			char c=A.charAt(i);
			s.push(c);
		}
		StringBuilder sb=new StringBuilder();
		while(!s.isEmpty())
			sb.append(s.pop());
		return sb.toString();
    }

}
