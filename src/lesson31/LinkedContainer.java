package lesson31;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedContainer<E> implements Iterable<E>, List<E> {

	private Node<E> fstNode;
	private Node<E> lstNode;
	private int size = 0;
	
	public LinkedContainer() {
		lstNode = new Node<E>(null, fstNode/*==null*/, null);
		fstNode = new Node<E>(null, null, lstNode);
		lstNode.prevElement = fstNode;
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
		return getNodeByIndex(counter).currentElement;
	}

	private Node<E> getNodeByIndex(int counter) {
		Node<E> target = fstNode.getNextElement();
		for (int i = 0; i < counter; i++) {
			target = target.getNextElement(); // method private Node<E> getNextElement(Node<E> current)
		}
		return target;
	}

	public E deleteAtPosition(int position) {
		if(position > size || position < 1) {
			throw new IndexOutOfBoundsException();
		}
		if(position == 1) {
			size--;
			Node<E> temp = fstNode.getNextElement();
			fstNode.setNextElement(lstNode);
			lstNode.setPrevElement(fstNode);
			return temp.getCurrentElement();
		}
		else {
			size--;
			Node<E> previous = getNodeByIndex(position);
			Node<E> current = previous.nextElement;
			previous.nextElement = current.nextElement;
			current.nextElement.prevElement = previous;
			return current.currentElement;
		}
	}
	
	// iterator for getting el-s from the list
	public Iterator<E> iterator() {
		return new Iterator<E>() { // anonymous class
			private Node<E> current = fstNode; 
			
			@Override
			public boolean hasNext() {
				return current.nextElement != lstNode;
			}
			
			@Override
			public E next() {
				current = current.nextElement;
				return current.currentElement;
			}
		};
	}
	// method to converse el-s from the list
	public Iterator<E> descendingIterator() {
		return new Iterator<E>() { // anonymous class
			private Node<E> current = lstNode; 

			@Override
			public boolean hasNext() {
				return lstNode.prevElement != fstNode;
			}

			@Override
			public E next() {
				current = current.prevElement;
				return current.currentElement;
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

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {
		addLast(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		fstNode.setNextElement(lstNode);
		lstNode.setPrevElement(fstNode);
	}

	@Override
	public E get(int index) {
		return getElementByIndex(index);
	}

	@Override
	public E set(int index, E element) {
		getNodeByIndex(index).currentElement = element;
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}