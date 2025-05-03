package MultilevelLinkedList;

public class Main {

	public static void main(String[] args) {
		
		MultiLevelLinkedList<Integer> list = new MultiLevelLinkedList<>();
		
		list.insert(10);
		
		list.insert(20);
		
		list.insert(30);
		
		Node<Integer> head = list.headNode;
		
		list.addChild(head,5);
		
		list.addChild(head.nextNode,15);
		
		System.out.println("Befor flattening .....");
		
		list.display();
		
		System.out.println("\nAfter flattening .....");
		
		list.flatten();
		
		list.display();
		
	}

}
