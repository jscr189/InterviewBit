package interviewBit.strings;

import java.util.LinkedList;

public class PrettyJSON {

	public static void main(String[] args) {
		//String ips[]=prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
		//String ips[]=prettyJSON("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]");
		String ips[]=prettyJSON("[{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12},{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}]");
		for(String x:ips)
			System.out.println(x);
	}
	
	public static String[] prettyJSON(String A) {
		LinkedList<String> ll=new LinkedList<String>();
		
		ll=prettyJSONRecur(A,ll,"");
		
		String s[]=new String[ll.size()];
		int i=0;
		for(String x:ll)
			s[i++]=x;
		return s;
    }
	
	public static LinkedList<String> prettyJSONRecur(String A,LinkedList<String> ll,String prefix) {
		
		
		A=A.trim();
		if(A.length()==0)
			return ll;
		
		while(A.length()>0)
		{
			A=A.trim();
			if(A.charAt(0)=='{'||A.charAt(0)=='[')
			{
				ll.add(prefix+A.charAt(0));
				prefix+="\t";
				if(A.length()>1)
					A=A.substring(1);
				else
					A="";
			}
			else if(A.charAt(0)=='}'||A.charAt(0)==']')
			{
				if(prefix.length()>="\t".length())
					prefix=prefix.substring("\t".length());
					
				String end=prefix+A.charAt(0);
				if(A.length()>1)
					A=A.substring(1).trim();
				else
					A="";
				if(A.length()>1&&A.charAt(0)==',')
				{
					end+=",";
					A=A.substring(1).trim();					
				}
				ll.add(end);
			}
			else
			{
				int p=0;
				while(A.charAt(p)!=','&&A.charAt(p)!='['&&A.charAt(p)!=']'&&A.charAt(p)!='{'&&A.charAt(p)!='}')
					p++;
				if(A.charAt(p)==',')
					p++;
				ll.add(prefix+A.substring(0,p));
				
				if(A.length()>p)
					A=A.substring(p);
				else
					A="";
			}			
		}
		
		return ll;
	}

}
