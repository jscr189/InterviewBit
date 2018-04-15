package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

	public static void main(String[] args) {
		List<String> A=Arrays.asList("cat","dog","taac","dan","god");
		System.out.println(anagrams(A));
	}
	
	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
		HashMap<Character,Integer> hm=null;
		ArrayList<HashMap<Character,Integer>> al1=new ArrayList<HashMap<Character,Integer>>();
		for(int i=0;i<A.size();i++)
		{
			String s=A.get(i);
			hm=new HashMap<Character,Integer>();
			for(int j=0;j<s.length();j++)
			{
				char ch=s.charAt(j);
				if(hm.containsKey(ch))
					hm.put(ch, hm.get(ch)+1);
				else
					hm.put(ch, 1);	
			}
			al1.add(hm);
		}
		
		for(int i=0;i<al1.size();i++)
		{
			ArrayList<Integer> al2=new ArrayList<Integer>();
			al2.add(i+1);
			HashMap<Character,Integer> hm1=al1.get(i);
			if(hm1==null)
				continue;
			int j=i+1;
			while(j<al1.size())
			{
				HashMap<Character,Integer> hm2=al1.get(j);
				if(hm1.equals(hm2))
				{
					al2.add(j+1);
					al1.set(j, null);
				}
				j++;
			}
			al.add(al2);
		}
		
		return al;
    }

}
