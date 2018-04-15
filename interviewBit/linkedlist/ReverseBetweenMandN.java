package interviewBit.linkedlist;

public class ReverseBetweenMandN {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=reverseBetween(b,2,6);
		System.out.println(x.val);
	}
	
	public static ListNode reverseBetween(ListNode A, int B, int C) {
		if(B==C)
			return A;
		ListNode mnode=null,prev=null,curr=A,nnode=null,head=A,next=A,start=null;
		int i=0;
		for(i=0;i<B-1;i++)
		{
			start=curr;
			curr=curr.next;
		}
		next=curr;
		for(int j=B;j<=C;j++)
		{
			if(j==B)
				mnode=curr;
			else if(j==C)
				nnode=curr;
			next=next.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		
		if(start!=null)
		{
			mnode.next=next;
			start.next=nnode;
		}
		else
		{
			mnode.next=next;
			head=nnode;
		}
		
		return head;
    }

}
