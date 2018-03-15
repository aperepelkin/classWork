package lesson36.homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IOTask {
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the path to directory or file");
		String path = scan.nextLine();
		
		File file = new File(path);
		
		if(file.isDirectory()) {
			System.out.println("It's directory. Named " + file.getName() + ". ");
			String[] cont = file.list();
			if(cont != null) {
				System.out.println("It has " + cont.length + " files and/or directories. Their names are ");
				for(String each : cont)
					System.out.println(each);
			}
		}
		else if(file.isFile()) {
			System.out.println("It's file. " + "Size " + file.length());
		}
		else {
			System.out.println("The path doesn't exist, the nearest existing is: " + existing(file));
			
//			String[] cont = file.list();
//			try {
//				for(String each : cont)
//					System.out.println(each + "/");				
//			} catch (NullPointerException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	private static String existing(File file) {
		if(file == null)
			return null;
		if(file.exists())
			return file.getAbsolutePath();
		else {
			return existing(file.getAbsoluteFile().getParentFile());  
		}
	}
}