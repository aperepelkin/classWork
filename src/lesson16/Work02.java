package lesson16;

import utils.Utils;

public class Work02 {

	public static void main(String[] args) {
		
		Iterator it = new Iterator(Utils.randomArray(10));
		
		System.out.println(it.next());
		//it.index++; /// INCORRECT!
		System.out.println(it.next());
		//it.index +=2; /// INCORRECT!
		System.out.println(it.next());
		//it.array = Utils.randomArray(10); /// INCORRECT!
		System.out.println(it.next());
		System.out.println(it.next());
	}
}
