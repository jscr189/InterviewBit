package interviewBit.arrays;

import java.util.ArrayList;
import java.util.TreeSet;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>() {
			 {
			    add(1);
			    add(2);
			    add(3);
			    add(4);
			 }
			};
			matrix.add(row);
			row = new ArrayList<Integer>() {
				 {
				    add(5);
				    add(0);
				    add(7);
				    add(8);
				 }
				};
			matrix.add(row);
			row = new ArrayList<Integer>() {
					 {
					    add(9);
					    add(10);
					    add(11);
					    add(12);
					 }
			};
			matrix.add(row);
			row = new ArrayList<Integer>() {
				 {
				    add(13);
				    add(14);
				    add(15);
				    add(16);
				 }
		};
		matrix.add(row);
		setZeroes(matrix);
		System.out.println(matrix);

	}
	
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		TreeSet<Integer> rows=new TreeSet<Integer>();
		TreeSet<Integer> cols=new TreeSet<Integer>();
		for(int i=0;i<a.size();i++)
		{
			for(int j=0;j<a.get(i).size();j++)
			{
				if(a.get(i).get(j)==0)
				{
					rows.add(i);
					cols.add(j);
				}
			}
		}
		while(rows.size()>0)
		{
			int r=rows.first();
			for(int i=0;i<a.get(r).size();i++)
				a.get(r).set(i, 0);
			rows.remove(r);
		}
		while(cols.size()>0)
		{
			int c=cols.first();
			for(int i=0;i<a.size();i++)
				a.get(i).set(c, 0);
			cols.remove(c);
		}
	}

}
