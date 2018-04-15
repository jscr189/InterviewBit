package interviewBit.strings;

import java.util.HashMap;

public class RomanToInteger {


	
	public static void main(String[] args) {
		System.out.println(romanToInt("DXLIV"));
	}
	
	public  static int romanToInt(String A) {
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);
		int tot=0;
		
		for(int i=0;i<A.length();i++)
		{
			int k=1;
			char c1=A.charAt(i);
			while((i+k)<A.length()&&A.charAt(i+k)==c1)
				++k;
			if((i+k)<A.length()&&k==1&&A.charAt(i+k)!=c1&&hm.get(A.charAt(i+k))>hm.get(c1))
			{
				tot+=hm.get(A.charAt(i+k))-hm.get(c1);
				i++;
			}
			else
				tot+=hm.get(A.charAt(i))*k;
			i+=k-1;
		}
		
		return tot;
    }

}
