package lesson22;

public class Work01 {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		List.fillMe(list);
		if(list instanceof EchoLazyList){
			EchoLazyList instance = (EchoLazyList) list;
		}
	}
}
