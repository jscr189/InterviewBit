package interviewBit.arrays;

import java.util.ArrayList;
import java.util.TreeSet;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
     public String toString() {
         return String.format("["+start + "," + end+"]");
     }
 }
public class MergeIntervals {

	public static void main(String[] args) {
		ArrayList<Interval> intervals=new ArrayList<Interval>(); 
		Interval in=new Interval(1,3);
		intervals.add(in);
		in=new Interval(4,6);
		intervals.add(in);
		in=new Interval(8,10);
		intervals.add(in);
		in=new Interval(15,18);
		intervals.add(in);
		System.out.println(insert(intervals, new Interval(4,9)));
	}
	
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		TreeSet<Integer> st=new TreeSet<Integer>();
		TreeSet<Integer> en=new TreeSet<Integer>();
		for(int i=0;i<intervals.size();i++)
		{
			Interval in=intervals.get(i);
			st.add(in.start);
			en.add(in.end);
		}
		ArrayList<Interval> finalIntervals=new ArrayList<Interval>();
		while(st.size()>0&&newInterval!=null)
		{
			if(en.first()<newInterval.start)
			{
				finalIntervals.add(new Interval(st.first(),en.first()));
				st.remove(st.first());
				en.remove(en.first());
			}
			else if(st.first()>newInterval.end)
			{
				finalIntervals.add(new Interval(newInterval.start,newInterval.end));
				newInterval=null;
			}
			else
			{
				//finalIntervals.add(new Interval(Math.min(st.first(),newInterval.start),Math.max(en.first(),newInterval.end)));
				newInterval=new Interval(Math.min(st.first(),newInterval.start),Math.max(en.first(),newInterval.end));
				st.remove(st.first());
				en.remove(en.first());
			}
		}
		if(newInterval!=null)
			finalIntervals.add(new Interval(newInterval.start,newInterval.end));
		while(st.size()>0)
		{
			finalIntervals.add(new Interval(st.first(),en.first()));
			st.remove(st.first());
			en.remove(en.first());
		}
		
		return finalIntervals;
    }

}
