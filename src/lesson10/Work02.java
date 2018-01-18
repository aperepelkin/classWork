package lesson10;

import java.util.Scanner;

public class Work02 {

	public static void main(String[] args) {

		String digits = "-0123456789";
		String operations = "-+*/";

		Scanner sc = new Scanner(System.in);
		System.out.println("Введите выражение");
		String line = sc.nextLine();
		String[] strings = line.split(" ");
		if (strings.length == 3) {
			
			boolean isDigit = true;
			for (char ch : strings[0].toCharArray()) {
				if(digits.indexOf(ch) == -1){
					isDigit = false;
					break;
				}
				digits.replace(target, replacement)
			}
			
			if (!isDigit)
				System.out.println("Первое значение не числовое");
			else {
				int a = Integer.valueOf(strings[0]);
				String operation = strings[1];
				int b = Integer.valueOf(strings[2]);
				switch (operation) {
				case "+":
					System.out.println(a + b);
					break;
				case "-":
					System.out.println(a - b);
					break;
				case "/":
					System.out.println(a / b);
					break;
				case "*":
					System.out.println(a * b);
					break;
				default:
					System.out.println("Неизвестная операция");
				}
			}
		}
		// String[] operations = new String[line.length()];
		// int operationsCount = 0;
		// for(String str : strings) {
		//
		// boolean isDigit = true;
		// boolean isOperation = false;
		// if(str.length() == 1 && operation.contains(str)){
		// isOperation = true;
		// }
		//
		// if(!isOperation)
		// for(char ch : str.toCharArray()){
		// if(!digits.contains(new String(new char[] {ch}))){
		// isDigit = false;
		// break;
		// }
		// }
		//
		// if(!isOperation && !isDigit)
		// continue;
		//
		// if(isOperation){
		//
		// }
		//
		// }
	}

}
