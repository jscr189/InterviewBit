package interviewBit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

	public static void main(String[] args) {
		ArrayList<Integer> A=new ArrayList<Integer>();
		A.add(34);
		A.add(35);
		A.add(27);
		A.add(42);
		A.add(5);
		A.add(28);
		A.add(39);
		A.add(20);
		A.add(28);
		A=prevSmaller(A);
		System.out.println(A);
	}
	
	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		Stack<Integer> st=new Stack<Integer>();
		if(A.size()<1)
			return A;
		int min=A.get(0);
		A.set(0, -1);
		st.push(min);
		for(int i=1;i<A.size();i++)
		{
			int x=A.get(i);
			if(st.size()==0)
				A.set(i, -1);
			else if(A.get(i)>st.peek())
			{
				A.set(i, st.peek());
			}
			else
			{
				while(st.size()>0&&A.get(i)<=st.peek())
				{
					st.pop();
				}
				if(st.size()>0)
					A.set(i, st.peek());
				else
					A.set(i, -1);
					
			}
			st.push(x);
		}
		
		
		
		
		return A;
    }

}
