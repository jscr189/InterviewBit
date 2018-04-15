package interviewBit.strings;

public class ZigZagString {

	public static void main(String[] args) {
		System.out.println(convert("A", 1));
	}
	
	public static String convert(String A, int B) {
		StringBuilder sb=new StringBuilder();
		
		int start=0,end=B-1;
		if(B==1)
			return A;
		
		for(int i=0;i<B;i++)
		{
			if(i==start)
			{
				if(i<A.length())
					sb.append(A.charAt(i));
				int j=i;
				while(end!=0&&j+end*2<A.length())
				{
					sb.append(A.charAt(j+end*2));
					j=j+end*2;
				}
				
			}
			else if(i==end)
			{
				if(i<A.length())
					sb.append(A.charAt(i));
				int j=i;
				while(j+end*2<A.length())
				{
					sb.append(A.charAt(j+end*2));
					j=j+end*2;
				}
				
			}
			else
			{
				int first=i;
				int second=first+2*(end-first);
				if(first<A.length())
					sb.append(A.charAt(first));
				if(second<A.length())
					sb.append(A.charAt(second));
				while(first+end*2<A.length())
				{
					sb.append(A.charAt(first+end*2));
					first=first+end*2;
					if(second+end*2<A.length())
					{
						sb.append(A.charAt(second+end*2));
						second=second+end*2;
					}
					else 
						break;
				}
			}
		}
		
		return sb.toString();
    }

}
