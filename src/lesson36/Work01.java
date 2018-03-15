package lesson36;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Work01 {

	public static void main(String[] args) throws IOException {
		File file = new File("bin/console.log");
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(file.length());
		
		OutputStream mlt = new OutputStream() {
			FileOutputStream fs = new FileOutputStream("bin/out", true);
			PrintStream console = System.out;
			
			@Override
			public void write(int b) throws IOException {
				fs.write(b);
				console.write(b);
			}
		};
		
		PrintStream ps = new PrintStream(mlt);
		System.setOut(ps);
		System.out.println("Hello");
		System.err.println("Error");
	}

}
