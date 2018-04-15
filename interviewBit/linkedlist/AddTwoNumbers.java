package interviewBit.linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode a=new ListNode(2);
		a.next=new ListNode(7);
		a.next.next=new ListNode(8);
		ListNode b=new ListNode(9);
		b.next=new ListNode(6);
		ListNode x=addTwoNumbers(a,b);
		System.out.println(x.val);	
	}
	
	public static ListNode addTwoNumbers(ListNode A, ListNode B) {
		ListNode head=A,prev=A;
		int carry=0;
		while(A!=null||B!=null)
		{
			if(A==null&&B!=null)
			{
				ListNode n=new ListNode(0);
				prev.next=n;
				A=n;
			}
			int sum=A.val+(B==null?0:B.val)+carry;
			if(sum>9)
			{
				A.val=sum%10;
				carry=sum/10;
			}
			else
			{
				A.val=sum;
				carry=0;
			}
			if(A!=null)
				prev=A;
			A=A.next;
			B=B==null?null:B.next;
		}
		if(carry>0)
		{
			ListNode n=new ListNode(carry);
			prev.next=n;
		}
		return head;
    }

}
