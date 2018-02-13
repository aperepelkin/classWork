package lesson27;

import java.io.IOException;
import java.util.Comparator;

import lesson26.Box;

public class Work01 {
	
	static class DoubleComparator implements Comparator<Double> {

		@Override
		public int compare(Double o1, Double o2) {
			return o1.compareTo(o2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Box<Integer> o1 = box(1);
		Box<Integer> o2 = box(1.6);

		double m = max(
				(Comparator<Double>)((o11, o22) -> o11.compareTo(o22)),
				3.4, 6.7);
		
		String sm = max("asd", "sdg");
		System.in.read();
	}
	
	public static <T extends Number> Box<Integer> box(T o) {
		return new Box<>(o.intValue());
	}
	
	private static <T> T max(Comparator<T> comparator, T... array) {
		T max = array[0];
		for(T item: array)
			if(comparator.compare(max, item) < 0)
				max = item;
		return max;
	}

	private static <T extends Comparable<T>> T max(T... array) {
		T max = array[0];
		for(T item: array)
			if(max.compareTo(item) < 0)
				max = item;
		return max;
	}
}
