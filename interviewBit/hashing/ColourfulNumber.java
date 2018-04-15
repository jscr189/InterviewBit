package interviewBit.hashing;

import java.util.HashMap;

public class ColourfulNumber {

	public static void main(String[] args) {
		System.out.println(colorful(12));
	}
	
	public static int colorful(int A) {
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		int C=A;
		while(A>0)
		{
			int B=A;
			while(B>0)
			{
				int x=B;
				if(x!=C)
				{
					if(hm.containsKey(prod(x)))
						return 0;
					else
						hm.put(prod(x),1);
				}
				B=B/10;
			}
			if(A>9)
				A=Integer.parseInt((""+A).substring(1));
			else
				A=0;
		}
		return 1; 
    }

	private static int prod(int x) {
		int y=1;
		while(x>0)
		{
			y*=x%10;
			x/=10;
		}
		return y;
	}

}
