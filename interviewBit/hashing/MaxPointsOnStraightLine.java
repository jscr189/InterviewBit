package interviewBit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MaxPointsOnStraightLine {

	public static void main(String[] args) {
		int a1[]={-16,3,-11,0,-10,3,-1};
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i:a1)
			a.add(i);
		int b1[]={-18,11,-8,14,-15,6,-2};
		ArrayList<Integer> b=new ArrayList<Integer>();
		for(int i:b1)
			b.add(i);
		System.out.println(maxPoints(a, b));
	}
	
	public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		if(a.size()<3)
			return a.size();
		int max=1;
		HashMap<String,HashSet<String>> hm=new HashMap<String,HashSet<String>>();
		for(int i=1;i<a.size();i++)
		{
			hm=new HashMap<String,HashSet<String>>();
			for(int j=i-1;j>=0;j--)
			{
				int x1=a.get(i),x2=a.get(j),y1=b.get(i),y2=b.get(j);
				String slope="";
				if(y2==y1&&x2==x1)
					slope="x=y";
				else if(y2==y1)
					slope="y="+y2;
				else if(x2==x1)
					slope="x="+x2;
				else
					slope=""+((double)(y2-y1)/(double)(x2-x1));
				if(hm.containsKey(slope))
				{
					hm.get(slope).add(i+"~ "+x1+" "+y1);
					hm.get(slope).add(j+"~ "+x2+" "+y2);
					if(max<hm.get(slope).size())
					{
						max=hm.get(slope).size();
						System.out.println(slope+":::"+hm.get(slope));
					}
				}
				else
				{
					hm.put(slope,new HashSet<String>());
					hm.get(slope).add(i+"~ "+x1+" "+y1);
					hm.get(slope).add(j+"~ "+x2+" "+y2);
					if(max<hm.get(slope).size())
					{
						max=hm.get(slope).size();
						System.out.println(slope+":::"+hm.get(slope));
					}
				}
			}
		}
		return max;
	}

}
