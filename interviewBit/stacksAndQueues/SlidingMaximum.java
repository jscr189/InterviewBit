package interviewBit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class SlidingMaximum {

	public static void main(String[] args) {
		List<Integer> A=Arrays.asList(90, 767, 90, 777, 463, 196, 984, 277, 451, 643, 403, 316, 451, 967, 683, 786, 167, 372, 758, 402, 325, 431, 351, 351, 158, 663, 244, 559, 345, 759, 924, 585, 509, 397, 540, 869, 997, 670, 375, 180, 48, 936, 203, 8, 598, 703, 733, 333, 414, 377, 496, 351, 910, 685, 612, 773, 571, 24, 679, 174, 644, 639, 544, 1, 884, 982, 447, 670, 251, 868, 815, 467, 386, 932, 178, 295, 957, 757, 124, 932, 342, 301, 406, 259, 943, 79, 313, 218);
		ArrayList<Integer> al=slidingMaximum1(A, 7);
		for(int i:al)
			System.out.println(i);
	}
	
	public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		TreeSet<Integer> ts=new TreeSet<Integer>();
		int i=0,j=0;
		boolean flag=false;
		do
		{
			if(!flag)
			{
				for(j=i;j-i<=B&&j<A.size();j++)
				{
					ts.add(A.get(j));
				}
			}
			flag=true;
			System.out.println(ts+" -> "+ts.last());
			al.add(ts.last());
			ts.remove(A.get(i));
			if(j<A.size())
				ts.add(A.get(j));
			i++;
			j++;
		}while(i+B<=A.size());
		return al;
    }
	
	public static ArrayList<Integer> slidingMaximum1(final List<Integer> a, int b) {
		Deque<Integer> st = new LinkedList<Integer>();
	    ArrayList<Integer> output = new ArrayList<Integer>();
	    
	    
	    for(int i = 0; i < a.size(); i++) {
	        
	        
	        while(!st.isEmpty() && a.get(st.peekLast()) < a.get(i)){
	            st.removeLast();
	        }
	        
	        st.addLast(i);
	        
	        if( i >= b -1) {
	            output.add(a.get(st.peekFirst()));
	            
	            if(st.peekFirst() <= i-b+1){
	                st.removeFirst();
	            }
	        }
	    }
	    
	    return output;
	    }

}
