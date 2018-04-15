package interviewBit.backtracking;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ReverseLinkedListRecursion {
	public static ListNode head;
	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		b.next.next=new ListNode(2);
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		
		ListNode x=reverseList(b);
		System.out.println(x.val);
	}
	
	public static ListNode reverseList(ListNode A) {
		head=A;
		reverseListRec(A);
		A.next=null;
		return head;
    }
	
	public static ListNode reverseListRec(ListNode A) {
		if(A.next==null)
		{
			head=A;
			return A;
		}
		reverseListRec(A.next).next=A;
		return A;
    }

}
