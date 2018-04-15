package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class LargestNumber {

	public static void main(String[] args) {
		int[] A={0,0,0 };
		System.out.println(largestNumber3(A));
		int B[]={980, 674, 250, 359, 98, 969, 143, 379, 363, 106, 838, 923, 969, 880, 997, 664, 152, 329, 975, 377, 995, 943, 369, 515, 722, 302, 496, 124, 692, 993, 341, 785, 400, 113, 302, 563, 121, 230, 358, 911, 437, 438, 494, 599, 168, 866, 689, 444, 684, 365, 470, 176, 910, 204, 324, 657, 161, 884, 623, 814, 231, 694, 399, 126, 426 };
		System.out.println(largestNumber3(B));
	}

	public static String largestNumber(final int[] A) {
			String s="";
			ArrayList<String> al=new ArrayList<String>();
			for(int i:A)
				al.add(i+"");

			Collections.sort(al);
			
			String min="";
			for(String x:al)
			{
				if(s.length()>0&&(x.charAt(0)==s.charAt(0)))
				{
					if(x.charAt(0)=='0')
						continue;
					if(Long.parseLong(min+x)>=Long.parseLong(x+min))
					{
						int lastIndex=s.lastIndexOf(min);
						if(lastIndex==-1)
							s=s+x;
						else
						{
							int len=lastIndex+min.length();
							s=s.substring(0,len)+x+((len)<s.length()?s.substring(len):"");
						}
					}
					else
					{
						s=x+s;min=x;
					}
					
				}							
				else
				{
					s=x+s;min=x;
				}
			}
			
			return s;
	    }
	
	public static String largestNumber2(final int[] A) {
		String s="";
		ArrayList<String> al=new ArrayList<String>();
		for(int i:A)
			al.add(i+"");
		Collections.sort(al,new Comparator<String>() {
		 public int compare(String obj1, String obj2) {
		  return (obj1+obj2).compareTo(obj2+obj1);
		 }
		}); 
		
		
		for(String x:al)
		{
			if(s.equals("0")&&x.equals("0"))
				continue;
			s=x+s;
		}
		
		return s;
    }
	
	public static String largestNumber3(final int[] a) {
	    List<String> strs = new ArrayList<String>();
	    for(Integer i : a){
	        strs.add(String.valueOf(i));
	    }
	    
	    Collections.sort(strs, new MyCompartor());
	    
	     StringBuffer strBuf = new StringBuffer();
	    for(String s : strs){
	        if("0".equals(s) && strBuf.length() != 0) {
	            continue;   
	        }
	        strBuf.append(s);
	    }

	    return strBuf.toString();
	}
}
	
	class MyCompartor implements Comparator<String>{
	    @Override
	    public int compare(String s1, String s2){
	        String first = s1 + s2;
	        String second = s2 + s1;
	        return second.compareTo(first);
	    }
	}
