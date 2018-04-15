package interviewBit.linkedlist;

public class RemoveNthNode {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=removeNthFromEnd(b,7);
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
	
	public static ListNode removeNthFromEnd(ListNode A, int B) {
		int len=length(A);
		int indexToRemove=len-B;
		if(indexToRemove<=0)
			A=A.next;
		else
		{
			ListNode prev=A;
			for(int i=0;i<indexToRemove-1;i++)
				prev=prev.next;
			prev.next=prev.next.next;				
		}
		
		return A;
    }

}
