package problem1;

public class Node {
	private int key, val;
	Node prev,next;
	public Node(int key,int val) {
		this.key=key;
		this.val=val;
		prev=null;
		next=null;
	}
	public Node(int key,int val,Node prev,Node next) {
		this.key=key;
		this.val=val;
		this.prev=prev;
		this.next=next;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
}
