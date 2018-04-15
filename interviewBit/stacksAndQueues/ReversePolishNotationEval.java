package interviewBit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotationEval {

	public static void main(String[] args) {
		List<String> l= Arrays.asList("4", "13", "5", "/", "+");
		ArrayList<String> A=new ArrayList<String>(l);
		System.out.println(evalRPN(A));
	}
	
	public static int evalRPN(ArrayList<String> A) {
		int x=0;
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<A.size();i++)
		{
			String s=A.get(i);
			if("+".equals(s)||"-".equals(s)||"*".equals(s)||"/".equals(s))
			{
				int ob2=st.pop();
				int ob1=st.pop();
				if("+".equals(s))
					x=ob1+ob2;
				else if("-".equals(s))
					x=ob1-ob2;
				else if("*".equals(s))
					x=ob1*ob2;
				else if("/".equals(s))
					x=ob1/ob2;
				st.push(x);
			}
			else
				st.push(Integer.parseInt(s));
		}
		
		return st.peek();
    }

}
