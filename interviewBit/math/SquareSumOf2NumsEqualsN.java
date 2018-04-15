package interviewBit.math;

import java.util.ArrayList;

public class SquareSumOf2NumsEqualsN {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> al = squareSum(13);
		System.out.println(al);
	}
	
	public static ArrayList<ArrayList<Integer>> squareSum(int A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int a = 0; a * a < A; a++) {
			for (int b = 0; b * b < A; b++) {
				if (a<=b && a * a + b * b == A) {
					ArrayList<Integer> newEntry = new ArrayList<Integer>();
					newEntry.add(a);
					newEntry.add(b);
					ans.add(newEntry);
				}
			}
		}
		return ans;
	}

}
