package interviewBit.linkedlist;

class ListNode {
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }

public class IntersectionOfLinkedList {

	public static void main(String[] args) {
		ListNode a=new ListNode(2);
		a.next=new ListNode(3);
		a.next.next=new ListNode(4);
		a.next.next.next=new ListNode(5);
		
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=getIntersectionNode(a,b);
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
	
	public static ListNode getIntersectionNode(ListNode a, ListNode b) {
		int aLen=length(a);
		int bLen=length(b);
		if(aLen>bLen)
		{
			for(int i=bLen;i<aLen;i++)
				a=a.next;
		}
		else if(aLen<bLen)
		{
			for(int i=aLen;i<bLen;i++)
				b=b.next;
		}
		ListNode res=null;
		while(a!=null)
		{
		    if(a!=b)
		    	res=null;
		    else if(res==null)
		    	res=a;
		    a=a.next;
	    	b=b.next;
		}
		return res;
	}

}
