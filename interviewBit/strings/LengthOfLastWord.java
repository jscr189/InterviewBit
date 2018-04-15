package interviewBit.strings;

public class LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(""));
	}
	
	public static int lengthOfLastWord(final String A) {
		if(A.length()==0)
			return 0;
		int count=0;
		for(int i=A.length()-1;i>=0&&count==0;--i)
		{
			if(A.charAt(i)!=' ')
			{
				do{
					count++;
					--i;
				}while(i>=0&&A.charAt(i)!=' ');
			}
		}
			
		return count;
    }

}
