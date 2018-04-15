package interviewBit.binarySearch;

import java.util.ArrayList;

public class SortedInsertPosition {

	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(1);a.add(3);a.add(5);a.add(6);
		/*System.out.println(searchInsert(a,5));
		System.out.println(searchInsert(a,2));
		System.out.println(searchInsert(a,7));
		System.out.println(searchInsert(a,0));*/
		
		int arr[]={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152};
		ArrayList<Integer> b=new ArrayList<Integer>();
		for(int i:arr)
			b.add(i);
		System.out.println(searchInsert(b,152));
	}
	
	public static int searchInsert(ArrayList<Integer> a, int b) {
		int start=0,end=a.size()-1,mid=0;
		if(a.size()>0&&a.get(0)>b)
			return 0;
		while(start<=end)
		{
			mid=start+(end-start)/2;
			if(a.get(mid)==b)
				return mid;
			else if(a.get(mid)>b)
			{
				end=mid-1;
			}
			else
				start=mid+1;
		}
		return mid;
	}

}
