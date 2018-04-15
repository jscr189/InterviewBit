package interviewBit.linkedlist;

public class SwapPair {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
//		b.next.next.next=new ListNode(3);
//		b.next.next.next.next=new ListNode(4);
//		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=swapPairs(b);
		System.out.println(x.val);
	}
	
	public static ListNode swapPairs(ListNode A) {
		if(A==null||A.next==null)
			return A;
		
		ListNode first=null,prevLast=null,prev=null,curr=A,next=A,head=A;
		int i=0;
		while(curr!=null&&curr.next!=null)
		{
			do{
				if(i%2==0)
				{
					prevLast=first;
					first=curr;
				}
				next=curr.next;
				curr.next=prev;
				prev=curr;
				if(i==1)
					head=prev;
				curr=next;
				if(prevLast!=null&&i%2==1)
					prevLast.next=prev;
				i++;
			}while(i%2!=0);
		}
		first.next=curr;
		
		return head;
    }
	
	public static ListNode swapPairs1(ListNode A) {
		if(A==null||A.next==null)
			return A;
		
		ListNode first=A,prev=null,curr=A,next=A,head=A;
		int i=0;
		while(i<2&&A!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			i++;
		}
		head=prev;
		first.next=curr==null?null:swapPairs(curr);
		
		return head;
    }

}
