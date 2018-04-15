package interviewBit.math;

public class ExcelColToNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("AA"));
	}
	
	public static int titleToNumber(String a) {
	    int sum=0;
	    for(int i=0;i<a.length();i++)
	    {
	        sum+=(int)(a.charAt(i)-'A'+1)*Math.pow(26,(a.length()-i-1));
	    }
	    return sum;
	}

}
