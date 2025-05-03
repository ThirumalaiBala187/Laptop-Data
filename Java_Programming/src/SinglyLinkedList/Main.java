package SinglyLinkedList;
import java.util.ArrayList;

public class Main {    
	public static void main(String[] args) {    
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.print();
        
        System.out.println(isPalindrome(list));
        
        // list.insertAtRandom(100, 3);
        // list.print();
        // list.reverse();
        // list.print();
        // list.reverse();
        // list.print();

        // System.out.println("Deleted " + list.deleteAtFirst());
        // list.print();

        // Node lastNode = list.getNode(list.size);
        // Node node = list.getNode(3);
        // lastNode.next= node;
        // list.print();        
    }	
	
	public static boolean isPalindrome(SinglyLinkedList list) {
		ArrayList<Integer> array1 = new ArrayList<>();
		Node currentNode = list.getNode(0);
		while(currentNode != null) {
			array1.add(currentNode.data);
			currentNode=currentNode.next;
		}
		for(int i=0;i<array1.size()/2;i++) {
			if(array1.get(i) != array1.get(array1.size()-i-1)) {
				return false;
			}
		}
		return true;
	}
	
}
