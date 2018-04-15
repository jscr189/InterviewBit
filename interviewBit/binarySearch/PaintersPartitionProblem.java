package interviewBit.binarySearch;

public class PaintersPartitionProblem {

	public static void main(String[] args) {
		int C[]={1, 1000000};
		int A=1,B=1000000;
		System.out.println(paint(A, B, C));
	}
	
	public static int paint(int A, int B, int[] C) {
		int div=10000003;
		if(C.length==0)
			return -1;
		if(C.length==1)
			return C[0]*B;
		
		 int max = 0;
		   for(int i =0;i<C.length;i++)
		   {
		       max +=(int)(((long)C[i])%10000003);
		       max = max%10000003;
		   }
		
		int start = 1, end = max,mid= (start + end) / 2;
		while(start<end)
		{
			mid = start/2 + end / 2;
			if(isPossible(A,B,C,mid))
			{
				end = mid;
			}
			else 
			{
				start = mid + 1;
			}
		}			
		return (int)(((long)end*B)%10000003);
    }

	private static boolean isPossible(int A,int B, int[] C, int mid) {
		int painterCount =1;
	    int currentTime = 0;
	    for(int i = 0;i<C.length;i++)
	    {
	        currentTime += C[i];
	        if(currentTime >mid) {
	            painterCount+=1;
	            currentTime = C[i];
	            if(currentTime>mid || painterCount>A) return false;
	        }
	    }
	    return true;
	}

}
