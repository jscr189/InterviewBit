package interviewBit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(2,7,11,15);
		System.out.println(twoSum(A,19));
	}
	
	public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<A.size();i++)
		{
			if(hm.containsKey(A.get(i)))
			{
				al.add(hm.get(A.get(i)));
				al.add(i+1);
				break;
			}
			else
				hm.put(B-A.get(i),i+1);
		}
		
		return al;
    }

}
