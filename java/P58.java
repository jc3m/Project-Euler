public class P58 {
	public static void main(String[] args) {
		P58 runner = new P58();
		runner.run();
	}

	public void run() {
		double primes = 3;
		double total = 5;
		int currentInc = 2;
		int lastNum = 9;
		while (primes/total > 0.1) {
			currentInc += 2;
			for (int i = 0; i < 4; i++) {
				lastNum += currentInc;
				total++;
				if (isPrime(lastNum))
					primes++;
			}
		}
		System.out.println(currentInc+1);
	}

	public static boolean isPrime(long n) {
		if (n <= 3) {
			return n > 1;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		} else {
			for (int i = 5; i * i <= n; i += 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}
			return true;
		}
	}
}