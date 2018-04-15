package interviewBit.linkedlist;

public class KReverseLinkedList {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=reverseList(b,3);
		System.out.println(x.val);
	}
	
	public static ListNode reverseList(ListNode A, int B) {
		
		int i=0;
		ListNode prev=null,head=A,curr=A,next=A,first=A;
		while(i<B&&A!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			i++;
		}
		head=prev;
		first.next=curr==null?null:reverseList(curr, B);
		
		
		return head;
    }

}
