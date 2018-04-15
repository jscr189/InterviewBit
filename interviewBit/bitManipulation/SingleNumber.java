package interviewBit.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

	public static void main(String[] args) {
		int arr[]={1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
		List<Integer> A=new ArrayList<Integer>();
		for(int i:arr)
			A.add(i);
		System.out.println(singleNumber(A));
	}
	
	public static int singleNumber(final List<Integer> A) {
		int a[]=new int[32];
	       for(int i=0;i<A.size();i++)
	       {
	           int num=A.get(i);
	           for(int j=0;j<32;j++)
	           {
	               a[j]+=num&1;
	               num=num>>1;
	           }
	       }
	       
	       int num=0;
	       for(int i=0;i<32;i++)
	       {
	           if(a[i]%3!=0)
	           num+=(int)Math.pow(2,i);
	       }
	       return num;
    }

}
