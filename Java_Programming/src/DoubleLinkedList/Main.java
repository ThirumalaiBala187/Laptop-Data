package DoubleLinkedList;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList doublyList = new DoublyLinkedList();
		
//		System.out.print("Inserting at random : ");
//		doublyList.insertAtFront(10);
//		doublyList.insertAtFront(20);
//		doublyList.insertAtFront(30);
//		doublyList.insertAtFront(40);
//		doublyList.insertAtFront(50);	
//		doublyList.print();
		
//		System.out.print("Inserting at End : ");
//		doublyList.insertAtLast(10);
//		doublyList.insertAtLast(20);
//		doublyList.insertAtLast(30);
//		doublyList.insertAtLast(40);
//		doublyList.insertAtLast(50);
//		doublyList.insertAtLast(60);
//		doublyList.print();
		
		System.out.print("Inserting at random : ");
		doublyList.insertAtLast(10);
		doublyList.insertAtLast(20);
		doublyList.insertAtLast(30);
		doublyList.insertAtLast(40);
		doublyList.insertAtLast(50);
		doublyList.insertAtLast(60);
		doublyList.insertAtRandom(80,2);
		doublyList.print();
	}

}