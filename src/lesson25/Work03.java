package lesson25;

public class Work03 {
	public static void main(String[] args) {
		try {
			fileOpen2();
		} finally {
			System.out.println("Cleanup");
		}
		System.out.println("Exit");
	}

	public static void fileOpen2(){
		try {
			fileOpen();
		} finally {
			throw new RuntimeException();
		}
	}

	public static void fileOpen() {
		if(Math.random() > 0.5)
			throw new RuntimeFakeException();
		System.out.println("Success");
	}
}
