package interviewBit.math;

public class PowerOf2Ints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public boolean isPower(int n) {
        double A=2;
	    double P;
	    if(n==1) return true;
	    for(P=2;(P<33)&&(A<=(double)(Math.pow(2,16)));P++)
	    {   
	        if(Math.pow(A,P)==(double)n) return true;
	        if(Math.pow(A,P) >= (Math.pow(2,32))) {P=1;A++;}
	    }
	    return false;
    }

}
