package interviewBit.linkedlist;

public class SortList {

	public static void main(String[] args) {
		ListNode b=new ListNode(3);
		b.next=new ListNode(4);
		ListNode l=new ListNode(5);
		b.next.next=l;
		b.next.next.next=new ListNode(6);
		b.next.next.next.next=new ListNode(7);
		b.next.next.next.next.next=new ListNode(2);
		
		ListNode x=sortList(b);
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
	
	public static ListNode sortList(ListNode A) {
		ListNode z=A;
		int len=length(A);
		if(len==1)
			return A;
		
		int mid=len/2;
		ListNode B=A;
		for(int i=0;i<mid-1;i++)
			A=A.next;
		ListNode C=A.next;
		A.next=null;
		z= mergeTwoLists(sortList(B),sortList(C));
		return z;
	}

}
