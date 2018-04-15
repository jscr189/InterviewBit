package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {

	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(1);a.add(2);a.add(3);a.add(3);a.add(4);a.add(5);
		ArrayList<Integer> b=new ArrayList<Integer>();
		b.add(3);b.add(3);b.add(5);
		System.out.println(intersect(a,b));
	}
	
	public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		for(int i=0,j=0;i<A.size()&&j<B.size();)
		{
			if(A.get(i).equals(B.get(j)))
			{
				al.add(A.get(i));
				i++;j++;
			}
			else if(A.get(i)<B.get(j))
				i++;
			else if(A.get(i)>B.get(j))
				j++;
		}
		
		return al;
    }

}
