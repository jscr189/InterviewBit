package interviewBit.arrays;

import java.util.ArrayList;

public class RotateMatrix {

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
				    add(6);
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
			rotate(matrix);
			System.out.println(matrix);

	}
	
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		
		for(int j=0;j<=a.size()/2;j++)
		{
			for(int i=j;i<a.size()-1-j;i++)
			{
				int tmp=a.get(j).get(i);
				a.get(j).set(i, a.get(a.size()-i-1).get(j));
				a.get(a.size()-1-i).set(j, a.get(a.size()-1-j).get(a.size()-1-i));
				a.get(a.size()-1-j).set(a.size()-1-i, a.get(i).get(a.size()-1-j));
				a.get(i).set(a.size()-1-j, tmp);
			}
		}
	}

}
