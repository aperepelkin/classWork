package lesson17;

class Worker {
	public static int i = 0;
	public int j = 0;
	
	public static void call() {
		i++;
		System.out.println("I am from main package" + i);
	}
}
