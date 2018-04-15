package interviewBit.strings;

import java.math.BigInteger;

public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(atoi("54332872018247709407 4 54"));
	}
	
	public static int atoi(final String A) {
		int i=0;
		if(A.length()==0)
			return 0;
		while(A.charAt(i)==' ')
			++i;
		StringBuilder sb=new StringBuilder(); 
		for(int j=i;j<A.length();j++)
		{
			if((A.charAt(j)=='-'||A.charAt(j)=='+')&&j==i)
			{
				sb.append(A.charAt(j));
				continue;
			}
			else if(Character.isDigit(A.charAt(j)))
				sb.append(A.charAt(j));
			else
				break;							
		}
		if(sb.length()==0)
			return 0;
		if(sb.length()==1&&!Character.isDigit(sb.charAt(0)))
			return 0;
		BigInteger b=new BigInteger(sb.toString());
		if(b.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>=0)
			return Integer.MAX_VALUE;
		else if(b.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))<0)
			return Integer.MIN_VALUE;
		else
			return Integer.parseInt(sb.toString());
    }

}
