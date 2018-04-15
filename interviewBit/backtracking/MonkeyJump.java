package interviewBit.backtracking;

public class MonkeyJump {

	public static void main(String[] args) {
		int A[]={1,7,1,2,1,-1,3,5,-1,-1};
		System.out.println(solution(A, 3));
	}
	
	public static int solution(int A[],int D)
	{
		int n=A.length,max=Integer.MIN_VALUE;
		for(int i=n-1;i>=D-1;i--)
		{
			int k=0,min=Integer.MAX_VALUE;
			while(k<D)
			{
				if(A[i-k]<min&&A[i-k]!=-1)
					min=A[i-k];
				k++;
			}
			if(min==Integer.MAX_VALUE)
				return -1;
			else
			{
				if(max<min)
					max=min;
			}
		}
		return max;
	}

}
