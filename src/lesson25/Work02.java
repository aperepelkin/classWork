package lesson25;

public class Work02 {

	public static void main(String[] args) {
			try {
				fileOpen2();
			} catch (FakeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Exit");
	}
	public static void fileOpen2() throws Exception, FakeException  {
		fileOpen();
	}
	
	public static void fileOpen() throws Exception, FakeException {
		if(Math.random() > 0.5)
			throw new FakeException();
		else
			throw new Exception("Less then 0.5");
	}
}
