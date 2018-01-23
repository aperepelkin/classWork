package lesson20;

import lesson20.table.CSVTableReader;
import lesson20.table.ExcelTableReader;
import lesson20.table.TableReader;

public class Work02 {

	public static void main(String[] args) {
		new ExcelTableReader("filepath").read();
		new CSVTableReader("filepath").read();

	}
	
	

}
