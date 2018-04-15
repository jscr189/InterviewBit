package interviewBit.strings;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersion("05.1","5.1"));
	}
	
	public static int compareVersion(String A, String B) {
			return compareVersionRec(A, B);
    }
	
	public static int compareVersionRec(String A, String B) {
		int i=0,j=0;
		String x="0",y="0";
		if(A.length()>0&&A.indexOf(".")==-1)
		{
			x=A;
			A="";
		}
		if(B.length()>0&&B.indexOf(".")==-1)
		{
			y=B;
			B="";
		}
		if(A.length()>0&&A.indexOf(".")!=-1)
		{
			x=A.substring(0,A.indexOf("."));
			A=A.substring(A.indexOf(".")+1);
		}
		if(B.length()>0&&B.indexOf(".")!=-1)
		{
			y=B.substring(0,B.indexOf("."));
			B=B.substring(B.indexOf(".")+1);
		}
		x=removeLeadingZeroes(x);
		y=removeLeadingZeroes(y);
		if(x.length()>y.length())
			return 1;
		else if(x.length()<y.length())
			return -1;
		if(x.length()>0)
			i=Integer.parseInt(x);
		if(y.length()>0)
			j=Integer.parseInt(y);
		if(A.length()==0&&B.length()==0)
		{
			if(i>j)
				return 1;
			else if(i==j)
				return 0;
			else
				return -1;
		}
		else
		{
			if(i>j)
				return 1;
			else if(i<j)
				return -1;
			else
			{
				return compareVersionRec(A,B);
			}
		}		
    }

	public static String removeLeadingZeroes(String x) {
		StringBuilder sb=new StringBuilder();
		boolean flag=false;
		for(int i=0;i<x.length();i++)
		{
			if(x.charAt(i)!='0')
				flag=true;
			if(flag)
				sb.append(x.charAt(i));
		}
		return sb.toString();
	}

}
