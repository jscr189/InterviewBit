package interviewBit.hashing;

import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abbabccdc"));
	}
	
	public static int lengthOfLongestSubstring(String A) {
		int max=1;
		HashSet<Character> hs=new HashSet<Character>();
		for(int i=0;i<A.length();i++)
		{
			int j=i;
			while(j<A.length())
			{
				if(hs.contains(A.charAt(j)))
				{
					if(max<hs.size())
						max=hs.size();
					hs=new HashSet<Character>();
					break;
				}
				else 
					hs.add(A.charAt(j++));
			}
			
		}
		
		return max;
    }

}
