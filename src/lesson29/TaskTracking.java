package lesson29;

import java.util.Scanner;

public class TaskTracking {

	private Progress status = Progress.ToDo;

	public enum Progress {
		ToDo("Ожидание"), InProgress("В процессе..."), Done("Выполнена");

		public final String Output;

		private Progress(String Output) {
			this.Output = Output;
		}
	}

	public enum Commands {
		
		Status {
			@Override
			public void execute(TaskTracking task) {
				System.out.println(task.status.Output);
			}
		},
		Create {
			@Override
			public void execute(TaskTracking task) {
				task.status = Progress.ToDo;
			}
		},
		Start {
			@Override
			public void execute(TaskTracking task) {
				task.status = Progress.InProgress;

			}
		},
		Finish {
			@Override
			public void execute(TaskTracking task) throws UnsupportedStatusException {
				if (task.status == Progress.InProgress)
					task.status = Progress.Done;
				else
					throw new UnsupportedStatusException();
			}
		};

		public void execute(TaskTracking task) throws UnsupportedStatusException {
			throw new UnsupportedStatusException();
		}
	}
	
	public Progress getStatus() {
		return status;
	}

	public static void main(String[] args) throws UnsupportedStatusException {
		boolean exit = false;
		TaskTracking task = new TaskTracking();
		do {
			System.out.println("Введите команду (Status / Create / Start / Finish)");
			Scanner sc = new Scanner(System.in);
			String s = sc.nextLine();
			Commands command = Commands.valueOf(s);
			command.execute(task);
			
		} while (!exit);
	}

}
