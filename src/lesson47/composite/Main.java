package lesson47.composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Position> positions = new ArrayList<>();
		positions.add(new PositionItem());
		positions.add(new PositionItem());
		positions.add(new PositionItem());
		positions.add(new Category());
		for(Position p : positions) {
			p.show();
		}
	}
}
