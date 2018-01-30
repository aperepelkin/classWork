package lesson16;

import ru.itstep.lesson17.TestClass;

public class Glass {
	
	TestClass c;
	
	private int level;

	public Glass() {}
	private Glass(int initLevel) {
		level = initLevel;
	}
	
	public void fill(int volume) {
		level += volume;
	}
	
	public void reduce(int volume) {
		level -= volume;
	}
	
	public void transferTo(Glass other) {
		if(other == this)
			return;
		other.level += this.level;
		this.level = 0;
	}
	
	public int level() {
		return level;
	}	
}