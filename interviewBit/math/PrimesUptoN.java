package interviewBit.math;

import java.util.ArrayList;

public class PrimesUptoN {
	
	public static void main(String[] args) {
		System.out.println("primeuptoN:"+primeuptoN(25));
		System.out.println("sieve:"+sieve(25));
	}
	
	public static ArrayList<Integer> primeuptoN(int a) {
        int primes[]=new int[a+1];
        ArrayList<Integer> arr=new ArrayList<Integer>();
        primes[0]=0;primes[1]=0;
        for(int i=2;i<=a;i++)
            primes[i]=1;
        for(int i=2;i<=Math.sqrt(a);i++)
        {
            if(primes[i]==1)
            {
                for(int j=2;i*j<=a;j++)
                    primes[i*j]=0;
            }
        }
        for(int i=2;i<=a;i++)
        	if(primes[i]==1)
        		arr.add(i);
        return arr;
	}
	
	public static ArrayList<Integer> sieve(int a) {
	    ArrayList<Integer> arr=new ArrayList<Integer>();
	    for(int i=2;i<=a;i++)
        {
            if(isPrime(i))
            {
                arr.add(i);
            }
        }
        return arr;
	}
	public static boolean isPrime(int n) {
	    if(n==2) return true;
		if(n<2||n%2==0) return false;
	    for(int i = 3; i*i <= n; i+=2) if(n%i==0) return false;
	    return true;
	}
}
