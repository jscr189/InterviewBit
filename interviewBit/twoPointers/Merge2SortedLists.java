package interviewBit.twoPointers;

import java.util.ArrayList;

public class Merge2SortedLists {

	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(1);a.add(3);a.add(5);a.add(6);a.add(115);a.add(116);
		ArrayList<Integer> b=new ArrayList<Integer>();
		b.add(2);b.add(4);b.add(7);b.add(8);b.add(9);
		merge(a,b);
		System.out.println(a);
	}
	
	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		for(int i=0,j=0;i<a.size()||j<b.size();)
		{
			if(i>=a.size())
			{
				a.add(b.get(j));
				j++;
			}
			else if(j>=b.size())
			{
				break;
			}
			else
			{
				if(a.get(i)>b.get(j))
				{
					a.add(i, b.get(j++));
				}
				i++;
			}
		}
	}

}
