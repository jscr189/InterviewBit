package interviewBit.strings;

public class BinaryStringSum {

	public static void main(String[] args) {
		System.out.println(addBinary("111","111"));//CDXXXIV
	}
	
	public static String addBinary(String A, String B) {
		StringBuilder sb=new StringBuilder();
		
		int aLen=A.length()-1,bLen=B.length()-1,carry=0;
		while(aLen>=0||bLen>=0)
		{
			int x=((aLen<0)?0:(Integer.parseInt(""+A.charAt(aLen--))))+((bLen<0)?0:(Integer.parseInt(""+B.charAt(bLen--))))+carry;
			carry=0;
			if(x<2)
			{
				sb.insert(0, x);
			}
			else
			{
				sb.insert(0, x%2);
				carry=x/2;
			}
		}
		
		if(carry!=0)
		{
			sb.insert(0, carry);				
		}
		
		return sb.toString();
    }

}
