package interviewBit.twoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(1);c.add(5);c.add(4);c.add(3);
		System.out.println(maxArea(c));
	}
	
	public static int maxArea(ArrayList<Integer> A) {
		int max=0;
		
		for(int i=0;i<A.size()-1;i++)
		{
			for(int j=i+1;j<A.size();j++)
			{
				int x=Math.abs(A.get(i) - A.get(j))*Math.min(A.get(i), A.get(j));
				if(x>max)
					max=x;
			}
		}
		
		return max;
    }

}
