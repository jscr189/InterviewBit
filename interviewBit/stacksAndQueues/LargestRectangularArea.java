package interviewBit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangularArea {

	public static void main(String[] args) {
		ArrayList<Integer> A=new ArrayList<Integer>();
		A.add(2);
		A.add(1);
		A.add(5);
		A.add(6);
		A.add(7);
		A.add(6);
		A.add(7);
		System.out.println(largestRectangleArea(A));
	}
	
	public static int largestRectangleArea(ArrayList<Integer> a) {
		Stack<Integer> s=new Stack<Integer>();
	    int i=0,n=a.size();
	    int tp,ar,mx=0;
	    while(i<n){
	        if(s.empty()||a.get(s.peek())<=a.get(i))
	            s.push(i++);
	        else {
	            tp=s.pop();
	            ar= a.get(tp)*(s.empty()?i:i-s.peek()-1);
	            if(ar>mx)
	                mx=ar;
	        }
	        
	    }
	    while(!s.empty()){
	       tp=s.pop();
	            ar= a.get(tp)*(s.empty()?i:i-s.peek()-1);
	            if(ar>mx)
	                mx=ar;
	    }
	    return mx;
    }

}
