package interviewBit.heapsAndMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNoOfWindows {

	public static void main(String[] args) {
		int a[]={1,2,1,3,1,1,1};
		ArrayList<Integer> A=new ArrayList<Integer>();
		for(int i:a)
			A.add(i);
		System.out.println(dNums(A, 5));
	}
	
	public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		if(A.size()<B)
			return new ArrayList<Integer>();
		ArrayList<Integer> al=new ArrayList<Integer>(A.size()-B+1);
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<B;i++)
		{
			if(hm.containsKey(A.get(i)))
				hm.put(A.get(i), hm.get(A.get(i))+1);
			else
				hm.put(A.get(i), 1);
		}
		al.add(hm.size());
		for(int i=B;i<A.size();i++)
		{
			if(hm.containsKey(A.get(i-B)))
			{
				if(hm.get(A.get(i-B))==1)
					hm.remove(A.get(i-B));
				else
					hm.put(A.get(i-B), hm.get(A.get(i-B))-1);
			}
			if(hm.containsKey(A.get(i)))
				hm.put(A.get(i), hm.get(A.get(i))+1);
			else
				hm.put(A.get(i), 1);
			al.add(hm.size());
		}
			
		
		return al;
    }

}
