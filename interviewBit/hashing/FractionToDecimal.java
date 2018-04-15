package interviewBit.hashing;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(87000000, 22));
	}
	
	public static String fractionToDecimal(int A, int B) {
		long a=A,b=B;
        if(a%b==0) return String.valueOf(a/b);
        Map<Long,Integer> map=new HashMap<>();
        StringBuilder res=new StringBuilder();
        if((a>0&&b<0)||(a<0&&b>0)) res.append("-");
        a=Math.abs(a);
        b=Math.abs(b);
        res.append(a/b+".");
        a=(a%b)*10;
        while(!map.containsKey(a)){
            map.put(a,res.length());
            res.append(String.valueOf(a/b));
            a=(a%b)*10;
            if(a==0) return res.toString();
        }
        return res.insert(map.get(a),"(").append(")").toString();
    }

}
