/** 
   A partial implementation of the Queue using a singly linked list with references 
   to the first and to the last node.
**/
public class SLLQueue<E> implements Queue<E> {
       // inner class for nodes in singly linked lists
	private static class Node<E> {   //. 
		private E element; 
		private Node<E> next; 
		public E getElement() {
			return element;
		}
		//...
	}	
	private Node<E> first, last;   // references to first and last node
	private int size; 
	
	public SLLQueue() {           // initializes instance as empty queue
		first = last = null; 
		size = 0; 
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E first() {
		if (isEmpty()) return null;
		return first.getElement(); 
	}
	public E dequeue() {
		if (isEmpty()) return null;		
		//...
		return null;
	}
	public void enqueue(E e) {
		if (size == 0) 
			first = last = new Node<>(e); 
		else { 
			//...
		}
		size++; 
	}

}