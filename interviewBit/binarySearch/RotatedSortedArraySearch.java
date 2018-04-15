package interviewBit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		int arr1[]={180, 181, 182, 183, 184, 3, 4, 5, 6, 7, 8, 9, 10,11,12 };
		List<Integer> a=new ArrayList<Integer>();
		for(int i:arr1)
			a.add(i);
		//System.out.println(getPivot(a));
		System.out.println(search(a, 184));
		//System.out.println(binarySearch1(a, 42, 0, a.size()-1));
	}
	
	public static int search(final List<Integer> a, int b) {
		int i=0;
	    int j=a.size()-1;
	    
	    while(i<=j) {
	        int mid = (i +j)/2;
	        
	        if(a.get(mid)==b)
	            return mid;
	        if(a.get(mid)>=a.get(i)) {
	            if(b>=a.get(i)&&b<a.get(mid))
	                j=mid-1;
	            else
	                i=mid+1;
	        }
	        else {
	            if(b>a.get(mid)&&b<=a.get(j))
	                i=mid+1;
	            else
	                j=mid-1;
	        }
	    }
	    return -1;
		/*int start=0,end=a.size()-1,pivot=0;
		if(end<0)
			return -1;
		if(end==0&&a.get(end)!=b)
			return -1;
		else if(end==0&&a.get(end)==b)
			return end;
		return binarySearch1(a, b, start, end);*/
	}
	
	public static int binarySearch(final List<Integer> a,int b,int start,int end)
	{
		int mid=0;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(a.get(mid)==b)
				return mid;
			else if(a.get(mid)<b)
				start=mid+1;
			else
				end=mid-1;
		}
		return -1;
	}
	
	public static int binarySearch1(final List<Integer> a,int b,int start,int end)
	{
		int mid=0;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(a.get(mid)==b)
				return mid;
			else if(start==end)
				return -1;
			else if(b==a.get(start))
				return start;
			else if(b==a.get(end))
				return end;
			if(a.get(start)<a.get(end))
			{
				if(a.get(mid)<b)
					start=mid+1;
				else if(a.get(mid)>b)
					end=mid-1;
			}
			else
			{
				if(a.get(mid)<b&&b>a.get(start))
				{
					end=mid-1;
				}
				else if(a.get(mid)<b&&a.get(mid)<a.get(end))
				{
					start=mid+1;
				}
				else if(a.get(mid)>b&&a.get(mid)<a.get(end))
				{
					end=mid-1;
				}
				else if(a.get(mid)>b&&a.get(mid)>a.get(end))
				{
					start=mid+1;
				}
			}
		}
		return -1;
	}
	
	public static int getPivot(final List<Integer> a)
	{
		int start=0,end=a.size()-1,mid=0;
		if(a.get(start)>a.get(start+1))
			return start;
		if(a.get(end)<a.get(end-1))
			return end;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(a.get(mid)>a.get(mid-1)&&a.get(mid)>a.get(mid+1))
				return mid;
			else if(a.get(mid)<a.get(start))
				end=mid-1;
			else if(a.get(mid)>a.get(end))
				start=mid+1;
		}
		return mid;
	}

}
