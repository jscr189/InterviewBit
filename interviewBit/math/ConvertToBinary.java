package interviewBit.math;

public class ConvertToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String findDigitsInBinary(int a) {
	    String s="";
	    if(a==0)
	        return "0";
	    while(a>0)
	    {
	        s=a%2+s;
	        a=a/2;
	    }
	    return s;
	}

}
