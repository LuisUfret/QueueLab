

/** 
   A partial implementation of the Queue using a singly linked list with references 
   to the first and to the last node.
**/
public class SLLQueue<E> implements Queue<E> {
       // inner class for nodes in singly linked lists
	private static class Node<E> {   //. 
		private E element; 
		private Node<E> next; 
		public Node(E e) {
			element = null; 
			next= null;
		}
		public E getElement() {
			return element;
		}
		public void setElement(E data) {
			this.element = data;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public void clean() { 
			element = null; 
			next = null; 
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
		Node<E> ntr = first;
		first = first.getNext();
		if(size==1)
			last=null;
		size--;
		E etr= ntr.getElement();
		ntr.clean();
		return etr;
	}
	public void enqueue(E e) {
		Node<E> nuevo = new Node<E>(e);
		if (size == 0) 
			first = last = nuevo; 
		else { 
			last.setNext(nuevo);
			last = nuevo;
			//...
		}
		size++; 
	}

}
