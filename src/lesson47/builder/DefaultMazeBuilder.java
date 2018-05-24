package lesson47.builder;

public class DefaultMazeBuilder implements MazeBuilder {
	
	int rooms = 0;
	int doors = 0;
	
	@Override
	public void buildRoom(int number) {
		rooms++;
	}

	@Override
	public void buildDoor(int from, int to) {
		doors++;
	}

	@Override
	public Maze build() {
		return new DefaultMaze(rooms, doors);
	}

}
