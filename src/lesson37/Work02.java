package lesson37;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Work02 {

	public static void main(String[] args) throws IOException {
		try(FileOutputStream fs = new FileOutputStream("file.ddd")) {
			fs.write(1);
		}
		
		FileOutputStream fs = new FileOutputStream("file.ddd");
		try {
			fs.write(1);
		} finally {
			fs.close();
		}
		System.in.read();
	}
}
