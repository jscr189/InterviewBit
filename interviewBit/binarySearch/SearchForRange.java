package interviewBit.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class SearchForRange {

	public static void main(String[] args) {
		int arr[]={5, 7, 7,8, 9, 9, 10};
		ArrayList<Integer> b=new ArrayList<Integer>();
		for(int i:arr)
			b.add(i);
		System.out.println(searchRange(b,9));
	}
	
	public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		int start=0,end=a.size()-1;
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(binarySearch(a, b, start, end, true));
		al.add(binarySearch(a, b, start, end, false));
		return al;
	}
	public static int binarySearch(final List<Integer> a, int b,int start,int end,boolean flag) {
		int res=-1;
		if(a.size()>0&&(b<a.get(0)||b>a.get(a.size()-1))) return res;
		while(start<=end)
		{
			int mid=start+(end-start)/2;
			if(a.get(mid)==b)
			{
				res=mid;
				if(flag)
					end=mid-1;
				else
					start=mid+1;
			}
			else if(a.get(mid)>b)
				end=mid-1;
			else
				start=mid+1;
		}
		return res;
	}


}
