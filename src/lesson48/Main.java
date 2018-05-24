package lesson48;

public class Main {

	// первый аргумент server или desktop или office
	// второй комплектация low medium high
	public static void main(String[] args) {	
		director = new DirectorFactory(first_arg).createDirector();
//		if(server)
//			director = new ServerDirector();
//		if(desktop)
//			director = new DesktopDirector();
//		if(office)
//			office = new OfficeDirector();
		
//		if(low)
//			builder = new LowComputerBuilder();
//		if(medium)
//			builder = new MediumComputerBuilder();
//		if(high)
//			builder = new HighComputerBuilder();
		
		director.setComputerBuilder(builder);
		director.constructComputer();

		//		Computer c = new Computer();
//
//		if(high)
//			c.setSystemBlock("h");
//		if(medium)
//			c.setSystemBlock("m");
//		if(low)
//			c.setSystemBlock("l");
//		if(desktop || office) {
//			if(high)
//				c.setMonitor("h");
//				c.setManipulator("h");
//			if(medium)
//				c.setMonitor("m");
//				c.setManipulator("m");
//			if(low)
//				c.setMonitor("l");
//				c.setManipulator("l");
//		}
//		if(office) {
//			if(high)
//				c.setPrinter("h")
//			if(medium)
//				c.setPrinter("m")
//			if(low)
//				c.setPrinter("l")
//		}
	}
}
