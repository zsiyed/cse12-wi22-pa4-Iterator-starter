/**
 * TODO: Add your file header
 * Name: Zed Siyed
 * Email: zsiyed@ucsd.edu
 * Sources used: None
 * 
 * this class has the linkedList class and that contains a node class
 * this is used to create linkedList objects that contain nodes
 */

import java.util.AbstractList;
import java.util.ListIterator;
// import java.util.Iterator;
import java.util.NoSuchElementException;

/** 
 * The MyLinkedList class extends the abstract class AbstractList 
 * and is a generic class
 */

public class MyLinkedList<E> extends AbstractList<E> {

	int size;
	Node head;
	Node tail;

	/**
	 * A Node class that holds data and references to previous 
	 * and next Nodes.
	 */
	protected class Node {
		E data;
		Node next;
		Node prev;

		/** 
		 * Constructor to create singleton Node 
		 * @param element Element to add, can be null	
		 */
		public Node(E element) {
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/** 
		 * Set the parameter prev as the previous node
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;		
		}

		/** 
		 * Set the parameter next as the next node
		 * @param next - new next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/** 
		 * Set the parameter element as the node's data
		 * @param element - new element 
		 */
		public void setElement(E element) {
			this.data = element;
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}

		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev() {
			return this.prev;
		}

		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		}
	}

	//  Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	// MyLinkedList empty constructor
	public MyLinkedList() {
		head = new Node(null);
		tail = new Node(null);
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
		this.size = 0;
	}

	/**
     * retrieves number of nodes in LinkedList
     * @return int- size of LinkedList
     */
	@Override
	public int size() {
		// need to implement the size method
		return this.size; // TODO
	}

	/**
     * retrieves element at a certain index
	 * @param index- index of node to access
     * @return E- data in accessed node
     */
	@Override
	public E get(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		Node currNode = head;
		for (int i = 0; i < this.size; i++){
			if ( i == index){
				return currNode.getNext().getElement();
			}
			currNode = currNode.next;
		}
		return (E) null;  // TODO
	}

	/**
     * adds element at a certain index
	 * @param index- int index of node to access
	 * @param data- generic element E to add as a node
     */
	@Override
	public void add(int index, E data) {
		/* Add your implementation here */
		// TODO
		if (index<0 || index>size){
			throw new IndexOutOfBoundsException();
		} 
		else if (data == null){
			throw new NullPointerException();
		}

		if(index == size)
		{
			add(data);
			size--;
		}
		else
		{
			Node currNode = head;
			for (int i = 0; i<index; i++) { 
				currNode = currNode.next; 
			}
			Node newNode = new Node(data);
			currNode.next.setPrev(newNode);
			newNode.setNext(currNode.next);
			newNode.setPrev(currNode);
			currNode.setNext(newNode);
		}
			
		size++;
	}

	/**
     * adds element at end of the list
	 * @param data- generic element E to add as a node
	 * @return boolean- returns true when method called

     */
	public boolean add(E data) {
		if ( data == null){
			throw new NullPointerException();
		}
		Node newNode = new Node(data);
		newNode.setNext(tail); //
		newNode.setPrev(tail.getPrev()); //
		tail.prev.setNext(newNode);
		tail.setPrev(newNode);
		
		// add(size-1, data);
		size++;
		return true; // TODO
	}

	/**
     * sets nodes data at a certain index to data
	 * @param index- int index of node to access
	 * @param data- generic element E to set as a node's data
	 * @return E- returns the data that was replaced

     */
	public E set(int index, E data) {
		if (index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		} 
		else if (data == null){
			throw new NullPointerException();
		}
		Node currNode = head.next;
		for (int i = 0; i<index; i++) { 
			currNode = currNode.next; 
		}
		E oldData = currNode.getElement();
		currNode.setElement(data);
		return oldData; // TODO
	}

	/**
     * removes entire node from linked list
	 * @param index- int index of node to remove
	 * @return E- returns the data that was replaced
     */
	public E remove(int index) {
		if (index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		} 
		Node currNode = head.next;
		for (int i = 0; i<index; i++) { 
			currNode = currNode.next; 
		}
		currNode.prev.setNext(currNode.next);
		currNode.next.setPrev(currNode.prev);
		size--;
		return currNode.getElement(); // TODO
	}

	/**
     * removes all nodes from linked list
     */
	public void clear() {
		/* Add your implementation here */

		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
		this.size = 0;
	}

	/**
     * determines if LinkedList has at least 1 node
	 * @return boolean- true if size is 0, false otherwise
     */
	public boolean isEmpty() {
		if (size != 0){
			return false;
		}
		return true;  // TODO
	}

	/**
     * gets entire node at certain index
	 * @param index gives index of node to access
	 * @return Node- returns the node at given index
     */
	protected Node getNth(int index) {
		if (index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		} 
		Node currNode = head;
		for (int i = 0; i < this.size; i++){
			if ( i == index){
				return currNode.getNext();
			}
			currNode = currNode.next;

		}
		return (Node) null;  // TODO
	}

	protected class MyListIterator implements ListIterator<E> {


        // class variables here
		Node left,right;
		int idx;
		boolean forward;
		boolean canRemoveOrSet;

        // MyListIterator methods
		public MyListIterator(){
			// if (size() != 0){
				left = head;
				right = head.getNext();
				idx = 0;
				forward = false;
				canRemoveOrSet = false;
				
		}

        public boolean hasNext() {
			if (idx != size()){
				return true;
			}
			return false;
			
        }

		public E next(){
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			left = right;
			right = right.getNext();
			idx++;
			canRemoveOrSet = true;
			forward = true;
			return left.getElement();
		}

		public boolean hasPrevious(){
			// if (left.getElement() != null){
			// 	return true;
			// }
			// return false;
			if (idx == 0){
				return false;
			}
			return true;
		}

		public E previous(){
			if (!hasPrevious()){
				throw new NoSuchElementException();
			}
			right = left;
			left = left.getPrev();
			idx--;
			canRemoveOrSet = true;
			forward = false;
			return right.getElement();
		}

		public int nextIndex(){
			return idx;
		}

		public int previousIndex(){
			return idx-1;
		}

		public void add(E element){
			if(element == null)
			{
				throw new NullPointerException();
			}

			Node newNode = new Node(element);
			Node prevNode = left;
			Node nextNode = right;
			if(idx == 0)
			{
				head.setNext(newNode);
				right.setPrev(prevNode);
			}
			else
			{
				newNode.setNext(nextNode);
				newNode.setPrev(prevNode);

				right.setPrev(newNode);
				left.setNext(newNode);
			}
			

			
			left = newNode;
			canRemoveOrSet = false;
			idx++;


			/*Node newNode = new Node(element);
			left.setNext(newNode);
			right.setPrev(newNode);
			newNode.setNext(right);
			newNode.setPrev(left);
			idx++;*/
		}

		public void set(E element){
			if (element == null){
				throw new NullPointerException();
			}
			if (forward == true && canRemoveOrSet){
				left.setElement(element);
				canRemoveOrSet = false;
			}
			else if (canRemoveOrSet){
				right.setElement(element);
				canRemoveOrSet = false;
			}
			else{
				throw new IllegalStateException();
			}
		}

		public void remove(){

			if (forward == true && canRemoveOrSet){
				right.setPrev(left.getPrev());
				left = left.getPrev();
				
				canRemoveOrSet = false;
				idx--;
			}
			else if (canRemoveOrSet){
				left.setNext(right.getNext());
				right = right.getNext();

				canRemoveOrSet = false;
			}
			else{
				throw new IllegalStateException();
			}
		}

        // more methods, etc.

}
}