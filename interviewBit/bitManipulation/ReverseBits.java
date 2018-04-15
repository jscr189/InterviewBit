package interviewBit.bitManipulation;

public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(reverse(0));
	}
	
	public static long reverse(long a) {
		long sum=0;
		for(int i=0;i<32;i++)
		{
			sum<<=1;
			long b=a&1;
			if(b==1)
				sum++;
			a>>=1;
		}
		return sum;
	}

}
