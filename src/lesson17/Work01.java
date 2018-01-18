package lesson17;

import static lesson17.a.Worker.call;

public class Work01 {

	public static void main(String[] args) {
		lesson17.Worker.call();
		lesson17.b.Worker.call();
		Worker.call();
		call();
	}
}
