package DoubleLinkedList;

import java.util.ArrayList;

import java.util.Collection;

import java.util.Iterator;

import java.util.NoSuchElementException;

import Exceptions.*;

public class DoubleLinkedList<T> {
	
	Node<T> headNode;
	
	Node<T> tailNode;
	
	int size;	

	public DoubleLinkedList() {	
				
	}
	
	
	
	// To print all the elements (Nodes) of the list.
	
	// Return type - void.
	
	// Method modifier - Non-static.
	
	public void printList() {
		
		Node<T> tempNode = headNode;
		
		while (tempNode != null) {
			
			System.out.print(tempNode.data + "  ");
			
			tempNode = tempNode.nextNode;
			
		}
		
		System.out.println();
		
	}
	
	
	
	// Inserting an element at first (head node).
	
	// Return type - void.
		
	// Method modifier - Non-static.
		
	
	public void addFirst(T value) {
			
		Node<T> newNode = new Node<T>(value);
			
		if(headNode == null) {
				
			headNode = newNode;
				
			tailNode = newNode;
				
			size++;
				
			return;
				
		}
			
		headNode.previousNode = newNode;
			
		newNode.nextNode = headNode;
			
		headNode = newNode;
			
		size++;
			
	}
		
		
	// Inserting an element at last (tail node).
		
	// Return type - void.
		
	// Method modifier - Non-static.
				
	
	public void addLast(T value) {
			
		Node<T> newNode = new Node<T>(value);
			
		if(headNode == null) {
				
			headNode = newNode;
				
			tailNode = newNode;
				
			size++;
				
			return;
				
		}
			
		tailNode.nextNode = newNode;
			
		newNode.previousNode = tailNode;
			
		tailNode = newNode;
			
		size++;
			
	}
		
		
		
	// Inserting an element at specified index.
		
	// Return type - void.
		
	// Method modifier - Non-static.
		
	public void addAtIndex(int index, T value) throws IndexOutOfRangeException {
			
		if(index > size || index < 0) {
				
			throw new IndexOutOfRangeException("Index greater than list size.");
				
		}
			
		Node<T> newNode = new Node<T>(value);
			
		if(index == 0) {
				
			if(size == 0) {
					
				headNode = null;
					
				tailNode = null;
					
			}
				
			else {
					
				newNode.nextNode = headNode;
					
				headNode.previousNode = newNode;
					
				headNode = newNode;
					
			}
				
		}
			
		else if(index == size) {
				
			newNode.previousNode = tailNode;
				
			tailNode.nextNode = newNode;
				
			tailNode = newNode;
				
		}
			
		else {
			
			Node<T> targetNode = new Node<T>(getAtIndex(index-1));
				
			Node<T> targetNextNode = targetNode.nextNode;
				
			targetNode.nextNode = newNode;
				
			newNode.previousNode = targetNode;
				
			newNode.nextNode = targetNextNode;
				
			targetNextNode.previousNode = newNode;
			
		}
			
		size++;
			
	}
		
		
		
	// Adding an element (It is just adding at last).
		
	// Return type - void.
		
	// Method modifier - Non-static.
		
	public void add(T value) {
			
		addLast(value);
						
	}
	
	
	
	// Adding all the elements of the given collection(Object) to another collection.
	
	// Return type - void.
	
	// Method modifier - Non-static.
	
	public void addAll(Collection<T> collection) {
		
		if(collection == null || collection.isEmpty()) {
			
			return;
			
		}
		
		for(T value : collection) {
			
			Node<T> newNode = new Node<T>(value);
			
			if(size == 0) {
				
				headNode = newNode;
				
				tailNode = newNode;
				
			}
			
			else {
				
				tailNode.nextNode = newNode;
				
				newNode.previousNode = tailNode;
				
				tailNode = newNode;
				
			}
			
			size++;
			
		}
		
	}
	
	
	
	// Adding all the elements of the given list to the existing linked list.
	
	// Return type - void.
	
	// Method modifier - Non-static.
	
	public void addAll(DoubleLinkedList<T> list) {
		
		if(list == null || list.size == 0 || list.isEmpty()) {
			
			return;
			
		}
		
		Node<T> tempNode = list.headNode;
		
		while(tempNode != null) {
			
			if(size == 0) {
				
				headNode = tempNode;
				
				tailNode = tempNode;
				
			}
			
			else {
				
				tailNode.nextNode = tempNode;
				
				tempNode.previousNode = tailNode;
				
				tailNode = tempNode;
				
			}
			
			tempNode = tempNode.nextNode;
			
			size++;
			
		}
		
	}
	
	
	
	
	// Adding all the elements of the given collection (Object) to another collection at a specified index.
	
	// Return type - void.
	
	// Method modifier - Non-static.
	
	public void allAllAtIndex(int index, Collection<T> collection) throws IndexOutOfRangeException {
		
		if(index < 0 || index > size) {
			
			throw new IndexOutOfRangeException("Index greater than the list size.");
			
		}
		
		if(collection == null || collection.isEmpty()) {
			
			return;
			
		}
		
		for(T value : collection) {
			
			Node<T> newNode = new Node<T>(value);
			
			if(size == 0) {
				
				headNode = newNode;
				
				tailNode = newNode;
				
			}
			
			else {
				
				tailNode.nextNode = newNode;
				
				newNode.previousNode = tailNode;
				
				tailNode = newNode;
				
			}
			
			size++;
			
		}
		
	}
	
	
	
	// Adding all the elements of the double linked list to the existing linked list at a specified index.
	
	// Return type - void.
	
	// Method modifier -Non-static.
	
	public void addAllAtIndex(int index, DoubleLinkedList<T> list) {
		
		if(list == null || list.size == 0 || list.isEmpty()) {
			
			return;
			
		}
		
		Node<T> tempNode = list.headNode;
		
		while(tempNode != null) {
			
			if(size == 0) {
				
				headNode = tempNode;
				
				tailNode = tempNode;
				
			}
			
			else {
				
				tailNode.nextNode = tempNode;
				
				tempNode.previousNode = tailNode;
				
				tailNode = tempNode;
				
			}
			
			tempNode = tempNode.nextNode;
			
			size++;
			
		}
		
	}
	
	
	
	// Getting the first node (head node).	
	
	// Return type - T (Node data).	
	
	// Method modifier - Non-static.
	
	public T getFirst() throws ElementNotFoundException{
		
		if(headNode == null) {
			
			throw new ElementNotFoundException("Empty List : Cannot retrieve any data");
			
		}
		
		return headNode.data;
		
	}
	
	
	
	// Getting the last node (tail node).
	
	// Return type - T (Node data).	
	
	// Method modifier - Non-static.		
	
	public T getLast() throws ElementNotFoundException{
		
		if(tailNode == null) {
			
			throw new ElementNotFoundException("Empty List : Cannot retrieve any data");
			
		}
		
		return tailNode.data;
		
	}
	
	
	
	// Getting the node at specified index.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T getAtIndex(int index) throws IndexOutOfRangeException{
		
		if(index < 0 || index >= size) {
			
			throw new IndexOutOfRangeException();
			
		}
		
		Node<T> tempNode = headNode;
		
		for(int i=0;i<index;i++) {
			
			tempNode = tempNode.nextNode;
			
		}
		
		return tempNode.data;
		
	}
	
	
	
		// Getting the node at specified index.
	
		// Return type - T (Node data).
		
		// Method modifier - Non-static.
		
		public Node<T> getNode(int index) throws IndexOutOfRangeException{
			
			if(index < 0 || index >= size) {
				
				throw new IndexOutOfRangeException();
				
			}
			
			Node<T> tempNode = headNode;
			
			for(int i=0;i<index;i++) {
				
				tempNode = tempNode.nextNode;
				
			}
			
			return tempNode;
			
		}
	
	
	
	// Retrieves and removes the first element (head) of the list.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T remove() throws ElementNotFoundException{
		
		if(headNode == null) {
			
			throw new ElementNotFoundException("Empty List : Cannnot retrieve any data.");
			
		}
		
		Node<T> tempNode = headNode;
		
		headNode = headNode.nextNode;
		
		if(headNode != null) {
			
			headNode.previousNode = null;
			
		}
		
		else {
			
			tailNode = null;
			
		}
		
		size--;
		
		return tempNode.data;
		
	}
	
	
	
	// Remove an element at a specific index.
	
	// Return type - void.
	
	// Method modifier - Non-static.
	
	public void remove(int index) throws IndexOutOfRangeException {
		
		if(index < 0 || index > size) {
			
			throw new IndexOutOfRangeException();
			
		}
		
		if(index == 0) {
			
			if (size == 1) {
				
				headNode = null;
				
				tailNode = null;
				
			}
			
			else {
				
				headNode = headNode.nextNode;
				
				headNode.previousNode = null;
				
			}
			
		}
		
		else if(index == size-1) {
			
			tailNode = tailNode.previousNode;
			
			tailNode.nextNode = null;
			
		}
		
		else {
			
			
			Node<T> targetNode = getNode(index);
			
			Node<T> currentNode = targetNode.nextNode;
			
			targetNode.nextNode = currentNode.nextNode;
			
			currentNode.nextNode.previousNode = targetNode;
			
		}
		
		size--;
		
	}
	
	
	
	// Removes the element that matches with the given data of data type Object. 
	
	// Return type - boolean.
	
	// Method modifier - Non-static.
	
	public boolean remove(Object o) {
		
		if(headNode == null || o == null) {
			
			return false;
			
		}
		
		Node<T> tempNode = headNode;
		
		while(tempNode != null) {
			
			if(o.equals(tempNode.data) || o == tempNode.data) {
				
				if(tempNode == headNode) {
					
					headNode = headNode.nextNode;
					
					if(headNode != null) {
					
						headNode.previousNode = null;
					
					}
					
				}
				
				else if(tempNode == tailNode) {
					
					tailNode = tailNode.previousNode;
					
					if(tailNode != null) {
						
						tailNode.nextNode = null;
					}
					
				}
				
				else {
					
					tempNode.previousNode.nextNode = tempNode.nextNode;
					
					tempNode.nextNode.previousNode = tempNode.previousNode;
												
				}
				
				size--;
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	
	// Removing the first element (head node).
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T removeFirst() throws ElementNotFoundException{
		
		if(headNode == null) {
			
			throw new ElementNotFoundException("Empty List : Cannot retrieve any data");
			
		}
		
		Node<T> tempNode = headNode;
		
		headNode = headNode.nextNode; 
		
		if(headNode != null) {
			
			headNode.previousNode = null;
			
		}
		
		size--;
		
		return tempNode.data;
		
	}
	
	
	
	// Removing the last element (tail node).
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T removeLast() throws ElementNotFoundException{
		
		if(headNode == null) {
			
			throw new ElementNotFoundException("Empty List : Cannot retrieve any data");
			
		}
		
		Node<T> tempNode = tailNode;
		
		tailNode = tailNode.previousNode;
		
		if(tailNode != null) {
			
			tailNode.nextNode = null;
			
		}
		
		size--;
		
		return tempNode.data;
		
	}
	
	
	
	// Removing the first occurrence of the element that matches with the given data (Object).
	
	// Return type - boolean.
	
	// Method modifier - Non-static.
	
	public boolean removeFirstOccurrence(Object o) {
		
		return remove(o);
		
	}
	
	
	
	// Removing the last occurrence of the element that matches with the given data (Object).
	
	// Return type - boolean.
	
	// Method modifier - Non-static.
	
	public boolean removeLastOccurrence(Object o) {
		
		if(headNode == null || o == null) {
			
			return false;
			
		}
		
		Node<T> tempNode = tailNode;
		
		while(tempNode != null) {
			
			if(tempNode.data == o || tempNode.data.equals(o)) {
				
				if(tempNode == headNode) {
					
					headNode = headNode.nextNode;
					
					if(headNode != null) {
						
						headNode.previousNode = null;
						
					}
					
				}
				
				else if(tempNode == tailNode) {
					
					tailNode = tailNode.previousNode;
					
					if(tempNode == tailNode) {
						
						tailNode = tailNode.previousNode;
						
						if(tailNode != null) {
							
							tailNode.nextNode = null;
							
						}
						
					}
					
				}
				
				else {
					
					tempNode.previousNode.nextNode = tempNode.nextNode;
					
					tempNode.nextNode.previousNode = tempNode.previousNode;
					
				}
				
				size--;
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	
	
	// Getting the size of the List.
	
	// Return type - Integer (int).
	
	// Method modifier - Non-static.
	
	public int size() {
		
		return size;
		
	}
	
	
	
	// Checking whether the given list is  empty or not.
	
	// Return type - boolean.
	
	// Method modifier - Non-static.
	
	public boolean isEmpty() {
		
		if(size == 0) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	
	// Checking whether the list contains a specific value or not.
	
	// Return type - boolean.
	
	// Method-modifier - Non-static.
	
	public boolean contains(T value) {
		
		Node<T> tempNode = headNode;
		
		while(tempNode != null) {
			
			if((tempNode.data == value && tempNode != null) || (tempNode != null && tempNode.data.equals(value))) {
				 
				return true;
				
			}
			
			tempNode = tempNode.nextNode;
			
		}
		
		return false;
		
	}
	
	
	// Removes all elements (Nodes) form the list.
	
	// Return type - void.
	
	// Method modifier - Non-static.
	
	public void clear() {
		
		headNode = null;
		
		tailNode = null;
		
	}
	
	
	// Retrieving the index value of the given element (data) form the list.
	
	// Return type - int.
	
	// Method modifier - Non-static.
	
	public int indexOf(T data) {
		
		Node<T> tempNode = headNode;
		
		int index = 0;		
		
		while(tempNode != null) {
			
			if((tempNode != null && tempNode.data == data) || (tempNode != null && tempNode.data.equals(data))) {
				
				return index;
				
			}
			
			tempNode = tempNode.nextNode;
			
			index++;
			
		}
		
		return -1;
		
	}
	
	
	
	// Retrieving the index value of last occurence of the given element (data) from the list.
	
	// Return type - int.
	
	// Method modifier - Non-static.
	
	public int lastIndexOf(T data) {
		
		Node<T> tempNode = tailNode;
		
		int index = size-1;
		
		while(tempNode != null) {
			
			if((tempNode != null && tempNode.data == data) || tempNode != null && tempNode.data.equals(data)) {
				
				return index;
				
			}
			
			tempNode = tempNode.previousNode;
			
			index--;
			
		}
		
		return index;
		
	}
	
	
	
	// Converting the given list to an arraylist and returning it (Specifically, used to return arraylist because of dynamic resizing).
	
	// Return type - Arraylist<T> (Generic arraylist).
	
	// Method modifier - Non-static.
	
	public ArrayList<T> toArrayList() {
		
		ArrayList<T> returingArrayList = new ArrayList<T>();
		
		Node<T> tempNode = headNode;
		
		while (tempNode != null) {
			
			returingArrayList.add(tempNode.data);
			
			tempNode = tempNode.nextNode;
			
		}
		
		return returingArrayList;
		
	}
	
	
	// Converting the given list to an array and returning it in the data type of object array (Used to return array of a specified size and so, it can't be resized again).
	
	// Return type - Object[] Object array.
	
	// Method modifier - Non-static.
	
	public Object[] toArray() {
		
		Object[] returningArray = new Object[size];
		
		int index = 0;
		
		Node<T> tempNode = headNode;
		
		while (tempNode != null && index<size) {
			
			returningArray[index] = tempNode.data;
			
			tempNode = tempNode.nextNode;
			
			index++;
			
		}
		
		return returningArray;
		
	}
	
	
	
	// Converting the given list to an array of the given specified data type array and then returing it.
	
	// Return Type - array[T] (Generic array).
	
	// Method modifier - Non-static.
	
	@SuppressWarnings("unchecked")
	public T[] toArray(T[] a) {
		
		if(a.length < size) {
			
			a = (T[]) new Object[size];
			
		}
		
		int index = 0;
		
		Node<T> tempNode = headNode;
		
		while (tempNode != null && index<size) {
			
			if(index > size) {
				
				a[index] = null;
				
			}
			
			else {
				
				a[index] = tempNode.data;
				
				tempNode = tempNode.nextNode;
				
			}
			
			index++;
			
		}
		
		return a;
		
	}	
	
	
	
	// To reverse all the elements (Nodes) of the list.
	
	// Return type - void.
	
	// Method modifier - Non-static.
	
	public void reverse() {
		
		Node<T> tempNode = headNode;
		
		Node<T> prevNode = null;
		
		while(tempNode != null) {
			
			prevNode = tempNode.previousNode;
			
			tempNode.previousNode = tempNode.nextNode;
			
			tempNode.nextNode = prevNode;
			
			tempNode = tempNode.previousNode;
			
		}
		
		if(prevNode != null) {
			
			headNode = prevNode.previousNode;
			
		}
		
	}
	
	
	
	// To get a shallow copy of the existing list.
	
	// Return Type - DoubleLinkedList.
	
	// Method modifier - Non-static.
	
	public DoubleLinkedList<T> cloneList() {
		
		DoubleLinkedList<T> clonedList = new DoubleLinkedList<T>();
		
		Node<T> tempNode = headNode;
		
		while(tempNode != null) {
			
			Node<T> newNode = new Node<>(tempNode.data);
			
			if(clonedList.size == 0) {
				
				clonedList.headNode = newNode;
				
				clonedList.tailNode = newNode;
				
			}
			
			else {
				
				clonedList.tailNode.nextNode = newNode;
				
				newNode.previousNode = clonedList.tailNode;
				
				clonedList.tailNode = newNode;
				
			}
			
			tempNode = tempNode.nextNode;
			
			clonedList.size++;
			
		}
		
		return clonedList;
		
	}
	
	
	
	// Retrieves the first element (head) of the list without removing it.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T element() throws ElementNotFoundException {
		
		if(size == 0) {
			
			throw new ElementNotFoundException();
			
		}
		
		return headNode.data;
		
	}
	
	
	
	// Adds the specified element as the tail (last element) of the list.
	
	// Return type - boolean.
	
	// Method modifier - Non-static.
	
	public boolean offer(T data) {
		
		Node<T> newNode = new Node<T>(data);
		
		if(size == 0) {

			headNode = newNode;
			
			tailNode = newNode;
			
		}
		
		else {
					
			tailNode.nextNode = newNode;
			
			newNode.previousNode = tailNode;
			
			tailNode = newNode;
			
		}
		
		size++;
		
		return true;
				
		
	}
	
	
	
	// Inserts the specified element at the front of the list.
	
	// Return type - boolean.
	
	// Method modifier - Non-static.
	
	public boolean offerFirst(T data) {
	
		Node<T> newNode = new Node<T>(data);
		
		if(size == 0) {
			
			headNode = newNode;
			
			tailNode = newNode;
			
		}
		
		else {
			
			headNode.previousNode = newNode;
			
			newNode.nextNode = headNode;
			
			headNode = newNode;
			
		}
		
		size++;
		
		return true;
		
	}
	
	
	
	// Inserts the specified at the end of the list.
	
	// Return type - boolean.
	
	// Method modifier - Non-static.
	
	public boolean offerLast(T data) {
		
		Node<T> newNode = new Node<T>(data);
		
		if(size == 0) {
			
			headNode = newNode;
			
			tailNode = newNode;
			
		}
		
		else {
			
			tailNode.nextNode = newNode;
			
			newNode.previousNode = tailNode;
			
			tailNode = newNode;
			
		}
		
		size++;
		
		return true;
		
	}
	
	
	
	// Retrieves the first element (head) of the list but not removes it.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T peek() {
		
		if(size == 0) {
			
			return null;
			
		}
			
		return headNode.data;
		
	}
	
	
	
	// Retrieves the first element (head) of the list but not removes it.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T peekFirst(){
		
		if(size == 0) {
			
			return null;
			
		}
		
		return headNode.data;
		
	}
	
	
	
	// Retrieves the last element (tail) of the list but not removes it.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T peekLast() {
		
		if(size == 0) {
			
			return null;
			
		}
		
		return tailNode.data;
		
	}
	
	
	
	// Retrieves the first element of the list and also removes it.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T poll() {
		
		if(size == 0) {			
			
			return null;
			
		}
		
		Node<T> tempNode = headNode;
		
		headNode = headNode.nextNode;
		
		if(headNode != null) {
			
			headNode.previousNode = null;
			
		}
		
		else {
			
			tailNode = null;
			
		}
		
		size--;
		
		return tempNode.data;
		
	}
	
	
	
	// Retrieves the first element (head) of the list and also removes it.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T pollFirst(){
		
		if(size == 0) {
			
			return null;
			
		}
		
		Node<T> tempNode = headNode;
		
		headNode = headNode.nextNode;
		
		if(headNode != null) {
			
			headNode.previousNode = null;
			
		}
		
		else {
			
			tailNode = null;
			
		}
		
		size--;
		
		return tempNode.data;				
		
	}
	
	
	
	// Retrieves the last element (tail) of the list and also removes it.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T pollLast() {
		
		if(size == 0) {
			
			return null;
			
		}
		
		Node<T> tempNode = tailNode;
		
		tailNode = tailNode.previousNode;
		
		if(tailNode != null) {	
		
			tailNode.nextNode = null;
			
		}
		
		else {
			
			headNode = null;
			
		}
		
		size--;
		
		return tempNode.data;
		
	}
	
	
	
	// Adds an element to the head of the list. (Last-In-First-Out) - Stack Structure.
	
	// Return type - void.
	
	// Method modifier - Non-static.
	
	public void push(T data) {
		
		Node<T> newNode = new Node<T>(data);
		
		if(headNode == null) {
			
			headNode = newNode;
			
			tailNode = newNode;
			
			size++;
			
			return;
		}
		
		else {
			
			headNode.previousNode = newNode;
			
			newNode.nextNode = headNode;
		
			headNode = newNode;
			
			size++;
			
		}
		
	}
	
	
	
	// Removes the first element of the list (head) and retrieves the data like the stack structure.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T pop() throws ElementNotFoundException{
		
		return remove();
		
	}
	
	
	
	// Replaces the old element at the given index position with the new element and retrieves the element which was previously there at that specified index.
	
	// Return type - T (Node data).
	
	// Method modifier - Non-static.
	
	public T set(int index, T data) throws IndexOutOfRangeException {
		
		if(index < 0 || index >= size) {
			
			throw new IndexOutOfRangeException("Index bound exceeded. Enter a valid index");
			
		}
		
		Node<T> tempNode = headNode;
		
		int idx = 0;
		
		while(tempNode != null) {
			
			if(idx == index) {
				
				T oldNodeData = tempNode.data;
				
				tempNode.data = data;
				
				return oldNodeData;
				
			}
			
			tempNode = tempNode.nextNode;
			
			idx++;
			
		}
		
		return null;
			
	}
	
	
	
	
	
	// List iterator is used to traverse along the elements of the double linked list starting from the head node towards the tail node (correct order).
	
	// Return tyoe - Iterator<T>.
	
	// Method modifer - Non-static.
	
	public Iterator<T> listIterator() {
		
		return new Iterator<T>() {
			
			Node<T> currentNode = headNode;
			
			@Override
			public boolean hasNext() {
				
				if(currentNode != null) {
					
					return true;
					
				}
				
				return false;
				
			}
			
			@Override
			public T next() {
				
				if(!hasNext()) {
					
					throw new NoSuchElementException("Element not found.");
					
				}
				
				T data = currentNode.data;
				
				currentNode = currentNode.nextNode;
				
				return data;
				
			}
			
		};
		
	}	
	
	
	
	// Descending iterator is used to traverse along the elements starting from the tail ending towards the head (reverse order).
	
	// Return type - Iterator<T>.
	
	// Method modifier - Non-static.
	
	public Iterator<T> descendingIterator() {
		
		return new Iterator<T>() {
			
			Node<T> currentNode = tailNode;

			@Override
			public boolean hasNext() {
				
				if(currentNode != null) {
					
					return true;
					
				}
				
				return false;
			}

			@Override
			public T next() {
				
				if(!hasNext()) {
					
					throw new NoSuchElementException("Element not found.");
					
				}

				T data = currentNode.data;
				
				currentNode = currentNode.previousNode;
				
				return data;

			}
		};
		
	}

}
