package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		ArrayList<Interval> intervals=new ArrayList<Interval>(); 
		Interval in=new Interval(100,108);
		intervals.add(in);
		in=new Interval(22,43);
		intervals.add(in);
		in=new Interval(32,53);
		intervals.add(in);
		in=new Interval(5,97);
		intervals.add(in);
		in=new Interval(5,6);
		intervals.add(in);
		in=new Interval(1,10);
		intervals.add(in);
		System.out.println(merge(intervals));
	}
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		LinkedList<Integer> st=new LinkedList<Integer>();
		LinkedList<Integer> en=new LinkedList<Integer>();
		for(int i=0;i<intervals.size();i++)
		{
			Interval in=intervals.get(i);
			st.add(in.start);
			en.add(in.end);
		}
		ArrayList<Interval> finalIntervals=new ArrayList<Interval>();
		Interval newInterval=new Interval(st.getFirst(),en.getFirst());
		finalIntervals.add(newInterval);
		st.remove(st.getFirst());
		en.remove(en.getFirst());
		
		while(st.size()>0)
		{
			boolean flag=false;
			for(int i=0;i<finalIntervals.size();i++)
			{
				if(!(finalIntervals.get(i).start>en.getFirst()||finalIntervals.get(i).end<st.getFirst()))
				{
					flag=true;
					finalIntervals.get(i).start=Math.min(st.getFirst(),finalIntervals.get(i).start);
					finalIntervals.get(i).end=Math.max(en.getFirst(),finalIntervals.get(i).end);
					st.remove(st.getFirst());
					en.remove(en.getFirst());
					st.add(0, finalIntervals.get(i).start);
					en.add(0, finalIntervals.get(i).end);
					finalIntervals.remove(i);
				}
			}
			if(!flag)
			{	
				finalIntervals.add(new Interval(st.getFirst(),en.getFirst()));
				st.remove(st.getFirst());
				en.remove(en.getFirst());
			}
			
		}
		Collections.sort(finalIntervals,new MyComparator());
		return finalIntervals;
    }
}
class MyComparator implements Comparator<Interval>
{

	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.start-o2.start;
	}
	
}
