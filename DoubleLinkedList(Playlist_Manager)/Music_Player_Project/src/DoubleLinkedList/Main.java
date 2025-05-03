package DoubleLinkedList;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
//		DoubleLinkedList<Object> list1 = new DoubleLinkedList<Object>();
		
//		ArrayList<Integer> arr = new ArrayList<>();
		
//		arr.add(1);
//		arr.add(2);
//		arr.add(8);
//		arr.add(9);
//		System.out.println(arr);
//		
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(5);
		list.add(6);
		
		list.addLast(71);
		list.addFirst(18);
//		list.addAtIndex(1,14);
//		list.printList();
//		System.out.println(list.lastIndexOf(5));
//		System.out.println(list.indexOf(5));
//		
//		System.out.println(list.offer(6783));
//		list.printList();
		
		list.push(88);
//		list.printList();
//		System.out.println(list.pop());
//		list.printList();
//		System.out.println(list.remove());
//		list.printList();
		
//		System.out.println(list.removeFirst());
//		list.printList();
		
//		System.out.println(list.removeLast());
//		list.printList();
		
		
//		System.out.println(list.set(1,187));
		list.printList();
		
//		System.out.println((list.toArray()).toString());
//		System.out.println(Arrays.toString(list.toArray()));
//		System.out.println((list.toArray(new Integer[10])).toString());
//		System.out.println(Arrays.toString(list.toArray(new Integer[12])));
		
		
		list.remove(5);
		list.printList();
		
		Iterator<Integer> desc = list.descendingIterator();
		
		System.out.println("Descending iterator : ");
		
		while (desc.hasNext()) {
			System.out.print(desc.next() + "  ");
			
		}
		
		Iterator<Integer> listIterator = list.listIterator();
		
		System.out.println("List iterator : ");
		
		while (listIterator.hasNext()) {
			
			System.out.println(listIterator.next());
			
		}
		
		
//		list1.add(1);
//		list1.add(2);
//		list1.add(8);
//		list1.add(9);
//		list1.printList();
		
//		list.removeFirst();
//		list.printList();
//		
//		list.removeLast();
//		list.printList();
//		
//		list.removeAtIndex(3);
//		list.printList();
//		
//		list.reverse();
//		list.printList();
		
//		list.addAll(list1);
//		list.addAll(arr);
		
//		DoubleLinkedList<Integer> newClone = list.cloneList();
//		System.out.println(newClone.indexOf(3));
//		newClone.printList();
		
//		list.printList();
		
//		System.out.println("Prabhu");
	}

}
