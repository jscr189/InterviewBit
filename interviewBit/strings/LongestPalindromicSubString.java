package interviewBit.strings;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestPalindromicSubString {
	static HashMap<String,String> hm=new HashMap<String,String>();
	static ArrayList<String> al=new ArrayList<String>();
	static String palin="";
	public static void main(String[] args) {
		System.out.println(longestPalindrome("aabcdeaaa"));
	}
	
	public static String longestPalindrome(String a) {
	    int max=0;
	    int maxStart=0;
	    int maxEnd=0;
	    char[] ary = a.toCharArray();
	    for(int i =0; i< ary.length-1; i++){
	        if(ary[i] == ary[i+1]){
	            int subLength = checkPalin(ary,i,i+1); 
	            if(subLength>max){
	                max = subLength;
	                
	                int gap = (subLength-2)/2;
	                maxStart = i-gap;
	                maxEnd = i+1+gap;
	                //System.out.print(subLength+" "+maxStart+" "+maxEnd);
	            }
	        }
	        if(i < ary.length-2){
	            if(ary[i] == ary[i+2]){
	            int subLength = checkPalin(ary,i,i+2); 
	              if(subLength>max){
	                
	                max = subLength;
	                int gap = (subLength-3)/2;
	                maxStart = i-gap;
	                maxEnd = i+2+gap;
	                //System.out.print(subLength+" "+maxStart+" "+maxEnd);
	               }
	            }    
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    for(int j=maxStart;j<=maxEnd;j++){
	        sb.append(ary[j]);
	    }
	    return sb.toString();
	}
	public static int checkPalin(char[] ary,int start, int end){
	   //System.out.println(start+" "+end+" ");
	    int count = 0;
	    if(end - start == 1){
	            count = 2;
	    }else{
	            count = 3;
	    }
	    if(start == 0){
	        return count;
	    }
	    if(end == ary.length-1){
	        return count;
	    }
	    start = start -1;
	    end = end+1;
	    while(start>=0 && end <ary.length){
	        char a = ary[start];
	        char b = ary[end];
    	     if(a==b){
    	         //System.out.print(start+" "+a+" "+end+" "+b+" ");
    	        count = count +2;
    	     start--;
    	     end++;
    	         
    	     }else{
    	         return count;
    	     }   
    	    
	    }
	    //System.out.print(count);
	    //System.out.println();
	    return count;
	}
	
	public static String longestPalindrome2(String A) {
		if(A.length()==0)
			return "";
		palin=A.charAt(0)+"";
		for(int k=A.length();k>1;--k)
		{
			for(int i=0;i+k<=A.length();++i)
			{
				String B=A.substring(i,k+i);
				if(al.contains(B))
					continue;
				if(B.equals(new StringBuilder(B).reverse().toString()))
				{
					if(B.length()>palin.length())
					{
						palin=B;
						return palin;
					}
				}
				al.add(B);
			}
		}
		
		return palin;
    }
	
	public static String longestPalindrome1(String A) {
		if(A.length()<2)
			return A;
		return longestPalindromeRec(A);
    }
	
	public static String longestPalindromeRec(String A) {
		if(hm.containsKey(A))
			return hm.get(A);
		if(A.length()==1)
		{
			if(A.length()>palin.length())
			{
				palin=A;
				return palin;
			}
			else
				return null;
		}
		if(A.length()<palin.length())
			return null;
		if(A.equals(new StringBuilder(A).reverse().toString()))
		{
			if(A.length()>palin.length())
			{
				palin=A;
				return palin;
			}
		}
		String x=longestPalindromeRec(A.substring(0,A.length()-1));
		hm.put(A.substring(0,A.length()-1), x);
		x=longestPalindromeRec(A.substring(1));
		hm.put(A.substring(1), x);
		return palin;
    }

}
