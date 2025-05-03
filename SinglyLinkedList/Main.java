package SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(50);
        list.insertAtBeginning(40);
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        // list.print();
        list.insertAtEnd(60);
        list.print();
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
}
