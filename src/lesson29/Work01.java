package lesson29;

public class Work01 {
	
	public enum Seasons {
		WINTER("Зима"), SUMMER("Лето"), SPRING("Весна"), AUTUMN("Осень");
		
		public String russianName;
		
        Seasons(String russianName) {
			this.russianName = russianName;
		}
		
		public boolean isCold() {
			return this != SUMMER;
		}
	}

	public static void main(String[] args) {
		
		Seasons var = Seasons.SPRING;
		
		System.out.println(var.russianName);
		
		switch(var) {
		case WINTER:
			System.out.println("Зима");
			break;
		case SUMMER:
			System.out.println("Лето");
			break;
		case SPRING:
			System.out.println("Весна");
			break;
		case AUTUMN:
			System.out.println("Осень");
			break;
		}
		
		if(var == Seasons.SPRING) {
			System.out.println("Do something");
		}
		
		if(var != Seasons.SUMMER)
			System.out.println("Do something else");
		
		System.out.println(var.name());
		System.out.println(var.ordinal());
		
		var = Seasons.valueOf("SUMMER");

		System.out.println(var.name());
		System.out.println(var.ordinal());
		
		if(var.isCold()) {
			System.out.println("It's cold!");
		} else {
			System.out.println("Cool");
		}
	}

}
