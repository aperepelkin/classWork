package lesson30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Work01 {
	
	static final long N = 10000000;

	public static void main(String[] args) {
		List<? extends Object> l = test(new ArrayList<>());
		test(new LinkedList<>());
	}
	
	public static List<Integer> test(List<Integer> list) {
		long start = System.nanoTime();
		for(int i = 0; i < N; i++) {
			list.add(null);
		}
		System.out.println((System.nanoTime() - start) / N);
		return list;
	}
}
