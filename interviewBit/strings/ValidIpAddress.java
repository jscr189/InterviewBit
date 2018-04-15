package interviewBit.strings;

import java.util.HashMap;
import java.util.LinkedList;

public class ValidIpAddress {

	public static void main(String[] args) {
		//System.out.println("256255111".substring(0,"256255111".substring(1) ));
		//System.exit(0);
		String ips[]=restoreIpAddresses("0100100");
		for(String x:ips)
			System.out.println(x);// 2.56.255.111, 25.6.255.111, 25.62.55.111 
	}
	
	public static String[] restoreIpAddresses(String A) {
		LinkedList<String> ll=restoreIpAddresses(-1,-1,-1,-1,new LinkedList<String>(),A);
		String str[]=new String[ll.size()];
		int i=0;
		for(String x:ll)
			str[i++]=x;
		
		return str;
    }
	
	public static LinkedList<String> restoreIpAddresses(int a,int b,int c,int d,LinkedList<String> ll,String A) {
		if(a!=-1&&b!=-1&&c!=-1&&d!=-1&&A.length()==0)
			ll.add(a+"."+b+"."+c+"."+d);
		if(a==-1)
		{
			for(int i=0;i<A.length();i++)
			{
				if(i>0&&A.charAt(0)=='0')
					break;
				int k=Integer.parseInt(A.substring(0,i+1));
				if(k<256)
					restoreIpAddresses(k, b, c, d, ll, A.substring(i+1));
				else
					break;
			}
		}
		if(a!=-1&&b==-1)
		{
			for(int i=0;i<A.length();i++)
			{
				if(i>0&&A.charAt(0)=='0')
					break;
				int k=Integer.parseInt(A.substring(0,i+1));
				if(k<256)
					restoreIpAddresses(a, k, c, d, ll, A.substring(i+1));
				else
					break;
			}
		}
		if(a!=-1&&b!=-1&&c==-1)
		{
			for(int i=0;i<A.length();i++)
			{
				if(i>0&&A.charAt(0)=='0')
					break;
				int k=Integer.parseInt(A.substring(0,i+1));
				if(k<256)
					restoreIpAddresses(a, b, k, d, ll, A.substring(i+1));
				else
					break;
			}
		}
		if(a!=-1&&b!=-1&&c!=-1&&d==-1)
		{
			for(int i=0;i<A.length();i++)
			{
				if(i>0&&A.charAt(0)=='0')
					break;
				int k=Integer.parseInt(A.substring(0,i+1));
				if(k<256)
					restoreIpAddresses(a, b, c, k, ll, A.substring(i+1));
				else
					break;
			}
		}
		
		return ll;
    }

}
