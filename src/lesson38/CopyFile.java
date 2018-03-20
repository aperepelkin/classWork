package lesson38;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public static void main(String[] args) {

		try(FileInputStream inStream = new FileInputStream("src/inputOutput10_1/text.txt")) {
			File dir = new File("src/inputOutput10_1/newFolder");
			if(!dir.exists())
				dir.mkdirs();
			try(FileOutputStream outStream = new FileOutputStream("src/inputOutput10_1/newFolder/text2.txt")) {
//				byte[] b = new byte[inStream.available()];
//				int length;
//				
//				while((length = inStream.read(b)) != -1)
//					outStream.write(b, 0, length);
				int data;
				while((data = inStream.read()) != -1)
					outStream.write(data);
				
			} catch (IOException e) {
				System.out.println("Output err");
			}
		} catch (IOException e) {
			System.out.println("Input err");
		}

	}
}