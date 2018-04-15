package interviewBit.linkedlist;

public class InsertionSort {

	public static void main(String[] args) {
		ListNode b=new ListNode(3);
		b.next=new ListNode(4);
		ListNode l=new ListNode(5);
		b.next.next=l;
		b.next.next.next=new ListNode(6);
		b.next.next.next.next=new ListNode(7);
		b.next.next.next.next.next=new ListNode(2);
		
		ListNode x=insertionSortList(b);
		System.out.println(x.val);
	}
	
	public static ListNode insertionSortList(ListNode A) {
		if(A==null||A.next==null)
			return A;
		ListNode head=A;
		while(A.next!=null)
		{
			ListNode i=A,j=A.next;
			while(j!=null)
			{
				if(i.val>j.val)
				{
					int tmp=i.val;
					i.val=j.val;
					j.val=tmp;
				}
				j=j.next;
			}
			A=A.next;
		}
		
		
		return head;
    }

}
