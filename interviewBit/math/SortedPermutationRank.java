package interviewBit.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class SortedPermutationRank {

	public static void main(String[] args) {
		String s="cba";
		System.out.println(findRank(s));
	}

	public static int findRank(String a) {
	    int rank=1;
		char arr[]=a.toCharArray();
		Arrays.sort(arr);
		TreeSet<Integer> s=new TreeSet<Integer>();
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			hm.put(arr[i],i);
			s.add(i+1);
		}
		for(int i=0;i<a.length()-1;i++)
		{
			int x=(int)hm.get(a.charAt(i));
			int y=lessthanx(x+1,s);
		    rank+=((y<0?0:y)*fact(a.length()-1-i))% 1000003;
			s.remove(x+1);
		}
		return rank%1000003;
		
	}
	public static int lessthanx(int n,TreeSet<Integer> s) {
		int y=0;
		Iterator<Integer> it=s.iterator();
		while(it.hasNext()&&(int)it.next()!=n)
		{
			y++;
		}
		return y;
	}
	
	public static int fact(int n) {
		if(n==1||n==0)
			return 1;
		else
			return (n*fact(n-1))% 1000003;
	}


}
