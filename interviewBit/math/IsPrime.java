package interviewBit.math;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int isPrime(int a) {
	    if (a == 1) {
            return 0;
        }
        for(int i=2 ; i<=Math.sqrt(a) ; i++) {
            if (a%i == 0)
                return 0;
        }
        return 1;
	}

}
