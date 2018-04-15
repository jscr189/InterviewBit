package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumZero {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(-1);c.add(0);c.add(1);c.add(2);c.add(-1);c.add(-4);
		System.out.println(threeSum(c));
	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
		
		Collections.sort(A);
		int a=0,b=1,c=A.size()-1;
		while(a<A.size()-3)
		{
			b=a+1;c=A.size()-1;
			if(A.get(a)+A.get(b)>0)
				break;

			while(b<c)
			{
				int y=A.get(a)+A.get(b)+A.get(c);
				if(y==0)
				{
					ArrayList<Integer> al1=new ArrayList<Integer>();
					al1.add(A.get(a));al1.add(A.get(b));al1.add(A.get(c));
					if(!al.contains(al1))
						al.add(al1);
					c--;b++;
				}
				else if(y>0)
					c--;
				else
					b++;
			}
			a++;
		}
		
		return al;
    }

}
