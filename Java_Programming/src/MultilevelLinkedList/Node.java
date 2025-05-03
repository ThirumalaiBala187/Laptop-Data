package MultilevelLinkedList;

public class Node<T> {
	
	T data;
	
	Node<T> nextNode;
	
	Node<T> previousNode;
	
	Node<T> childNode;

	public Node(T data) {
		
		this.data = data;
		
		this.nextNode = null;
		
		this.previousNode = null;
		
		this.childNode = null;		
		
	}

}
