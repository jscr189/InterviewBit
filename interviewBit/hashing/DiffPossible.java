package interviewBit.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DiffPossible {

	public static void main(String[] args) {
		List<Integer> A=Arrays.asList(11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13);
		System.out.println(diffPossible(A, 60));
	}
	
	public static int diffPossible(final List<Integer> A, int B) {
		HashSet<Integer> hm=new HashSet<Integer>();
		for(int i=0;i<A.size();i++)
		{
			int a=A.get(i);
			if(hm.contains(a))
				return 1;
			else
			{
				hm.add(B+a);
				hm.add(a-B);
			}
		}
		return 0;
    }

}
