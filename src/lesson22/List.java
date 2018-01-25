package lesson22;

public interface List {
	
	String NAME = "list";
	
	void addItem(Object obj);
	
	static void fillMe(List l) {
		for(int i = 0; i<10; i++) 
			l.addItem(i);
	}
	
	default int size() {
		return 0;
	}
}
