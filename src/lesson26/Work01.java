package lesson26;

public class Work01 {

	public static void main(String[] args) {
		Box<Integer> bi = new Box<>(1);
		Box<? extends Number> bn = new Box<>(1.6);
		Box<String> bs = new Box<>("asf");
		
		bn = bi;
		bn = bs;
	}

}
