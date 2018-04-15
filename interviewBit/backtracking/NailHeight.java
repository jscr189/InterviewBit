package interviewBit.backtracking;

import java.util.Arrays;

public class NailHeight {

	public static void main(String[] args) {
		int A[]={3,3,3,4,4,5,5,5,5,5,5};
		System.out.println(solution(A, 2));
	}
	
	public static int solution1(int[] A, int K) {
        int n = A.length;
        int best = 0;
        int count = 1;
        Arrays.sort(A);
        for (int i = 0; i < n-1; i++) {
            if (A[i] == A[i + 1])
                count = count + 1;
            else 
            {	
            	if(i+K<n)
            		count+=K;
            	if (count > best)
                    best = count;
            	count = 1;
            }
            if (count > best)
                best = count;
        }
        return best;
    }
	
	    public static int solution(int[] A, int K) {
	        int n = A.length;
	        int best = 0;
	        int count = 1;
	        for (int i = 0; i < n - K - 1; i++) {
	            if (A[i] == A[i + 1])
	                count = count + 1;
	            else
	                count = 1;
	            if (((i+K)<n?(count+K):count) > best)
	                best = ((count+K)<n?(count+K):count);
	        }

	        return best;
	    }
 

	 
	 
	


}
