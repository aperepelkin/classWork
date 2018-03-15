package lesson37;

import java.io.IOException;
import java.io.InputStream;

public class Work01 {

	public static void main(String[] args) throws IOException {
		int op1 = getInt(System.in);
		String op = getString(System.in);
		int op2 = getInt(System.in);
		System.out.println(op1 + op2);
	}
	
	private static int getInt(InputStream is) throws IOException {
		return Integer.parseInt(getString(is));
	}
	
	private static String getString(InputStream is) throws IOException {
		int data = is.read();
		int index = 0;
		byte[] input = new byte[System.in.available() + 1];
		input[index++] = (byte) data;
		while((data = is.read()) != ' ') {
			input[index++] = (byte) data;
		}
		return new String(input, 0, index);
	}
}
