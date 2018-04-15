package interviewBit.strings;

import java.util.TreeMap;

public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(101));//CDXXXIV
	}
	
	public static String intToRoman(int A) {
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer,Character> hm=new TreeMap<Integer,Character>();
		hm.put(1,'I');
		hm.put(5,'V');
		hm.put(10,'X');
		hm.put(50,'L');
		hm.put(100,'C');
		hm.put(500,'D');
		hm.put(1000,'M');
		
		int mul=(A+"").length()-1;
		while(A>0)
		{
			int z=(int) Math.pow(10, (A+"").length()-1);
			int x=A/z;
			int y=A%10;
			if(hm.get(x*z)!=null)
				sb.append(hm.get(x*z));
			else
			{
				int prev=-1,curr=-1,next=-1;
				for(int j:hm.keySet())
				{
					if(j>x*z)
					{
						next=j;
						break;
					}
					else
					{
						prev=curr;
						curr=j;
					}
				}
				if(hm.get(next-x*z)!=null)
				{
					sb.append(hm.get(next-x*z)).append(hm.get(next));
				}
				else
				{
					sb.append(hm.get(curr));
					if(prev==-1||(x*z)%curr==0)prev=curr;
					int n=((x*z)-curr)/prev;
					for(int k=0;k<n;k++)
					{
							sb.append(hm.get(prev));
					}
				}
			}
				
			mul--;
			A=A-x*z;
		}
		
		return sb.toString();
    }

}
