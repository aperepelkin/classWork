package lesson20.table;

public class CSVTableReader extends TableReader {

	private int line = 0;

	public CSVTableReader(String file) {
		super(file);
	}

	@Override
	protected String readString() {
		System.out.println("Read string from CSV");
		if(line <= 10)
			return "String " + line++;
		return null;
	}

}
