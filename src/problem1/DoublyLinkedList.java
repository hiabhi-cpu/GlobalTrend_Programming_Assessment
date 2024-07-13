package problem1;


public class DoublyLinkedList {
	Node head,tail;
	
	public DoublyLinkedList() {
		head=new Node(0, 0);
		tail=new Node(0, 0);
		head.next=tail;
		tail.prev=head;
	}
	
	public void addHead(Node temp) {
		temp.next=head.next;
		temp.prev=head;
		head.next.prev=temp;
		head.next=temp;
	}
	
	public void moveHead(Node temp) {
		removeNode(temp);
		addHead(temp);
	}
	
	public Node removeTail() {
		Node res=tail.prev;
		removeNode(res);
		return res;
	}
	
	public void removeNode(Node temp) {
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;
	}
	
	public void printList() {
		Node tempNode=head;
		while(tempNode!=null) {
			System.out.print(tempNode.getVal()+"  ");
			tempNode=tempNode.next;
		}
		System.out.println();
	}
	
}
