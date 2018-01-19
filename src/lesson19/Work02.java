package lesson19;

public class Work02 {

/*
if you see something unreadable, switch encoding to UTF-8
Создать класс который работает как динамический массив
операция add должна добавлять в массив занчение
length - возвращает размер массива (например если 6 раз вызвана операция add - length() должно вернуть 6
print - печать массива
toArray - возвращает обычный массив java
*/
	public static void main(String[] args) {
		DynamicArray array = new DynamicArray();
		
		//добавляем элементы в массив
		array.add(1);
		array.add(121);
		array.add(1);
		array.add(121);
		array.add(1);
		array.add(121);
		
		System.out.println(array.length()); // 6
		array.print(); // 1, 121, 1, 121, 1, 121
		int[] javaArray = array.toArray();
		// выводит тоже самое что и array.print()
		System.out.println(Arrays.toString(javaArray)) 
	}

}
