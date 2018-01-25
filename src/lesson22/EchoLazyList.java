package lesson22;

import java.util.Iterator;

public class EchoLazyList 
	extends BaseList 
	implements List, Iterable {

	@Override
	public void addItem(Object obj) {
		System.out.println("Add element " + obj);
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
