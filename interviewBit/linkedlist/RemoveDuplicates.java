package interviewBit.linkedlist;

public class RemoveDuplicates {

	public static void main(String[] args) {
		ListNode b=new ListNode(1);
		b.next=new ListNode(1);
		b.next.next=new ListNode(1);
		b.next.next.next=new ListNode(1);
		b.next.next.next.next=new ListNode(3);
		ListNode c=deleteDuplicates(b);
		System.out.println(c.val);
	}
	
	public static ListNode deleteDuplicates(ListNode A) {
		
		ListNode curr=A,next=A.next;
		while(next!=null)
		{
			if(curr.val==next.val)
				curr.next=next.next;
			else
				curr=next;
			next=curr.next;
		}
		
		return A;
    }

}
