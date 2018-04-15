package interviewBit.strings;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String arr[]={"abcdefgh",

				  "abfghijk",

				  "cabcefgh"};
		System.out.println(longestCommonPrefix(arr));
	}
	
	public static String longestCommonPrefix(String[] A) {
		String s=null;
		for(int i=0;i<A.length;i++)
		{
			s=longestCommonPrefix(s,A[i]);
			if(s.length()==0)
				return "";
		}
			
		return s;
    }

	private static String longestCommonPrefix(String s1, String s2) {
		if(s1==null)
			return s2;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<Math.min(s1.length(), s2.length());i++)
		{
			if(s1.charAt(i)==s2.charAt(i))
				sb.append(s1.charAt(i));
			else
				break;
		}
		return sb.toString();
	}

}
