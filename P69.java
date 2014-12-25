public class P69 {
	public static void main(String[] args) {
		P69 runner = new P69();
		runner.run();
	}

	public void run() {
		double max = 0;
		double bestNum = -1;
		for (double i = 1; i < 1000000; i++) {
			if (max < i/(double)totient((int)i)) {
				max = i/(double)totient((int)i);
				bestNum = i;
			}
			if (i % 10000 == 0)
				System.out.println(i);
		}
		System.out.println(bestNum);
	}

	public int totient(int num) {
		int counter = 0;
		for (int i = 1; i < num; i++) {
			if (gcd(num, i) == 1)
				counter++;
		}
		return counter;
	}

	private int gcd(int A, int B) {
		int a = A;
		int b = B;
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}