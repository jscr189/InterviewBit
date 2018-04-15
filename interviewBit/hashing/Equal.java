package interviewBit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class Equal {

	public static void main(String[] args) {
		int a[]={0, 0, 1, 0, 2, 1};
		ArrayList<Integer> A=new ArrayList<Integer>(a.length);
		for(int i:a)
			A.add(i);
		System.out.println(equal(A));
	}
	
	public static ArrayList<Integer> equal(ArrayList<Integer> A) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		int a=-1,b=-1,c=-1,d=-1;
		HashMap<Integer,HashMap<Integer,Integer>> hm=new HashMap<Integer,HashMap<Integer,Integer>>();
		for(int i=0;i<A.size()-1;i++)
		{
			for(int j=i+1;j<A.size();j++)
			{
				int sum=A.get(i)+A.get(j);
				if(hm.containsKey(sum))
				{
					
					HashMap<Integer,Integer> hm1=hm.get(sum);
					int c1=i,d1=j,a1=(int) hm1.keySet().toArray()[0],b1=hm1.get(a1);
					if(c1==a1||d1==a1||c1==b1||d1==b1)
						continue;
					if(a!=-1)
					{
						if(a1>a)
							continue;
						else if(a1==a&&b1>b)
							continue;
						else if(a1==a&&b1==b&&c1>c)
							continue;
						else if(a1==a&&b1==b&&c1==c&&d1>d)
							continue;
						else
						{
							a=a1;b=b1;c=c1;d=d1;
						}
					}
					else
					{
						a=a1;b=b1;c=c1;d=d1;
					}
				}
				else
				{
					HashMap<Integer,Integer> hm1=new HashMap<Integer,Integer>();
					hm1.put(i, j);
					hm.put(sum, hm1);
				}
			}
		}
		if(a!=-1)
		{
			al.add(a);al.add(b);al.add(c);al.add(d);
		}
		return al;
    }

}
