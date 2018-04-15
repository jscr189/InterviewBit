package interviewBit.linkedlist;

public class PartitionList {

	public static void main(String[] args) {
		ListNode b=new ListNode(3);
		b.next=new ListNode(4);
		ListNode l=new ListNode(5);
		b.next.next=l;
		b.next.next.next=new ListNode(6);
		b.next.next.next.next=new ListNode(7);
		b.next.next.next.next.next=new ListNode(2);
		
		ListNode x=partition(b,3);
		System.out.println(x.val);	
	}
	
	public static ListNode partition(ListNode A, int B) {
		ListNode actualStart=null,otherStart=null,otherLast=null,head=A,prev=null,last=null;
		
		while(A.next!=null)
			A=A.next;
		last=A;
		
		A=head;
			
		
		while(A!=null)
		{
			if(A.val<B)
			{
				if(A==actualStart)
				{
					if(otherLast==null)
						head=actualStart;
					else
					{
						otherLast.next=null;
						last.next=otherStart;
						head=actualStart;
					}
					break;
				}
				ListNode tmp=A;
				A=A.next;
				tmp.next=null;
				if(A!=null)
					last.next=tmp;
				last=tmp;
				if(actualStart==null)
					actualStart=tmp;
			}
			else
			{
				if(otherStart==null)
					otherStart=A;
				else
					otherLast.next=A;
				otherLast=A;
				prev=A;
				A=A.next;
			}
		}
		if(A==null)
		{
			if(otherLast==null)
				head=actualStart;
			else
			{
				otherLast.next=null;
				last.next=otherStart;
				head=actualStart;
			}
		}
		
		return head;
    }

}
