package interviewBit.math;

public class GCD_Using_Euclid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(45,105));

	}
	public static int gcd(int a, int b) {
		    while(b!=0)
		    {
		        int rem=a%b;
		        a=b;
		        b=rem;
		    }
		    return a;
	}

}
