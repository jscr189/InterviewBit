package interviewBit.math;

public class NumToExcelColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(28));
	}
	
	public static  String convertToTitle(int a) {
	    String s="";
	    while(a>0)
	    {
	        if(a%26==0)
	        {
	            s='Z'+s;
	            a--;
	        }
	        else
	            s=(char)('A'+(a%26)-1)+s;
	        a=a/26;
	    }
	    return s;
	}

}
