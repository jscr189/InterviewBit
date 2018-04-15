package interviewBit.backtracking;

import java.util.ArrayList;

public class KthPermutationSequence {

	public static void main(String[] args) {
		System.out.println(getPermutation(11, 3));
	}
	
	public static String getPermutation(int n, int k) {
			if(k>fact(n)) return "";    
		    ArrayList<Integer> list = new ArrayList<>();
		    
		    for(int i=1;i<=n;i++)
		    {
		        list.add(i);
		    }
		    return getPermutation(list,k-1);
		    
		}
		
		public static String getPermutation(ArrayList<Integer> list,int k)
		{
		    int n=list.size();
		    if(n==0) return "";
		    
		    int fact_n=fact(n-1);
		    int index=k/fact_n;
		    int num=list.get(index);
		    list.remove(index);
		    k%=fact_n;
		    return num+getPermutation(list,k);
		}
		
		static int fact(int n)
		{
		    if(n>12) return Integer.MAX_VALUE;
		
			int fact=1;
			for(int i=2;i<=n;i++)
			{
			    fact*=i;
			}
			
			return fact;
		}

}
