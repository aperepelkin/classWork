package lesson24;

import lesson24.ArrayHolder.Iterator;

public class Work02 {

	public static void main(String[] args) {
		ArrayHolder array = new ArrayHolder(new int[] {1,2,2,23,3,4,5});
		
		Iterator it1 = array.new Iterator();
		Iterator it2 = array.new Iterator();
		while(it1.hasNext())
			System.out.println(it1.next());

		while(it2.hasNext())
			System.out.println(it2.next());
}

}
