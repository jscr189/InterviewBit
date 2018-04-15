package interviewBit.twoPointers;

import java.util.ArrayList;

public class RemoveArrayElement {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(4);c.add(1);c.add(1);c.add(2);c.add(1);c.add(3);
		System.out.println(removeElement(c,1));
	}
	
	public static int removeElement(ArrayList<Integer> a, int b) {
		/*for(int i=a.size()-1;i>=0;i--)
		{
			if(a.get(i)==b)
				a.remove(i);
		}
		return a.size();*/
		int i;
	    int k=0;
	    for(i=0;i<a.size();i++)
	    {
	        if(a.get(i)!=b)
	        {
	            a.set(k, a.get(i));
	            k++;
	        }
	    }
	    System.out.println(a);
		return k;
	}

}
