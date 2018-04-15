package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class SubStringConcatenation {

	public static void main(String[] args) {
		List<String> B=Arrays.asList("foo", "bar","the","man");
		System.out.println(findSubstring("barfoobarthefoobarman", B));
		List<String> B1=Arrays.asList("aaa", "aaa","aaa", "aaa","aaa");
		System.out.println(findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", B1));
		List<String> B2=Arrays.asList("cac", "aaa", "aba", "aab", "abc");
		System.out.println(findSubstring("abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa", B2));

	}
	
	public static ArrayList<Integer> findSubstring(String A, final List<String> B) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		TreeMap<Integer,String> tm=new TreeMap<Integer,String>();
		StringBuilder sb=new StringBuilder(A);
		int len=0;
		while(true)
		{
			int min=Integer.MAX_VALUE;
			String s=null;
			for(int i=0;i<B.size();i++)
			{
				int in=sb.indexOf(B.get(i));
				if(in!=-1&&in<min)
				{
					min=in;
					s=B.get(i);
				}
			}
			if(min==Integer.MAX_VALUE)
				break;
			if(min!=-1)
			{
				tm.put(min+len,s);
				sb.replace(min, min+1, "");
				len+=1;
			}
		}
		//System.out.println(tm.keySet());
		len=B.get(0).length()*(B.size()-1);
		int size=B.get(0).length();
		Object[] ts=tm.keySet().toArray();
		for(int i=0;i<ts.length;i++)
		{
			if(((int)ts[ts.length-1]-(int)ts[i])<len)
				break;
			else{
				List<String> C=new ArrayList<String>(B);
				
				
				for(int j=(int)ts[i];j<A.length();j+=size)
				{
					if(tm.containsKey(j)&&C.contains(tm.get(j)))
					{
						C.remove(tm.get(j));
					}
					else
						break;
				}
				/*int j=i,prev=-1;
				while(C.size()>0&&j<ts.length)
				{
					if(prev==-1||(int)ts[j]-prev==tm.get((int)ts[j]).length())
					{
						if(C.contains(tm.get((int)ts[j])))
						{
							C.remove(tm.get((int)ts[j]));
						}
						else
							break;
					}
					prev=(int)ts[j++];
				}*/
				if(C.size()==0)
					al.add((int)ts[i]);
			}
				
		}
		return al;
    }

}
