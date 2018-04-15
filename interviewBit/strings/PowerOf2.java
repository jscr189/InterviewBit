package interviewBit.strings;

public class PowerOf2 {

	public static void main(String[] args) {
		System.out.println(power("10124"));
	}
	
	public static int power(String A) {
StringBuilder sb=new StringBuilder(A);
        
        if(sb.length()==1&&Integer.parseInt(sb.toString())<2)
            return 0;
		
		while(!sb.toString().equals("1"))
		{
			StringBuilder sb1=new StringBuilder();
			if(Integer.parseInt(""+sb.charAt(sb.length()-1))%2!=0)
					return 0;
			int carry=0;
			for(int i=0;i<sb.length();i++)
			{
				int currChar=Integer.parseInt(carry+""+sb.charAt(i));
				if(currChar>1)
				{
					sb1.append(currChar/2);
					carry=currChar%2;
				}
				else if(currChar==1)
				{
				    if(i!=0&&carry==0)
						sb1.append("0");
					if(i+1>=sb.length())
						return 0;
					else
					{
						currChar=Integer.parseInt(""+sb.charAt(i)+sb.charAt(++i));
						sb1.append(currChar/2);
						carry=currChar%2;
					}
				}
				else
				{
					sb1.append(currChar);
					carry=currChar%2;
				}
			}
			if(sb1.toString().equals("2"))
				return 1;
			sb=sb1;
		}
		
		
		
		return 1;
    }

}
