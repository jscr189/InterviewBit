package interviewBit.backtracking;

import java.util.ArrayList;

public class GrayCode {
	public static ArrayList<Integer> al=new ArrayList<Integer>();
	public static void main(String[] args) {
		System.out.println(grayCode(9));
	}
	
	public static ArrayList<Integer> grayCode(int a) {
		al.add(0);
		for(int i=1;i<=a;i++)
		{
			int n=al.size();
			for(int j=n-1;j>=0;j--)
				al.add(al.get(j)+(int)Math.pow(2, i-1));
		}
		return al;
	}
	
	public static boolean grayCodeRecur(int a) {
		if(al.size()==Math.pow(2, a))
			return true;
		for(Integer i=1;i<Math.pow(2, a);i++)
		{
			if(al.contains(i))
				continue;
			if(differby1(al.get(al.size()-1),i))
			{
				al.add(i);
				System.out.println(al);
				if(grayCodeRecur(a))
					return true;
				al.remove(i);
			}
		}
		return false;
	}

	private static boolean differby1(int i, int j) {
		int k=i^j;
		int count=0;
		while(k>0)
		{
			if((k&1)==1)
				count++;
			if(count>1)
				return false;
			k=k>>1;
		}
		if(count==1)
			return true;
		else
			return false;
	}

}
