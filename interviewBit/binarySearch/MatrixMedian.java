package interviewBit.binarySearch;

public class MatrixMedian {

	public static void main(String[] args) {
		int[][] A={{1,3,5},{2,6,9},{3,6,9},{4,8,9},{6,9,10}};
		System.out.println(findMedian(A));
	}
	
	public static int findMedian(int[][] A) {
		int n=A.length;
		if(n == 0) return -1;
		int lo = 0;
        int hi = Integer.MAX_VALUE;
        int x = 1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(isLessThanHalf(A, mid)) {
                lo = mid+1;
            } else {
                x = mid;
                hi = mid-1;
            }
        }
        return x;
    }

	private static boolean isLessThanHalf(int[][] a, int mid) {
		int N=a.length;
		int M=a[0].length;
		int count = 0;
         
	    for(int i = 0; i < N; i++) {
	    	count += getCount(a[i], mid);
	    }
	    
	    return count < (N*M)/2 + 1;
	}

	private static int getCount(int[] is, int n) {
		 int lo = 0;
	     int hi = is.length-1;
	     while(lo <= hi) {
	     int mid = (lo+hi)/2;
	     if(is[mid] > n) hi = mid-1;
	     else lo = mid+1;
	     }
	     return lo;
	}

}
