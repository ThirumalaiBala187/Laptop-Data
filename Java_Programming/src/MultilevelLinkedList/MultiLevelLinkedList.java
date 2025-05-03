package MultilevelLinkedList;

public class MultiLevelLinkedList<T> {

	Node<T> headNode;
	
	Node<T> taiNode;
	
	private int size;
	
	public void insert(T value) {
		
		Node<T> newNode = new Node<T>(value);
		
		if(size == 0) {
			
			headNode = newNode;

			taiNode = newNode;
			
		}
		
		else {
			
			taiNode.nextNode = newNode;
			
			newNode.previousNode = taiNode;
			
			taiNode = newNode;
			
		}
		
		size++;
		
	}
	
	
	public void addChild(Node<T> parent, T data) {
		
		Node<T> newChildNode = new Node<T>(data);
		
		parent.childNode = newChildNode;
		
		size++;
		
	}
	
	
	public void flatten() {
		
		Node<T> tempNode = headNode;
		
		while (tempNode != null) {
			
			if(tempNode.childNode != null) {
				
				Node<T> child = tempNode.childNode;
				
				while(child != null && child.nextNode != null) {
					
					child = child.nextNode;
					
				}
				
				child.nextNode = tempNode.nextNode;
						
				tempNode.nextNode.previousNode = child;						
					
				tempNode.nextNode = tempNode.childNode;
				
				tempNode.childNode.previousNode = tempNode;							
					
			}
				
			tempNode = tempNode.nextNode;
			
		}
		
	}
	
	public void display() {
		
		Node<T> tempNode = headNode;
		
		while (tempNode != null) {
			
			System.out.print(tempNode.data + " <-> ");
			
			tempNode = tempNode.nextNode;
			
		}
		
		System.out.print("List end reached.");
		
	}

}
