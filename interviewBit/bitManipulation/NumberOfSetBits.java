package interviewBit.bitManipulation;

public class NumberOfSetBits {

	public static void main(String[] args) {
		System.out.println(numSetBits((long)Math.pow(2, 15)-1));
	}
	
	public static int numSetBits(long a) {
		int sum=0;
		while(a!=0)
		{
			long b=a&1;
			if(b==1)
				sum++;
			a=a>>1;
		}
		return sum;
	}

}
