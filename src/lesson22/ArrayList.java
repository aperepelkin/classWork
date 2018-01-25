package lesson22;

public class ArrayList extends java.util.ArrayList implements List {

	@Override
	public void addItem(Object obj) {
		System.out.println(
				"I am realy add item to list" + obj);
		this.add(obj);
	}
}
