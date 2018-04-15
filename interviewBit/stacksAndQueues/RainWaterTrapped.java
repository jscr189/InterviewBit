package interviewBit.stacksAndQueues;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {

	public static void main(String[] args) {
		List<Integer> l= Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
		System.out.println(trap(l));
	}
	
	public static int trap1(final List<Integer> A) {
		int tot=0,min=0;
		
		for(int i=0;i<A.size()-1;i++)
		{
			int k=0;
			boolean flag=true,depth=false;
			while(A.get(i)<A.get(min)||(A.get(i)==A.get(min)&&depth))
			{
				depth=true;
				if(i==A.size()-1&&A.get(i)<A.get(min))
				{
					i=min+1;
					min=min+1;
					flag=false;
					break;
				}
				k+=(A.get(min)-A.get(i))>0?(A.get(min)-A.get(i)):0;
				if(A.get(i)==A.get(min))
					break;
				i++;
			}
			if(flag)
			{
				tot+=k;
				min=i;
			}
		}
		
		return tot;
    }
	
	public static int trap(final List<Integer> A) {
		int tot=0,min=0;
		
		for(int i=0;i<A.size()-1;i++)
		{
			if(A.get(i)>A.get(i+1))
			{
				int j=i+1;
				Stack<Integer> st=new Stack<Integer>();
				while(j<A.size()&&A.get(j)<A.get(i))
				{
					if(st.size()>0&&A.get(st.peek())<A.get(j))
						st.push(j);
					else if(st.isEmpty())
						st.push(j);
					j++;
				}
				if(j==A.size()&&st.size()>0)
				{
					j=st.peek();
				}
				if(st.size()>0)
				{
					min=A.get(i)>A.get(j)?j:i;
					for(int k=i+1;k<j;k++)
					{
						tot+=(A.get(min)-A.get(k))>0?(A.get(min)-A.get(k)):0;
					}
					i=j-1;
				}
			}
		}
		
		return tot;
    }

}
