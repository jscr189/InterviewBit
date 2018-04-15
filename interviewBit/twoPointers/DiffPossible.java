package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.HashSet;

public class DiffPossible {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(1);c.add(2);c.add(3);c.add(6);//c.add(2);
		System.out.println(diffPossible(c,3));
	}
	
	public static int diffPossible(ArrayList<Integer> A, int B) {
		HashSet<Integer> hs=new HashSet<Integer>();
		
		for(int i=0;i<A.size();i++)
		{
			if(hs.contains(A.get(i)))
				return 1;
			else
				hs.add(B+A.get(i));
		}
		
		return 0;
    }

}
