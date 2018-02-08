package lesson24;

public class ArrayHolder {
	
	private int[] array;
	
	public ArrayHolder(int[] array) {
		this.array = array;
	}
	
	public class Iterator {
		private int cursor = 0;
		
		public int next() {
			return array[cursor++];
		}
		
		public boolean hasNext() {
			return cursor < array.length;
		}
	}
}
