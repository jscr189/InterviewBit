package interviewBit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubSequence {
	public static int maxLength=0;
	public static void main(String[] args) {
		List<Integer> A=(List) Arrays.asList(1, 11, 2, 4,3);
		System.out.println(longestSubsequenceLength(A));
	}
	
	public static int longestSubsequenceLength(final List<Integer> A) {
		int prev=A.get(0);
		ArrayList<Integer> B=new ArrayList<Integer>();
		for(int i=1;i<A.size();i++)
			B.add(A.get(i));
		longestSubsequenceLengthRec(B,prev,1,true);
		longestSubsequenceLengthRec(B,prev,1,false);
		return maxLength;
    }

	private static void longestSubsequenceLengthRec(ArrayList<Integer> a,int prev,int tot, boolean b) {
		if(maxLength<tot)
			maxLength=tot;
		if(a.size()==0)
			return;
		if(b)
		{
			int i=0;
			while(i<a.size()&&a.get(i)<prev)
				i++;
			if(i>=a.size()||(i==0&&a.get(0)<prev))
				return;
			else
			{
				prev=a.get(i);
				tot++;
				int j=a.size();
				while(a.size()>j-i-1)
					a.remove(0);
			}
		}
		else
		{
			{
				int i=0;
				while(i<a.size()&&a.get(i)>prev)
					i++;
				if(i>=a.size()||(i==0&&a.get(0)>prev))
					return;
				else
				{
					prev=a.get(i);
					tot++;
					int j=a.size();
					while(a.size()>j-i-1)
						a.remove(0);
				}
			}
			
		}
		longestSubsequenceLengthRec(a,prev,tot,true);
		longestSubsequenceLengthRec(a,prev,tot,false);
	}

}
