package interviewBit.backtracking;

public class ModularExpression {
	public static int sign=1;
	public static void main(String[] args) {
		System.out.println(-1%20);
		System.out.println(Mod(-3,3,7));
	}
	
	public static int Mod(int a, int b, int c) {
		if(a == 0) return 0;
	    if(b == 0) return 1;
	    long ans = 1;
	    long sq = a;
	    while (b > 0) {
	        if (b%2 == 1) {
	            ans = ans*sq;
	            ans %= c;
	        }
	        sq = sq*sq;
	        sq %= c;
	        b/=2;
	    }
	    ans %= c;
	    ans = (ans+c)%c;
	    return (int) ans;
    }

}
