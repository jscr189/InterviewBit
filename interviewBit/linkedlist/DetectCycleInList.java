package interviewBit.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;

public class DetectCycleInList {

	public static void main(String[] args) {
		ListNode b=new ListNode(0);
		b.next=new ListNode(1);
		ListNode l=new ListNode(2);
		b.next.next=l;
		b.next.next.next=new ListNode(3);
		b.next.next.next.next=new ListNode(4);
		b.next.next.next.next.next=new ListNode(5);
		b.next.next.next.next.next.next=l;
		
		ListNode x=detectCycle(b);
		System.out.println(x.val);	
		}
	
	public static ListNode detectCycle(ListNode a) {
		
	    ListNode temp1 = a;
	    ListNode temp2 = a;
	    ArrayList <ListNode> x = new ArrayList<ListNode>(); 
	    int flag = 0;
	    while(temp2 != null && temp2.next != null && temp2.next.next != null){
	        temp1 = temp1.next;
	        temp2 = temp2.next.next;
	        if(temp1 == temp2){flag = 1;x.add(temp2); break;}
	    }
	    
	    //System.out.printf("%d %d\n",temp1.val, flag);
	    
	    if(flag==1){
	        while(temp2.next != temp1){
	            x.add(temp2);
	            temp2 = temp2.next;
	        }
	        temp1=a;
	        while(!x.contains(temp1)){
	            temp1 = temp1.next;
	        }
	        return temp1;
	    }
	    return null;
	}
	
	public static ListNode detectCycle1(ListNode a) {
		
		ListNode next=a;
		HashSet<ListNode> hs=new HashSet<ListNode>(); 
		while(next!=null)
		{
			if(!hs.contains(next))
				hs.add(next);
			else
				return next;
			next=next.next;
		}
		
		return null;
	}

}
