package interviewBit.linkedlist;

public class ReverseList {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=reverseList(b);
		System.out.println(x.val);
	}
	
	public static ListNode reverseList(ListNode A) {
		ListNode prev=null,next=null;
		
		while(A!=null)
		{
			next=A.next;
			A.next=prev;
			prev=A;
			if(next!=null)
			{
				A=next;
			}
			else
				break;
		}
		return A;
    }

}
