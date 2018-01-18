package lesson19;

public class Work02 {

	public static void main(String[] args) {
		DynamicArray array = new DynamicArray();
		
		array.add(1);
		array.add(121);
		array.add(1);
		array.add(121);
		array.add(1);
		array.add(121);
		
		System.out.println(array.length()); // 6
		array.print(); // 1, 121, 1, 121, 1, 121
		int[] javaArray = array.toArray();
	}

}
