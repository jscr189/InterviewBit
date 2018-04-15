package interviewBit.strings;

public class CountAndSay {

	public static void main(String[] args) {
		//System.out.println(countRec(new StringBuilder("111221")));
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int A) {
		return countAndSayRec(A).toString();
	}

	public static StringBuilder countAndSayRec(int A) {
		if(A==1)
			return new StringBuilder("1");
		else
		{
			return countRec(countAndSayRec(A-1));
		}	
	}

	public static StringBuilder countRec(StringBuilder sb)
	{
		StringBuilder out=new StringBuilder();
		for(int i=0;i<sb.length();i++)
		{
			char c=sb.charAt(i);
			int j=1,k=i;
			while(k+1<sb.length()&&c==sb.charAt(++k))
				++j;
			i+=j-1;
			out.append(j).append(c);	
		}
		return out;
	}

}
