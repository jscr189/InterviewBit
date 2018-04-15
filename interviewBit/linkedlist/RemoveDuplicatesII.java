package interviewBit.linkedlist;

public class RemoveDuplicatesII {

	public static void main(String[] args) {
		ListNode b=new ListNode(1);
		b.next=new ListNode(2);
		b.next.next=new ListNode(3);
		b.next.next.next=new ListNode(4);
		b.next.next.next.next=new ListNode(5);
		ListNode c=deleteDuplicates(b);
		System.out.println(c.val);
	}
	
	public static ListNode deleteDuplicates(ListNode A) {
		ListNode prev=null,curr=A,next=A.next;
		boolean isCurrDuplicate=false;
		while(next!=null)
		{
			if(curr.val==next.val)
			{
				isCurrDuplicate=true;
				curr.next=next.next;
			}
			else if(isCurrDuplicate)
			{
				if(prev==null)
				{
					A=curr.next;
				}
				else
					prev.next=curr.next;
				isCurrDuplicate=false;
			}
			else
				prev=curr;
				
			curr=next;
			next=curr.next;
				
		}
		
		if(prev==null&&!isCurrDuplicate)
			return curr;
		
		if(prev==null)
			return null;
		
		if(isCurrDuplicate)
			prev.next=null;
		
		return A;
    }

}
