package DoubleLinkedList;

public class Node<T> {
	
	T data;
	
	Node<T> previousNode;
	
	Node<T> nextNode;	

	public Node(T data) {
		
		this.data = data;
		
		this.previousNode = null;
		
		this.nextNode = null;
		
	}

}