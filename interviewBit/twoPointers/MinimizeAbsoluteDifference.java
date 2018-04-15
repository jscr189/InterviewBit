package interviewBit.twoPointers;

import java.util.ArrayList;

public class MinimizeAbsoluteDifference {

	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(3);a.add(4);a.add(8);
		ArrayList<Integer> b=new ArrayList<Integer>();
		b.add(1);b.add(2);b.add(3);b.add(6);
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(5);c.add(7);c.add(8);
		System.out.println(solve(a,b,c));
	}
	
	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int diff=Integer.MAX_VALUE;
		for(int i=0,j=0,k=0;i<A.size()&&j<B.size()&&k<C.size();)
		{
			int a=A.get(i),b=B.get(j),c=C.get(k);
			if(a<=b&&a<=c)
			{
				if(b<=c)
				{
					if(Math.abs(c-a)<diff)
						diff=Math.abs(c-a);
				}
				else if(b>c)
				{
					if(Math.abs(b-a)<diff)
						diff=Math.abs(b-a);
				}
				i++;
			}
			else if(b<=c&&b<=a)
			{
				if(a<=c)
				{
					if(Math.abs(c-b)<diff)
						diff=Math.abs(c-b);
				}
				else if(a>c)
				{
					if(Math.abs(a-b)<diff)
						diff=Math.abs(a-b);
				}
				j++;
			}
			else if(c<=a&&c<=b)
			{
				if(a<=b)
				{
					if(Math.abs(b-c)<diff)
						diff=Math.abs(b-c);
				}
				else if(a>b)
				{
					if(Math.abs(a-c)<diff)
						diff=Math.abs(a-c);
				}
				k++;
			}
		}
		return diff;
    }

}
