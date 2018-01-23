package lesson20.table;

public abstract class TableReader {
	
	private String file;
	
	public TableReader(String file) {
		this.file = file;
	}

	public String[] read() {
		String[] lines = new String[10];
		openFile();
		String s = readString();
		int index = 0;
		while(s != null) {
			lines[index++] = s;
			s = readString();
		}
		return lines;
	}
	
	protected abstract String readString();
	
	public void openFile() {
		System.out.println("Open file " + file);
	}
}
