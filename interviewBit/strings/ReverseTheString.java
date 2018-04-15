package interviewBit.strings;

public class ReverseTheString {

	public static void main(String[] args) {
		System.out.println(reverseWords("   the   ssssky   "));
	}
	
	public static String reverseWords(String a) {
		if(a.length()==0)
			return "";
		StringBuilder sb=new StringBuilder();
		for(int i=a.length()-1;i>=0;--i)
		{
			StringBuilder word=new StringBuilder();
			if(a.charAt(i)!=' ')
			{
				do{
					word.insert(0, a.charAt(i));
					--i;
				}while(i>=0&&a.charAt(i)!=' ');
			}
			if(word.length()>0)
				sb.append(word).append(" ");
		}			
		return sb.toString().trim();
	}

}
