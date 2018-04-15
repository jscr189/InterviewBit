package interviewBit.twoPointers;

import java.util.ArrayList;

public class RemoveDuplicates {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(0);c.add(1);c.add(1);c.add(1);c.add(1);c.add(2);c.add(2);c.add(2);
		System.out.println(removeDuplicates(c));
	}
	
	public static int removeDuplicates(ArrayList<Integer> a) {
		int count=0;
		for(int i=a.size()-2;i>=0;i--)
		{
			if(a.get(i).equals(a.get(i+1)))
			{
				count++;
				if(count>=1)
					a.remove(i+1);
			}
			else
				count=0;
		}
		return a.size();
	}

}
