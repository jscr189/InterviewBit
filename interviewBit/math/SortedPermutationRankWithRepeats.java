package interviewBit.math;

public class SortedPermutationRankWithRepeats {

	public static void main(String[] args) {
		String s="bbbbaaaa";
		System.out.println((new SortedPermutationRankWithRepeats()).findRank(s));
	}

	private static final int M = 1000003;
	public int findRank(String a) {
	    int n = a.length();
	    long[] facts = new long[n + 1];
	    long[] infacts = new long[n + 1];
	    facts[0] = infacts[0] = 1;
        for (int i = 1; i <= n; i++) {
            facts[i] = (facts[i - 1] * i) % M;
            infacts[i] = modExp(facts[i], M - 2);
            //System.out.println(i + " " + facts[i] + " " + infacts[i]);
        }
        
        int[] c = new int[52];
        for (char ch : a.toCharArray()) {
            c[o(ch)]++;
        }
        
        long rank = 0;
        int count = a.length();
        for (char ch : a.toCharArray()) {
            count--;
            for (int t = 0; t < o(ch); t++) {
                if (c[t] > 0) {
                    c[t]--;
                    long trank = facts[count];
                    //System.out.println("t" + trank);
                    for (int i = 0; i < 52; i++) {
                        if (c[i] > 0) {
                            trank = (trank * infacts[c[i]]) % M;
                            //System.out.println("t" + trank);
                        }
                    }
                    rank = (rank + trank) % M;
                    //System.out.println("r" + rank);
                    c[t]++;
                }
            }
            c[o(ch)]--;
        }
	    return new Long((rank + 1) % M).intValue();
	}
	
	private int o(char ch) {
	    if (ch <= 'Z') return ch - 'A';
	    return ch - 'a' + 26;
	}
	
	public long modExp(long xint, long yint) {
	    long res = 1;
	    long x = xint;
	    long y = yint;
	    //System.out.println("Exp " + x + " " + y + " " + res);
	    while (y > 0) {
	        if ((y & 1) == 1) {
	            res = (res * x) % M;
	        }
	        x = (x * x) % M;
	        y >>= 1;
	    //System.out.println("Exp " + x + " " + y + " " + res);
	    }
	    //return new Long(res).intValue();
	    return res;
	}

}