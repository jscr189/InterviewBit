package interviewBit.linkedlist;

public class PalindromeList {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(4);
		b.next.next=new ListNode(3);
		b.next.next.next=new ListNode(1);
		b.next.next.next.next=new ListNode(0);
		System.out.println(lPalin(b));
	}
	
	public static int length(ListNode a)
	{
		int count=0;
		while(a!=null)
		{
			count++;
			a=a.next;
		}
		return count;
	}
	
	public static int lPalin(ListNode A) {
		int x=length(A),mid=x/2;
		ListNode left=A,prev=null,next=null;
		for(int i=0;i<mid;i++)
		{
			next=A.next;
			A.next=prev;
			prev=A;
			left=A;
			A=next;
		}
		if(x%2!=0)
			A=A.next;
		while(A!=null)
		{
			if(A.val==left.val)
			{
				A=A.next;
				left=left.next;
			}
			else
				return 0;
			
		}
		return 1;
    }

}
