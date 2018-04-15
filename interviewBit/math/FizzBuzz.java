package interviewBit.math;

import java.util.ArrayList;

public class FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzz(10));

	}
	public static ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> arr=new ArrayList<String>();
        for(int i=1;i<=A;i++)
        {
            if(i%15==0)
                arr.add("FizzBuzz");
            else if(i%5==0)
                arr.add("Buzz");
            else if(i%3==0)
                arr.add("Fizz");
            else
                arr.add(""+i);
        }
        
        return arr;
    }
}
