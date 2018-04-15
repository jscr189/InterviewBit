package interviewBit.arrays;

import java.util.ArrayList;
import java.util.LinkedList;

public class HotelBookingsPossible {

	public static void main(String[] args) {
		ArrayList<Integer> arrive = new ArrayList<Integer>() {
			 {
			    add(1);
			    add(2);
			    add(3);
			    add(4);
			 }
			};
			ArrayList<Integer> depart = new ArrayList<Integer>() {
				 {
				    add(10);
				    add(2);
				    add(6);
				    add(14);
				 }
				};
				int k=2;
		System.out.println("is Booking Possible?"+hotel(arrive,depart,k));
	}
	
	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		LinkedList<Room> ll=new LinkedList<Room>();
		for(int i=0;i<arrive.size();i++)
		{
			int arrivedAt=arrive.get(i),departedAt=depart.get(i);
			int c=0;
			Room toRem=null;
			for(Room r:ll)
			{
				if(r.start>departedAt||arrivedAt>r.end)
				{		
					toRem=r;
				}
				else
				{
					if(toRem==null)
						toRem=r;
					else if(toRem.end>r.end)
					{
						toRem=r;
					}
					c++;
				}
			}
			if(ll.size()<K)
			{
				ll.add(new Room(arrive.get(i),depart.get(i)));
			}
			else if(ll.size()==K)
			{
				if(c>=K)
					return false;
				ll.remove(toRem);
				ll.add(new Room(arrive.get(i),depart.get(i)));
			}
		}
		return true;
    }

}

class Room{
	int start,end;
	Room(int s,int e)
	{
		start=s;
		end=e;
	}
}
