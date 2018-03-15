package lesson36;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Work02 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String fileString = sc.nextLine();
		File file = new File(fileString);
		
		if(file.getParentFile() != null ) {
			System.out.println(file.getParentFile());
			if(!file.getParentFile().exists()) {
				System.out.println("Путь не существует! создаем");
				file.getParentFile().mkdirs();
			}
		}
			
		FileOutputStream fs = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fs);
		
		
		for(int i = 0; i < 10; i++)
			fs.write("5".getBytes());
	}

}
