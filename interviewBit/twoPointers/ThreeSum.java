package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(2);c.add(1);c.add(-9);c.add(-7);c.add(-8);c.add(2);c.add(-8);c.add(2);c.add(3);c.add(-8);
		System.out.println(threeSumClosest(c,-1));
	}
	
	public static int threeSumClosest(ArrayList<Integer> A, int B) {
		int a=0,b=0,c=A.size()-1,sum=Integer.MAX_VALUE;
		if(A.size()<3)
			return -1;
		Collections.sort(A);
		while(a<A.size()-2)
		{
			b=a+1;c=A.size()-1;
			int y=A.get(a)+A.get(a+1)+A.get(a+2);
			if(y>B)
			{
				if(sum==Integer.MAX_VALUE||Math.abs(B-y)<Math.abs(sum-B))
					sum=y;
				break;
			}
			while(b<c)
			{
				int x=A.get(a)+A.get(b)+A.get(c);
				if(sum==Integer.MAX_VALUE||Math.abs(B-x)<Math.abs(sum-B))
					sum=x;
				if(x==B)
					return x;
				if(x<B)
					b++;
				if(x>B)
					c--;
				
			}
			a++;
		}
		return sum;
    }

}
