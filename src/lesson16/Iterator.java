package lesson16;

public class Iterator {
	private int array[];
	private int index = 0;
	
	public Iterator(int[] initArray) {
		array = initArray;
	}
	
	public int next() {
		if(index >= array.length)
			index = 0;
		return array[index++];
	}
}
