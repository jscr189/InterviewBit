package interviewBit.binarySearch;

public class SquareRootOfInteger {

	public static void main(String[] args) {
		System.out.println(sqrt(673707547));
	}
	
	public static int sqrt(int a)
	{
		if(a<=0)
			return 0;
		if(a==1)
			return 1;
		int x=((""+a).length()/2)-((""+a).length()%2==0?1:0);
		int l=0,r=a,p=0;
		if(x>=1)
		{
			l=1;
			while(x>0)
			{
				l*=10;
				x--;
			}
			r=l*10;
		}
		
		while(l<=r)
		{
			int m=(l+r)/2;
			if((m*m<0&&m==a/m)||(m*m>0&&m*m==a))
			{
				return m;
			}
			else if((m*m<0&&m<a/m)||(m*m>0&&m*m<a))
			{
				l=m+1;
				p=m;
			}
			else if((m*m<0&&m>a/m)||(m*m>0&&m*m>a))
				r=m-1;
		}
		return p;
	}
	
	public static int sqrt1(int a)
	{
		if(a<=0)
			return 0;
		if(a==1)
			return 1;
		int l=0,r=a,p=0;
		
		while(l<=r)
		{
			int m=(l+r)/2;
			if((m*m<0&&m==a/m)||(m*m>0&&m*m==a))
			{
				return m;
			}
			else if((m*m<0&&m<a/m)||(m*m>0&&m*m<a))
			{
				l=m+1;
				p=m;
			}
			else if((m*m<0&&m>a/m)||(m*m>0&&m*m>a))
				r=m-1;
		}
		return p;
	}

}
