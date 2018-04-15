package interviewBit.heapsAndMaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
	Queue<Integer> queue = null;
	HashMap<Integer,Integer> hm=null;
	int capacity=0;
	public LRUCache(int capacity) {
		this.capacity=capacity;
        queue=new LinkedList<Integer>();
        hm=new HashMap<Integer,Integer>();
    }
    
    public int get(int key) {
    	int x=0;
        if(hm.containsKey(key))
        {
        	x=hm.get(key);
        	queue.remove(key);
    		queue.add(key);
        }
        else
        	x=-1;
        
        return x;
    }
    
    public void set(int key, int value) {
    	if(queue.size()<capacity)
        {
            if(queue.contains(key))
        	{
        		queue.remove(key);
        		queue.add(key);
        	}
        	else
        	    queue.add(key);
        }
        else
        {
        	if(queue.contains(key))
        	{
        		queue.remove(key);
        		queue.add(key);
        	}
        	else
        	{
        		hm.remove(queue.remove());
        		queue.add(key);
        	}
        }
        hm.put(key, value);
    }

	public static void main(String[] args) {
		LRUCache obj=new LRUCache(7);
		obj.set(2, 1);
		obj.set(1, 10);
		obj.set(8, 13);
		obj.set(2, 8);
		obj.set(14, 7);
		obj.set(12, 9);
		
		obj.set(7, 10);
		obj.set(9, 3);
		obj.set(14, 15);
		System.out.println(obj.get(9));
		obj.set(4, 13);
		System.out.println(obj.get(3));
		obj.set(13, 7);
		System.out.println(obj.get(2));
		//obj.set(6, 14);
		//System.out.println(obj.get(5));
	}

}
