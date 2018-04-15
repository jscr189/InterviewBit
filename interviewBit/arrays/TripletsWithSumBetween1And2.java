package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSumBetween1And2 {

	public static void main(String[] args) {
		String[] A={"0.366507", "0.234601", "2.126313", "1.372403", "2.022170", "0.308558", "2.120754", "1.561462" };
		System.out.println(solve(A));
	}
	
	public static int solve(String[] A) {
		List<String> array= Arrays.asList(A);
		if(array.size() < 3) return 0;

        double a = Double.parseDouble(array.get(0)); 
        double b = Double.parseDouble(array.get(1)); 
        double c = Double.parseDouble(array.get(2)); 

         
        for(int i = 3; i < array.size(); i++){
                
   if((a+b+c) > 1 && (a+b+c) < 2){
                return 1;
            }

	   
            double n = Double.parseDouble(array.get(i));
            
            
           if((a+b+c) >= 2){
                if(a > b && a > c){
                    a = n;
                } else if( b > c){
                    b = n;
                } else{
                    c = n;
                }
            } else{
                if(a < b && a < c){
                    a = n;
                } else if( b < c){
                    b = n;
                } else{
                    c = n;
                }
            }
        }
        
        if((a+b+c) > 1 && (a+b+c) < 2){
            return 1;
        }
       
        return 0;
    }

}
