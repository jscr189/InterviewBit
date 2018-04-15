package interviewBit.linkedlist;

public class MergeSortedList {

	public static void main(String[] args) {
		ListNode a=new ListNode(2);
		a.next=new ListNode(3);
		a.next.next=new ListNode(4);
		a.next.next.next=new ListNode(5);
		
		ListNode b=new ListNode(3);
		b.next=new ListNode(3);
		b.next.next=new ListNode(3);
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=mergeTwoLists(a,b);
		System.out.println(x.val);
	}
	
	public static ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode curr=A,prev=null;
		while(curr!=null||B!=null)
		{
			if(curr==null&&B!=null)
			{
				prev.next=B;
				break;
			}
			if(curr!=null&&B==null)
			{
				break;
			}
			if(curr.val>=B.val)
			{
				ListNode temp=B;
				B=B.next;
				temp.next=curr;
				curr=temp;
				if(prev==null)
				{
					A=curr;
				}
				else
					prev.next=temp;
			}
			prev=curr;
			curr=curr.next;
		}
		return A;
    }

}
