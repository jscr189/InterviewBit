package interviewBit.strings;

public class StrStr {

	public static void main(String[] args) {
		System.out.println(strStr("abc", "ab"));
	}
	
	public static int strStr(final String A, final String B) {
		if(B.length()==0)
			return -1;
		char a[]=A.toCharArray();
		char b[]=B.toCharArray();
		for(int i=0;i<=a.length-b.length;i++)
		{
			int k=0;
			while(k<b.length&&a[i+k]==b[k])
			{
				k++;
			}
			if(k==b.length)
				return i;
		}
		return -1;
    }

}
