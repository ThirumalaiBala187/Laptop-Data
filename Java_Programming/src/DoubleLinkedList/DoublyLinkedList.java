package DoubleLinkedList;

public class DoublyLinkedList {
	
	Node head;	
	Node tail;	
	int size;

	public void insertAtFront(int value) {
		Node node = new Node(value);
		if(head == null) {		
			head=node;			
			tail=node;			
			size++;			
			return;		
		}		
		head.prev=node;
		node.next=head;
		head=node;
		size++;
	}
	
	public void insertAtLast(int value) {		
		Node node = new Node(value);
		if(head == null) {
			tail=node;
			head=node;
			size++;
			return;
		}
		tail.next=node;
		node.prev=tail;
		tail=node;
		size++;			
	}
	
    public Node getNode(int index) {		
		Node tempNode=head;
		for(int i=0;i<index;i++) {
			tempNode=tempNode.next;
		}
		return tempNode;		
	}
	
	
	public void insertAtRandom(int value, int index) {		
		Node node=new Node(value);		
		Node targetNode = getNode(index-1);
		Node nextNode = targetNode.next;
		targetNode.next = node;
		node.prev=targetNode;
		node.next=nextNode;
		nextNode.prev=node;
		size++;		
	}
	
	void print() {
		Node temp=head;
		while(temp !=null) {
			System.out.print(temp.data + "  ");
			temp=temp.next;
		}
		System.out.println();
	}

}