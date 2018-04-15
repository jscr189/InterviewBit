package interviewBit.strings;

public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("10","89"));
	}
	
	public static String multiply(String A, String B) {
		StringBuilder sb=new StringBuilder(); 
		if(A.length()>B.length())
			sb=multiplyStr(A, B);
		else
			sb=multiplyStr(B, A);
		
		while(sb.length()>0&&sb.charAt(0)=='0')
			sb.deleteCharAt(0);
		if(sb.length()==0)
			sb.insert(0, 0);
		return sb.toString();
    }
	
	public static StringBuilder multiplyStr(String a,String b)
	{
		StringBuilder res=new StringBuilder();
		for(int i=0;i<a.length();i++)
			res.append(0);
		int carry=0;
		for(int j=b.length()-1;j>=0;--j)
		{
			
			StringBuilder sb=new StringBuilder();
			for(int k=0;k<b.length()-1-j;k++)
				sb.insert(0, 0);
			
			int mul=Integer.parseInt(""+b.charAt(j));
			if(mul==0)
				continue;
			carry=0;
			for(int i=a.length()-1;i>=0;--i)
			{
				int val=Integer.parseInt(""+a.charAt(i));
				val=mul*val+carry;
				sb.insert(0, val%10);
				carry=val/10;
			}
			if(carry!=0)		
				sb.insert(0, carry);
			
			res=add(res,sb);
				
		}
		
		return res;
	}

	
	public static StringBuilder add(StringBuilder a,StringBuilder b)
	{
	
		StringBuilder sb=new StringBuilder();
		
		int carry=0;
		for(int j=b.length()-1,i=a.length()-1;j>=0;j--,i--)
		{
			int val1=Integer.parseInt(""+b.charAt(j));
			int val2=0;
			if(i>=0)
				val2=Integer.parseInt(""+a.charAt(i));
			val1=val1+val2+carry;
			sb.insert(0, val1%10);
			carry=val1/10;
		}
		
		if(carry!=0)		
			sb.insert(0, carry);
		return sb;
	}

}
