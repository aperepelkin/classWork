package lesson26;

public class Box <T> {
	private T value;
	
	public Box(T value){
		this.value = value;
	}
	 
	public T value() {
		return value;
	}
}
