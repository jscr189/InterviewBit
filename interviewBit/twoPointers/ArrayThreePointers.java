package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class ArrayThreePointers {

	public static void main(String[] args) {
		List<Integer> a=new ArrayList<Integer>();
		a.add(1);
		List<Integer> b=new ArrayList<Integer>();
		b.add(1);
		List<Integer> c=new ArrayList<Integer>();
		c.add(1);
		System.out.println(minimize(a,b,c));
	}
	
	public static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		int min=Integer.MAX_VALUE,a=0,b=0,c=0;
		
		do
		{
			int av=A.get(Math.abs(a>=A.size()?A.size()-1:a));
			int bv=B.get(Math.abs(b>=B.size()?B.size()-1:b));
			int cv=C.get(Math.abs(c>=C.size()?C.size()-1:c));
			int max=Math.max(Math.abs(av-bv),Math.max(Math.abs(bv-cv), Math.abs(cv-av)));
			if(max<min)
				min=max;
				
			if(av>=bv&&av>=cv)
			{
				if(b>=B.size()&&c>=C.size())
					a++;
				else if(b>=B.size()&&c<C.size())
					c++;
				else if(b<B.size()&&c>=C.size())
					b++;
				else if(bv>=cv)
				{
					c++;
				}
				else
					b++;
			}
			else if(bv>=cv&&bv>=av)
			{
				if(c>=C.size()&&a>=A.size())
					b++;
				else if(c>=C.size()&&a<A.size())
					a++;
				else if(c<C.size()&&a>=A.size())
					c++;
				else if(cv>=av)
				{
					a++;
				}
				else
					c++;
			}
			else if(cv>=bv&&cv>=av)
			{
				if(b>=B.size()&&a>=A.size())
					c++;
				else if(b>=B.size()&&a<A.size())
					a++;
				else if(b<B.size()&&a>=A.size())
					b++;
				else if(av>=bv)
				{
					b++;
				}
				else
					a++;
			}
		}while(a<A.size()||b<B.size()||c<C.size());
		
		return min;
    }

}
