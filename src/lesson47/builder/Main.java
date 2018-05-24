package lesson47.builder;

public class Main {

	public static void main(String[] args) {
		MazeBuilder builder = new DefaultMazeBuilder();
		builder.buildRoom(1);
		builder.buildRoom(2);
		builder.buildRoom(3);
		builder.buildRoom(4);
		builder.buildRoom(5);
		builder.buildDoor(1, 2);
		builder.buildDoor(1, -1);
		builder.buildDoor(4, 3);
		Maze maze = builder.build();
		maze.play();
	}

}
