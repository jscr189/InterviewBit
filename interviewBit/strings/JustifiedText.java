package interviewBit.strings;

import java.util.LinkedList;

public class JustifiedText {

	public static void main(String[] args) {
		String A[]={"1"};
		String B[]=fullJustify(A, 144);
		for(String s:B)
			System.out.println(s);
	}
	
	public static String[] fullJustify(String[] A, int B) {
		LinkedList<String> ll=new LinkedList<String>();
		int i=0;
		while(i<A.length)
		{
			int j=i;
			int charLen=0;
			int total=B;
			while(j<A.length&&A[j].length()<=total)
			{
				charLen+=A[j].length();
				total-=(A[j++].length()+1);
			}
			if(j==A.length)
			{
				StringBuilder sb=new StringBuilder();
				for(int k=i;k<j;k++)
				{
					sb.append(A[k]);
					if(k==j-1)
					{
						while(sb.length()<B)
							sb.append(' ');
					}
					else
						sb.append(' ');
				}
				ll.add(sb.toString());
				i=j+1;
			}
			else if(j==i+1)
			{
				StringBuilder sb=new StringBuilder(A[j-1]);
				while(sb.length()<B)
					sb.append(' ');
				ll.add(sb.toString());
				i=j;
			}
			else
			{
				StringBuilder sb=new StringBuilder();
				for(int k=i;k<j;k++)
				{
					sb.append(A[k]);
					int div=(B-charLen)/(j-i-1);
					int rem=(B-charLen)%(j-i-1);
					int c=0;
					while(k!=j-1&&++c<=(div))
						sb.append(' ');
					if(k!=j-1&&k<i+rem)
					{
						sb.append(' ');
					}
				}
				ll.add(sb.toString());
				i=j;
			}
		}
		
		String arr[]=new String[ll.size()];
		i=0;
		for(String s:ll)
			arr[i++]=s;
		return arr;
    }

}
