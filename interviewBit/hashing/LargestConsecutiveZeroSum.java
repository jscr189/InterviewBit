package interviewBit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestConsecutiveZeroSum {

	public static void main(String[] args) {
		int a[]={1 ,-1 ,5 ,1 ,-4,3};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i:a)
			A.add(i);
		System.out.println(lszero(A));
	}
	
	public static ArrayList<Integer> lszero(ArrayList<Integer> a) {
        int start = 0, end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            if(map.containsKey(sum)) {
                int currStart = map.get(sum),
                    currEnd = i;
                if(currEnd - currStart + 1 > end - start + 1) {
                    start = currStart;
                    end = currEnd;
                }
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        //System.out.println(map);
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = start + 1; i <= end; i++) {
            result.add(a.get(i));
        }
        return result;
	}
	
	public static ArrayList<Integer> lszero1(ArrayList<Integer> A) {
		int k=A.size();
		for(int i=A.size();i>1;i--)
		{
			for(int j=0;j<A.size()-i+1;j++)
			{
				if(isZeroSum(A,j,i))
				{
					ArrayList<Integer> B= new ArrayList<Integer>();
					while(i>0)
					{
						B.add(A.get(j++));
						i--;
					}
					return B;
				}
			}			
		}
		return new ArrayList<Integer>();
	}

	private static boolean isZeroSum(ArrayList<Integer> b,int start,int size) {
		int sum=0;
		while(size>0)
		{
			sum+=b.get(start++);
			size--;
		}
		return (sum==0);
	}

}
