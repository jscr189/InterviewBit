package interviewBit.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {

	public static void main(String[] args) {
		int arr[]={1,6,7,8};
		List<Integer> a=new ArrayList<Integer>();
		for(int i:arr)
			a.add(i);
		int arr1[]={3,4,5};
		List<Integer> b=new ArrayList<Integer>();
		for(int i:arr1)
			b.add(i);
		System.out.println(findMedianSortedArrays(a, b));

	}
	
	public static double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
	    int len = A.size() + B.size();
	    if(len % 2 == 1) return findKth(A, 0, B, 0, len / 2 + 1);
	    else return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
	}
	
	public static int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
	    if(A_start >= A.size()) return B.get(B_start + k - 1);
	    if(B_start >= B.size()) return A.get(A_start + k - 1);
	    if(k == 1) return Math.min(A.get(A_start), B.get(B_start));
	    
	    int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
	    int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;
	    
	    if(A_key < B_key){
	        return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
	    }
	    else
	       return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
	}

}
