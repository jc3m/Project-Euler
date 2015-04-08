public class P97 {
	public static void main(String[] args) {
		P97 runner = new P97();
		runner.run();
	}

	public void run() {
		int prime = 28433;
		int iterations = 7830457;
		System.out.println(findPrime(prime, iterations));
	}

	public long findPrime(int prime, int iterations) {
		long num = (long)prime;
		for (int i = 0; i < iterations; i++) {
			num *= 2;
			if (num < 0)
				return -1;
			if (num >= 10000000000l)
				num = num % 10000000000l;
		}
		return (num + 1);
	}
}