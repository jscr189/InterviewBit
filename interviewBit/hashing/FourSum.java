package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Collections;

public class FourSum {

	public static void main(String[] args) {
		int a[]={1,0 ,-1, 0,-2,2};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i:a)
			A.add(i);
		System.out.println(fourSum(A,0));
	}
	
	public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
		ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
		int a=0,b=0,c=0,d=0;
		Collections.sort(A);
		for(int i=0;i<A.size()-3;i++)
		{
			a=A.get(i);
			for(int j=i+1;j<A.size()-2;j++)
			{
				b=A.get(j);
				int k=B-a-b;
				int p=j+1,q=A.size()-1;
				while(p<q)
				{
					c=A.get(p);
					d=A.get(q);
					if((c+d)==k)
					{
						ArrayList<Integer> al1=new ArrayList<Integer>();
						al1.add(a);al1.add(b);al1.add(c);al1.add(d);
						if(!al.contains(al1))
							al.add(al1);
						p++;
					}
					else if((c+d)>k)
						q--;
					else 
						p++;
				}
			}
		}
		
		return al;
    }

}
