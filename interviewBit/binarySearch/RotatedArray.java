package interviewBit.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class RotatedArray {

	public static void main(String[] args) {
		int arr[]={9,10,4,5,7,7,7,8,8};
		List<Integer> a=new ArrayList<Integer>();
		for(int i:arr)
			a.add(i);
		System.out.println(findMin(a));
	}
	
	public static int findMin(final List<Integer> a) {
		
		for(int i=0;i<a.size()-1;i++)
		{
			if(a.get(i)>a.get(i+1))
				return a.get(i+1);
		}
		
		return a.get(0);
	}

}
