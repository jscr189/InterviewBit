package interviewBit.backtracking;

import java.util.ArrayList;

public class PalindromicPartitioning {
	public static ArrayList<ArrayList<String>> arr=new ArrayList<ArrayList<String>>();
	public static void main(String[] args) {
		System.out.println(partition("aabb"));
	}
	
	public static ArrayList<ArrayList<String>> partition(String a) {
		partitionRec(new StringBuilder(a),new StringBuilder(),new ArrayList<String>());
		return arr;
	}

	private static void partitionRec(StringBuilder a,StringBuilder b,ArrayList<String> al) {
		StringBuilder x=new StringBuilder(b);
		if(b.length()>0&&b.toString().equals(x.reverse().toString()))
		{
			al.add(b.toString());
			if(a.length()==0)
			{
				arr.add(al);
				return;
			}
		}
		else if(b.length()!=0)
			return;

			StringBuilder c=new StringBuilder(a);
			StringBuilder d=new StringBuilder();
			ArrayList<String> al1=new ArrayList<String>(al);
			while(c.length()>0)
			{
				d.append(c.charAt(0));
				c.deleteCharAt(0);
				partitionRec(c, d, al1);
				al1=new ArrayList<String>(al);
			}
		
	}

}
