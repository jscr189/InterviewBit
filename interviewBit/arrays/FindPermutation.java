package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class FindPermutation {

	public static void main(String[] args) {
		System.out.println(findPerm("IDID",5));	
		}
	
	public static ArrayList<Integer> findPerm(final String A, int B) {
		TreeSet<Integer> ts=new TreeSet<Integer>();
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=1;i<=B;i++)
			ts.add(i);
		if(A.indexOf('D')==-1)	
			return new ArrayList<Integer>(ts);
		else if(A.indexOf('I')==-1)
		{
			al=new ArrayList<Integer>(ts);
			Collections.reverse(al);
			return al;
		}
		else
		{
			al=new ArrayList<Integer>(ts);
			for(int k=0;k<A.length();k++)
        	{
				if(A.charAt(k)=='D')
				{
					if(al.get(k)!=ts.last())
					{
						al.set(k, ts.last());
						al.set(k+1, ts.first());
					}
					ts.remove(ts.last());
				}
				else if(A.charAt(k)=='I')
				{
					if(al.get(k)!=ts.first())
					{
						al.set(k, ts.first());
						al.set(k+1, ts.last());
					}
					ts.remove(ts.first());
				}
        	}
		}
		int j=0;
		for(int i:ts)
		{
			al.set(al.size()-ts.size()+(j++), ts.first());
		}
		return al;
    }
	
	public static ArrayList<Integer> findPerm1(final String A, int B) {
		TreeSet<Integer> ts=new TreeSet<Integer>();
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=1;i<=B;i++)
			ts.add(i);
		if(A.indexOf('D')==-1)	
			return new ArrayList<Integer>(ts);
		else if(A.indexOf('I')==-1)
		{
			al=new ArrayList<Integer>(ts);
			Collections.reverse(al);
			return al;
		}
		else
		{
			al=new ArrayList<Integer>(ts);
			al=permute(al,0,al.size()-1,A);
		}
		return al;
    }
	
	/*public static ArrayList<Integer> perm(String A,TreeSet<Integer> ts,ArrayList<Integer> al)
	{
		if(A.length()==0)
			return al;
		else
		{
			if(A.charAt(0)=='D')
			{
				ts.first();
			}
		}
	}*/
	
	public static ArrayList<Integer> permute(ArrayList<Integer> al, int l, int r,String A)
    {
        if (l == r)
        {
        	System.out.println(al);
        	boolean flag=true;
        	for(int i=0;i<al.size()-1;i++)
        	{
        		if((A.charAt(i)=='D'&&al.get(i)>al.get(i+1))||(A.charAt(i)=='I'&&al.get(i)<al.get(i+1)))
        			continue;
        		else
        		{
        			flag=false;break;
        		}
        		
        	}
        	if(flag)
        		return al;
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                al = swap(al,l,i);
                boolean flag=true;
            	for(int k=0;k<=l;k++)
            	{
            		if((A.charAt(k)=='D'&&al.get(k)>al.get(k+1))||(A.charAt(k)=='I'&&al.get(k)<al.get(k+1)))
            			continue;
            		else
            		{
            			flag=false;break;
            		}	
            	}
            	if(flag)
            	{
	                ArrayList<Integer> tmp=permute(al, l+1, r,A);
	                if(tmp!=null)
	                {
	                	return tmp;
	                }
            	}
                al = swap(al,l,i);
            }
        }
        return null;
    }
	
	public static ArrayList<Integer> swap(ArrayList<Integer> al, int l, int i)
	{
		int tmp=al.get(l);
		al.set(l, al.get(i));
		al.set(i, tmp);
		return al;
	}

}
