package interviewBit.bitManipulation;

import java.util.ArrayList;

public class DiffBitsSumPairWise {

	public static void main(String[] args) {
		ArrayList<Integer> A=new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(4);
		System.out.println(cntBits(A));
	}
	
	public static int cntBits(ArrayList<Integer> A) {
		int c=0,mod=1000000007;
		c=A.get(0);
		for(int i=1;i<A.size();i++)
		{
			c^=A.get(i);
		}
		return c;
	}
	
	public static int cntBits1(ArrayList<Integer> A) {
		int c=0,mod=1000000007;
		for(int i=0;i<A.size()-1;i++)
			for(int j=i+1;j<A.size();j++)
			{
				int x=A.get(i),y=A.get(j);
				c+=(2*setBits(x^y)%mod)%mod;
			}
		return c;
    }

	private static int setBits(int i) {
		int tot=0;
		while(i>0)
		{
			int B=i&1;
			if(B==1)
				tot++;
			i>>=1;
		}
		return tot;
	}

}
