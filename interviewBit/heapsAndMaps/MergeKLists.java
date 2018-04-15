package interviewBit.heapsAndMaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class MergeKLists {

	public static void main(String[] args) {
		ArrayList<ListNode> a=new ArrayList<ListNode>();
		ListNode head=new ListNode(1);
		head.next=new ListNode(10);
		head.next.next=new ListNode(20);
		a.add(head);
		ListNode head1=new ListNode(4);
		head1.next=new ListNode(11);
		head1.next.next=new ListNode(13);
		a.add(head1);
		ListNode head2=new ListNode(3);
		head2.next=new ListNode(8);
		head2.next.next=new ListNode(9);
		a.add(head2);
		System.out.println(mergeKLists(a));
	}
	
	public static ListNode mergeKLists(ArrayList<ListNode> a) {
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		for(int i=0;i<a.size();i++)
		{
			ListNode head=a.get(i);
			while(head!=null)
			{
				pq.add(head.val);
				head=head.next;
			}
		}
		ListNode head=null,curr=null;
		while(pq.size()>0)
		{
			ListNode newNode=new ListNode(pq.poll());
			if(head==null)
				head=newNode;
			else
				curr.next=newNode;
			curr=newNode;
		}
		return head;
	}

}
