package interviewBit.hashing;

import java.util.LinkedList;

public class Modulo {

	public static void main(String[] args) {
		System.out.println(modulo("130","103"));
		System.out.println(modulo("103","130"));
	}
	
	public static String modulo(String a,String b)
	{
		if(a.equals(b))
			return "0";
		if(a.length()<b.length())
			return a;
		LinkedList<Integer> n1=new LinkedList<Integer>();
		for(int i=0;i<a.length();i++)
			n1.add(a.charAt(i)-'0');
		LinkedList<Integer> n2=new LinkedList<Integer>();
		for(int i=0;i<b.length();i++)
			n2.add(b.charAt(i)-'0');
		while(true)
		{
			if(n1.size()<n2.size())
				break;
			LinkedList<Integer> tmp=new LinkedList<Integer>(n1);
			boolean flag=false;
			for(int i=n1.size()-1,j=n2.size()-1;!flag&&i>=0&&j>=0;i--,j--)
			{
				if(n1.get(i)>=n2.get(j))
					n1.set(i, n1.get(i)-n2.get(j));
				else
				{
					int k=i-1;
					while(k>=0&&n1.get(k)<1)
						k--;
					if(k<0)
						flag=true;
					else
					{
						n1.set(k, n1.get(k)-1);
						for(int x=k+1;x<i;x++)
							n1.set(x, 9);
						n1.set(i, 10+n1.get(i)-n2.get(j));
					}
				}
			}
			//System.out.println(n1);
			while(n1.size()>0&&n1.get(0)==0)
				n1.remove(0);
			if(flag)
			{
				n1=tmp;
				break;
			}
		}
		String s="";
		for(int i=0;i<n1.size();i++)
			s+=n1.get(i);
		return s;
	}

}
