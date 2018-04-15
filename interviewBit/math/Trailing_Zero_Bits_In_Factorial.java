package interviewBit.math;

public class Trailing_Zero_Bits_In_Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(10));

	}
		public static int trailingZeroes(int a) {
		    int n=5;
		    int sum=0;
		    //Divide the number by 5,25,125,625 and so on as multiplying by a factor gives a trailing zero
		    while(a>=n)
		    {
		        sum+=a/n;
		        n*=5;
		    }
		    return sum;
		}

}
