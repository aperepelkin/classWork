package lesson39;

import lombok.ToString;

@ToString
public class TestClass {
	
	private int max;
	private int min;
	
	@SetValue(5)
	public void setMax(int max) {
		this.max = max;
		System.out.println("invoked with: " + max);
	}
	
	@SetValue(1)
	public void setMin(int min) {
		this.min = min;
		System.out.println("invoked with: " + min);
	}
}
