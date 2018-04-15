package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaximumUnsortedSubArray {

	public static void main(String[] args) {
		int[] A={10, 20, 11, 4, 11, 11, 20, 10, 11, 11, 20, 14, 11, 20, 20};
		System.out.println(Arrays.toString(subUnsort(A)));
	}
	
	public static int[] subUnsort(int[] B) {
		List<Integer> A = new LinkedList<Integer>();
		for(int i:B)
			A.add(i);
        ArrayList<Integer> original = new ArrayList<Integer>(A);
        Collections.sort(A);
        int start =-1;
        int end = -1;
        for(int i=0;i<A.size();i++){
            if(A.get(i)!=original.get(i)){
               start =i;
               break;
            }
        }
        for(int i=A.size()-1;i>=0;i--){
            if(A.get(i)!=original.get(i)){
               end =i;
               break;
            }
        }
        int ret[];
        if(start!=-1 && end!=-1){
            ret=new int[2];
			ret[0]=start;ret[1]=end;
        }else
        {
        	ret=new int[1];
        	ret[0]=-1;
        }
        return ret;
    }

}
