package lesson11;

public class Work02 {

	public static void main(String[] args) {
		String str = "54    6 +    5   ";
		
		String str1 = str.replaceAll("[468]+", "?");
//		while(str.contains("  "))
//			str = str.replace("  ", " ");
		
		System.out.println(str);
		System.out.println(str1);
	}

}
