package lesson47.composite;

import java.util.ArrayList;
import java.util.List;

public class Category implements Position {

	List<Position> positions = new ArrayList<>();

	@Override
	public void show() {
		for(Position p : positions) {
			p.show();
		}
	}
}
