package lesson14;

public class Work02 {

	public static void main(String[] args) {
		System.out.println(fib(50));
	}

	static long factorial(int n) {
		if(n == 1)
			return 1;
		return n * factorial(n-1);
	}
	
	static long fib(long n) {
		if(n == 1 || n == 2)
			return 1;
		long n1 = 1;
		long n2 = 0;
		
		for(long i = 2; i < n; i++){
			long r = n1 + n2;
			n2 = n1;
			n1 = r;
		}
		return n1;
	}
}
