package problem1;

import java.util.HashMap;

public class CacheHandler {
	private final int capacity;
	private HashMap<Integer, Node> map;
	DoublyLinkedList list;
	public CacheHandler(int size) {
		// TODO Auto-generated constructor stub
		capacity=size;
		map=new HashMap<>();
		list=new DoublyLinkedList();
	}
	
	public int get(int key) {
		if(!map.containsKey(key)) {
			return -1;
		}
		Node temp=map.get(key);
		list.moveHead(temp);
		return temp.getVal();
	}
	
	public void put(int key,int val) {
		if(map.containsKey(key)) {
			Node temp=map.get(key);
			temp.setVal(val);
			list.moveHead(temp);
		}
		else {
			if(map.size()>=capacity) {
				Node temp=list.removeTail();
				map.remove(temp.getKey());
				System.out.println("Removed key "+temp.getKey());
			}
			Node temp=new Node(key, val);
			map.put(key, temp);
			list.addHead(temp);
			System.out.println("Added key "+temp.getKey());
		}
	}
}
