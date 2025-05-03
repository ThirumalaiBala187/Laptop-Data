package SinglyLinkedList;

class SinglyLinkedList {
    Node head;
    Node tail;
    int size;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail=head;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node getNode(int index) {
        Node tempHead = head;
        for (int i = 1; i < index; i++) {
            if (tempHead.next == null) {
                tempHead = tempHead.next;
            }
        }
        return tempHead;
    }

    public void insertAtRandom(int val, int index) {
        if (index == 1) {
            insertAtBeginning(val);
            return;
        }
        Node node = new Node(val);
        Node previous = getNode(index - 1);
        Node temp = previous.next;
        previous.next = node;
        node.next = temp;
    }

    public void reverse() {
        Node curr = head;
        Node previous = null;
        Node next1;
        while (curr != null) {
            next1 = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next1;
        }
        head = previous;
    }


    public int deleteAtFirst(){
        if(head!=null){
            int val=head.data;
            head=head.next;
            size--;
            return val;
        }
        return -1;
    }

    public int deleteAtLast(){
        int val=tail.data;
        Node secondLast = getNode(size-1);
        tail=secondLast;
        tail.next=null;
        size--;
        return val;
    }

    public int deleteAtRandom(int index){
        Node previousNode = getNode(index);
        previousNode.next=previousNode.next.next;
        size--;
        return previousNode.next.data;
    }

    public boolean detectLoop(){

        Node slow=head;
        Node fast=head;
        do {
            slow=slow.next;
            fast=fast.next.next;
            if(fast.next == null || fast.next.next == null){
                return false;
            }
        } while (slow != fast);

        return true;

    }

    public Node startOfTheCycle(){

        Node slow=head;
        Node fast=head;
        if(slow == null){
            return null;
        }
        do {
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        } while (slow != fast);

        fast=head;
        while (slow!=fast) {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}