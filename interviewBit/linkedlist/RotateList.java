package interviewBit.linkedlist;

public class RotateList {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=rotateRight(b,6);
		System.out.println(x.val);
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
	
	public static ListNode rotateRight(ListNode A, int B) {
		int len=length(A);
		if(B>=len)
			B=B%len;
		if(B==0||len==1)
			return A;
		ListNode curr=A,head=A;
		for(int i=0;i<len-B-1;i++)
			curr=curr.next;
		
		A=curr.next;
		curr.next=null;
		
		curr=A;
		while(curr.next!=null)
			curr=curr.next;
		curr.next=head;
		
		
		return A;
    }

}
