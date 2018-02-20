package lesson29;

import java.util.Scanner;

public class TaskTracking {

	public enum Progress {
		ToDo("Ожидание"), InProgress("В процессе..."), Done("Выполнена");
		
		public String Output ;
		
		private Progress (String Output) {
			this.Output = Output;
		}
	}
	
	
	public static void main(String[] args) {
		boolean exit = false;
		Progress var = Progress.ToDo;
		do {
		System.out.println("Введите команду (Status / Create / Start / Finish)");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		switch (s) {
		case "Status":
			System.err.println(var.Output);
			break;
		case "Create":
			var = Progress.ToDo;
			System.err.println(var.Output);
			break;
		case "Start":
			var = Progress.InProgress;
			System.err.println(var.Output);
			break;
		case "Finish":
			if (var != Progress.ToDo) {
			var = Progress.Done;
			System.err.println(var.Output);
			exit = true;
			}
			if (var == Progress.ToDo) {
				System.err.println("Ошибка");
			}
			break;
		}
		
		}while (!exit);
	}

}
