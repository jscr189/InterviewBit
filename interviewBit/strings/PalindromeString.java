package interviewBit.strings;

public class PalindromeString {

	public static void main(String[] args) {
		String s="A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
		s=".;";
		System.out.println(isPalindrome(s));
	}
	
	public static int isPalindrome(String A) {
		A=A.toLowerCase();
		int i=0,j=A.length()-1;
		while(i<j)
		{
			while(i<A.length()&&!(Character.isDigit(A.charAt(i))||Character.isLetter(A.charAt(i))))
				++i;
			while(j>=0&&!(Character.isDigit(A.charAt(j))||Character.isLetter(A.charAt(j))))
				--j;
			if(i<j&&A.charAt(i)!=A.charAt(j))
				return 0;
			else
			{
				++i;--j;
			}
		}
		return 1;
    }

}
