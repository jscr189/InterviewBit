package interviewBit.arrays;

import java.util.ArrayList;

public class FlipBits {

	public static void main(String[] args) {
		int A[]=flip("001000100");
		for(int i:A)
			System.out.println(i+" ");
		}
	
	public static int[] flip(String A) {
        char[] array = A.toCharArray();
        int[] zeroToOne = new int[A.length()];
        int[] ans = new int[2];

       for(int i=0;i<array.length;i++){
           if(array[i]=='0'){
               zeroToOne[i]=1;
           }else{
               zeroToOne[i]=-1;
           }
       }

       int cumulative=0,left=0,right=0,max_sum=0;
        int left_ans=0,right_ans=0;
       for(int i=0;i<A.length();i++){
           cumulative+=zeroToOne[i];

           if(cumulative<0){
               left=i+1;
               cumulative=0;
           }else{
               if(cumulative>max_sum){
                   max_sum=cumulative;
                   left_ans=left;
                   right_ans=i;
               }
           }
       }

       if(max_sum<=0){
           return new int[0];
       }else{
           ans[0]=left_ans+1;
           ans[1]=right_ans+1;
       }
       return ans;
	}
}
