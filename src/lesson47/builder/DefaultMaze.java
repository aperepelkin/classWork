package lesson47.builder;

public class DefaultMaze implements Maze {
	int rooms = 0;
	int doors = 0;
	
	public DefaultMaze(int rooms, int doors) {
		super();
		this.rooms = rooms;
		this.doors = doors;
	}

	@Override
	public void play() {
		System.out.println(rooms);
		System.out.println(doors);
	}
}
