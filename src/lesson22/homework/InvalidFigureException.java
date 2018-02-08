package lesson22.homework;

public class InvalidFigureException extends Exception {
	
	private Integer oneSideLength;
	private Integer twoSideLength;
	
	public InvalidFigureException(
			Integer oneSideLength, 
			Integer twoSideLength) {
		super("any2");
		this.oneSideLength = oneSideLength;
		this.twoSideLength = twoSideLength;
	}
}
