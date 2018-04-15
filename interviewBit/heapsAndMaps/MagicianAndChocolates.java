package interviewBit.heapsAndMaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

	public static void main(String[] args) {
		int a[]={2147483647, 2000000014, 2147483647};
		ArrayList<Integer> B=new ArrayList<Integer>();
		for(int i:a)
			B.add(i);
		System.out.println(nchoc(10, B));
	}
	
	public static int nchoc(int A, ArrayList<Integer> B) {
		int sum=0;
		int mod=(int)Math.pow(10, 9)+7;
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i:B)
			pq.add(i);
		
		while(A-- > 0)
		{
			int x=pq.poll();
			sum=(sum%mod+x%mod)%mod;
			pq.add((int)Math.floor(x/2));
		}
		
		return sum;
    }

}
