package interviewBit.linkedlist;

public class ReOrderList {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
//		b.next.next.next=new ListNode(3);
//		b.next.next.next.next=new ListNode(4);
//		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=reorderList(b);
		System.out.println(x.val);
	}
	
	public static ListNode reorderList(ListNode head) 
	{
	    ListNode v=head;
        int n=1;
        while(v.next!=null){v=v.next;n++;}
        ListNode curr=head,prev=null;
        for(int i=0;i<n/2;i++)
        {
            prev=curr;curr=curr.next;
        }
        if(n==1)return head;
        prev.next=null;
        
        curr=reverse(curr);
        //return curr;
        prev=head;
        while(prev!=null||curr!=null)
        {
            /*if(prev==null)
            {
                prev.next=curr;
                curr=null;prev=null;
            }
            else*/
            {  //ListNode
                v=curr.next;
                curr.next=prev.next;
                prev.next=curr;
                curr=v;
                if(prev.next.next==null&&curr!=null)prev=prev.next;
                else
                prev=prev.next.next;
            }
        }
        return head;
	}
	static ListNode reverse(ListNode root)
    {
        ListNode prev=null,next=null;
	    while(root!=null)
	    {
	        next=root.next;
	        root.next=prev;
	        prev=root;
	        root=next;
	    }
	    return prev;
    }
	
	public static ListNode reorderList1(ListNode A) {
		if(A==null||A.next==null)
			return A;
		ListNode head=A,curr1=A,curr=A,next=A,prev=null;
		
		while(curr1.next.next!=null)
		{
			curr=curr1.next;
			while(curr.next!=null)
			{
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			curr.next=prev;
			curr1.next=curr;
			curr1=curr;
			prev=null;
		}
		
		return head;
	}
	
	public static ListNode reorderList2(ListNode A) {
		if(A==null||A.next==null)
			return A;
		ListNode head=A,curr=A,last=A;
		
		while(curr!=null)
		{
			last=curr;
			while(last.next!=null&&last.next.next!=null)
				last=last.next;
			
			if(curr==last)
				break;
			
			ListNode tmp=curr.next;
			last.next.next=tmp;
			curr.next=last.next;
			last.next=null;
			curr=tmp;			
		}
		
		return head;
	}

}
