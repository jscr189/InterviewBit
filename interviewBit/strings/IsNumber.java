package interviewBit.strings;

public class IsNumber {

	public static void main(String[] args) {
		System.out.println(isNumber("1e12"));
	}
	
	public static int isNumber(final String A) {
		String B=A.trim().toLowerCase();
		return isNumberRec(B);
    }
	
	public static int isNumberRec(String A) {
		if(A.length()==0)
			return 0;
		if(A.length()==1)
		{
			if(Character.isDigit(A.charAt(0)))
				return 1;
			else
				return 0;
		}
		
		if(A.length()>1)
		{
			if(A.charAt(0)=='+'||A.charAt(0)=='-')
				A=A.substring(1);
		}
		
		if(A.indexOf("e")!=-1)
		{
			int i=isNumberRec(A.substring(0,A.indexOf("e")));
			if(i==1)
			{
				if(A.substring(A.indexOf("e")+1).indexOf(".")==-1)
					i=isNumberRec(A.substring(A.indexOf("e")+1));
				else
					i=0;
			}
			
			if(i==1)
				return 1;
			else
				return 0;
		}
		
		if(A.indexOf(".")!=-1)
		{
			int i=A.indexOf(".")==0?1:isNumberRec(A.substring(0,A.indexOf(".")));
			if(i==1)
				i=isNumberRec(A.substring(A.indexOf(".")+1));
			
			if(i==1)
				return 1;
			else
				return 0;
		}
		
		boolean flag=false;
		for(int i=0;i<A.length();i++)
		{
			flag=true;
			if(!Character.isDigit(A.charAt(i)))
				return 0;
		}
		if(flag)
			return 1;
				
		return 0;
    }

}
