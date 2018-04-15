package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class NextPermutation {

	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(5);a.add(1);a.add(4);a.add(3);a.add(2);
		System.out.print(a+"=>");
		nextPermutation(a);
		System.out.println(a);
	}
	public static void nextPermutation(ArrayList<Integer> a) {
		int x=-1,tmp=-1;
		TreeSet<Integer> sortedArray=new TreeSet<Integer>();
		for(int i=0;i<a.size()-1;i++)
		{
			if(a.get(i)<a.get(i+1))
			{
				x=i;tmp=a.get(i);sortedArray.remove(a.get(i));
			}			
		}
			
		if(x==-1)
			Collections.sort(a);
		else
		{
			for(int i=x;i<a.size();i++)
				sortedArray.add(a.get(i));
			for(Integer i:sortedArray)
			{
				if(i>tmp)
				{
					//x=a.size()-sortedArray.size();
					sortedArray.add(tmp);
					a.set(x++, i);
					sortedArray.remove(i);
					break;
				}
			}
			for(int i:sortedArray)
			{
				a.set(x++, i);
			}
		}
	}
	public static void nextPermutation1(ArrayList<Integer> a) {
		int x=-1,tmp=-1;
		TreeSet<Integer> sortedArray=new TreeSet<Integer>(a);
		for(int i=0;i<a.size()-1;i++)
		{
			if(a.get(i)<a.get(i+1))
			{
				x=i;tmp=a.get(i);sortedArray.remove(a.get(i));
			}			
		}
		if(x==-1)
			Collections.sort(a);
		else
		{
			for(Integer i:sortedArray)
			{
				if(i>tmp)
				{
					x=a.size()-sortedArray.size();
					sortedArray.add(tmp);
					a.set(x++, i);
					sortedArray.remove(i);
					break;
				}
			}
			for(int i:sortedArray)
			{
				a.set(x++, i);
			}
		}
	}

}
