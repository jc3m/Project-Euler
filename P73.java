public class P73 {
	public static void main(String[] args) {
		P73 runner = new P73();
		runner.run();
	}

	public void run() {
		double lower = 1.0/3.0;
		double upper = 0.5;
		int counter = 0;
		for (int i = 1; i < 6000; i++) {
			for (int j = i * 2 + 1; j <= Math.min(12000, i * 3); j++) {
				if (gcd(i, j) == 1 && test(i, j, upper, lower)) {
					//System.out.println(i + "/" + j);
					counter++;
				}
			}
		}
		System.out.println(counter);
	}

	private boolean test(double i, double j, double upper, double lower) {
		return i / j < upper && i / j > lower;
	}

	private int gcd(int x, int y) {
		int a = x;
		int b = y;
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}