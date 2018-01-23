package lesson20.table;

public class ExcelTableReader extends TableReader {

	private int line = 0;
	
	public ExcelTableReader(String file) {
		super(file);
	}

	@Override
	protected String readString() {
		System.out.println("Read string from Excel");
		if(line <= 10)
			return "String " + line++;
		return null;
	}

}
