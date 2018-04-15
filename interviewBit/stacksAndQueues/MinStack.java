package interviewBit.stacksAndQueues;

import java.util.Stack;

public class MinStack {
	Stack<Integer> st=new Stack<Integer>();
	int min=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void push(int x) {
		if(st.isEmpty())
		{
			min=x;
			st.push(x);
		}
		else if(x>=min)
			st.push(x);
		else
		{
			min=x;
			st.push(2*x-min);
		}
    }

    public void pop() {
        if(!st.isEmpty())
        {
        	int i=st.pop();
        	if(i<min)
        		min=2*min-i;
        }       	
    }

    public int top() {
    	if(st.isEmpty())
        	return -1;
        else
        {
        	int i=st.peek();
        	if(i<min)
        		return 2*min-i;
        	else
        		return min;
        }
    }

    public int getMin() {
        return min;
    }

}
