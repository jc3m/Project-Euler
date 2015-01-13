import java.util.Arrays;

public class P50 {
	static int[] primes;

	public P50() {
		primes = generate(1000000);
	}

	public static void main(String[] args) {
		P50 runner = new P50();
		/*System.out.println(primes.length);
		int total = 0;
		for (int i = 10; i < 75232; i++) {
			total += primes[i];
		}
		System.out.println(total);*/
		System.out.println(runner.run());
	}

	public int run() {
		int max = 2;
		int maxPrime = 0;
		for (int i = 0; i < primes.length - max + 1; i++) {
			int sum = primes[i];
			//int length = 1;
			boolean var = true;
			for (int j = i + 1; j < primes.length && var; j++) {
				sum += primes[j];
				if (sum < 0) var = false;
				int length = j - i;
				if (Arrays.binarySearch(primes, sum) > 0 && length > max) {
					max = length;
					maxPrime = sum;
					//System.out.println("Max: " + maxPrime + ", Length: " + length + ", Start: " + primes[i] + " " + i);
				}
			}
		}
		return maxPrime;
	}

	private int[] generate(int n) {
		boolean[] sieve = new boolean[n+1];
		for (int i = 2; i < sieve.length; i++) {
			sieve[i] = true;
		}
		int current = 2;
		while (current < sieve.length) {
			if (sieve[current]) {
				for (int i = current*2; i < sieve.length; i += current) {
					sieve[i] = false;
				}
			}
			current++;
		}
		int size = 0;
		for (int i = 0; i < sieve.length; i++) {
			if (sieve[i])
				size++;
		}
		int[] res = new int[size];
		int index = 0;
		for (int i = 0; i < sieve.length; i++) {
			if (sieve[i]) {
				res[index] = i;
				index++;
			}
		}
		return res;
	}
}