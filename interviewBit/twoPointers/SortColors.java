package interviewBit.twoPointers;

import java.util.ArrayList;

public class SortColors {

	public static void main(String[] args) {
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(2);c.add(0);c.add(0);c.add(1);c.add(0);c.add(0);c.add(2);c.add(2);
		sortColors(c);
		System.out.println(c);
	}
	
	public static void sortColors(ArrayList<Integer> a) {
		/*int zeroPos=0,twoPos=a.size()-1;
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i)==0){
				if(zeroPos<i)
				{
					a.remove(i);
					i--;
					a.add(zeroPos,0 );
				}
				zeroPos++;
			}
			if(a.get(i)==2){
				if(twoPos>i)
				{
					a.remove(i--);
					a.add(2);
				}
				twoPos--;
			}
		}*/
		int zeroes=0,twos=0,ones=0;
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i)==0)
				zeroes++;
			else if(a.get(i)==2)
				twos++;
			else
				ones++;
		}
		for(int i=0;i<zeroes;i++)
			a.set(i, 0);
		for(int i=zeroes;i<zeroes+ones;i++)
			a.set(i, 1);
		for(int i=zeroes+ones;i<a.size();i++)
			a.set(i, 2);
	}

}
