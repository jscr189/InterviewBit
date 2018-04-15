package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingTriangles {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(1);c.add(1);c.add(1);c.add(2);//c.add(2);
		System.out.println(nTriang(c));
	}
	
	public static int nTriang(ArrayList<Integer> A) {
		 if(A==null)return 0;
	        int S[]=new int [A.size()];
	        for(int i =0;i<A.size();i++)
	        S[i]=A.get(i);
	        Arrays.sort(S);
	        long count = 0;
	        for (int i = 0; i < S.length; i++) {
	            int left = 0;
	            int right = i - 1;
	            while (left < right) {
	                if (S[left] + S[right] > S[i]) {
	                    // The edge from S[left] to S[right - 1] will also form a triangle
	                    count += right - left;
	                    right--;
	                } else {
	                    left++;
	                }
	            }
	            
	        }
	        count%=1000000007;
	        return (int)count;
    }
	
}
