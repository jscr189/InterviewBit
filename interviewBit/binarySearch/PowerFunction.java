package interviewBit.binarySearch;

import java.util.HashMap;

public class PowerFunction {

	public static void main(String[] args) {
		System.out.println(pow(-1, 3, 3));
		//System.out.println(pow(79161127, 99046373, 57263970));
	}
	
	public static int pow(int x, int n, int d) {
		int p=1;
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		hm.put(1, Math.abs(x));
		p=powRec(Math.abs(x),n,d,hm);
		return (x>=0||n%2==0)?p%d:d-(p%d);
	}
	
	public static int powRec(int x, int n, int d,HashMap<Integer,Integer> hm) {
		if(x==0)
			return 0;
		if(hm.get(n)!=null)
			return hm.get(n);
		if(n==0)
			return 1;
		if(n==1)
			return x%d;
		
		int mid=n/2;
		int y=0;
		if(n%2==0)
			y=mulmod((powRec(x, mid, d, hm)%d),(powRec(x, mid, d, hm)%d),d);
		else
			y=mulmod((powRec(x, mid, d, hm)%d),(powRec(x, mid+1, d, hm)%d),d);
		hm.put(n, y);
		return y;
	}
	
	public static int mulmod(int a, int b, int mod)
	{
	    int res = 0; // Initialize result
	    a = a % mod;
	    while (b > 0)
	    {
	        // If b is odd, add 'a' to result
	        if (b % 2 == 1)
	            res = (res + a) % mod;
	 
	        // Multiply 'a' with 2
	        a = (a * 2) % mod;
	 
	        // Divide b by 2
	        b /= 2;
	    }
	 
	    // Return result
	    return res % mod;
	}

}
