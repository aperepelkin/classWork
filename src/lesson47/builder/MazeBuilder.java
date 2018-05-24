package lesson47.builder;

public interface MazeBuilder {
	void buildRoom(int number);
	void buildDoor(int from, int to);
	Maze build();
}
