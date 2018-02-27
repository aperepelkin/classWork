package lesson31;

import java.util.Iterator;

public class LinkedContainer<E> implements Iterable<E> {

	private Node<E> fstNode;
	private Node<E> lstNode;
	private int size = 0;
	
	public LinkedContainer() {
		lstNode = new Node<E>(null, fstNode, null);
		fstNode = new Node<E>(null, null, lstNode);
	}
	
	public void addLast(E e) {
		Node<E> prev = lstNode;
		prev.setCurrentElement(e);
		lstNode = new Node<E>(null, prev, null);
		prev.setNextElement(lstNode);
		size++;
	}
	
	public void addFirst(E e) {
		Node<E> first = fstNode;
		first.setCurrentElement(e);
		fstNode = new Node<E>(null, null, first);
		first.setPrevElement(fstNode);
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public E getElementByIndex(int counter) {
		Node<E> target = fstNode.getNextElement();
		for (int i = 0; i < counter; i++) {
			target = getNextElement(target); // method private Node<E> getNextElement(Node<E> current)
		}
		return target.getCurrentElement();
	}
	
	private Node<E> getNextElement(Node<E> current) {
		return current.getNextElement();
	}
	
	public Node<E> deleteAtPosition(int position) {
		if(position > size || position < 1) {
			System.out.println("Invalid position.");
			return fstNode;
		}
		if(position == 1) {
			Node<E> temp = fstNode;
			fstNode.setNextElement(fstNode);
			temp.nextElement = null;
			return temp;
		}
		else {
			Node<E> previous = fstNode;
			int count = 1;
			while(count < position) {
				previous = previous.nextElement;
				count++;
			}
			Node<E> current = previous.nextElement;
			previous.nextElement = current.nextElement;
			current.nextElement = null;
			return current;
		}
	}
	
	// iterator for getting el-s from the list
	public Iterator<E> iterator() {
		return new Iterator<E>() { // anonymous class
			int counter = 0;
			
			@Override
			public boolean hasNext() {
				return counter < size;
			}
			
			@Override
			public E next() {
				return getElementByIndex(counter++);
			}
		};
	}
	// method to converse el-s from the list
	public Iterator<E> descendingIterator() {
		return new Iterator<E>() { // anonymous class
			int counter = size - 1;

			@Override
			public boolean hasNext() {
				return counter >= 0;
			}

			@Override
			public E next() {
				return getElementByIndex(counter--);
			}
		};
	}

	// inner class -> analogue of the original 'Linked List'
	private class Node<E> {
		private E currentElement;
		private Node<E> nextElement;
		private Node<E> prevElement;
		
		private Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
		this.currentElement = currentElement;
		this.nextElement = nextElement;
		this.prevElement = prevElement;
		}

		public E getCurrentElement() {
			return currentElement;
		}

		public void setCurrentElement(E currentElement) {
			this.currentElement = currentElement;
		}

		public Node<E> getNextElement() {
			return nextElement;
		}

		public void setNextElement(Node<E> nextElement) {
			this.nextElement = nextElement;
		}

		public Node<E> getPrevElement() {
			return prevElement;
		}

		public void setPrevElement(Node<E> prevElement) {
			this.prevElement = prevElement;
		}
	}
}