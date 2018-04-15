package interviewBit.strings;

public class MinimumChar4Palindrome {

	public static void main(String[] args) {
		System.out.println(solve("abcdba"));
	}
	
	public static int solve(String A) {
		StringBuilder sb1=new StringBuilder(A);
		sb1.reverse();
		int k=0;
		do
		{
			if(!sb1.substring(k,A.length()).contains(A.substring(0, A.length()-k)))
				k++;
			else
				break;
		}while(k<A.length());		
		return k;
    }

}
