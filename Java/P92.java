public class P92 {
	public static void main(String[] args) {
		P92 runner = new P92();
		runner.run();
	}

	public void run() {
		int counter = 0;
		for (int i = 1; i < 10000000; i++) {
			if (digitChain(i))
				counter++;
		}
		System.out.println(counter);
	}

	private boolean digitChain(int i) {
		if (i == 1)
			return false;
		else if (i == 89)
			return true;
		else {
			return digitChain(calc(i));
		}
	}

	private int calc(int i) {
		int b = i;
		int sum = 0;
		while (b > 0) {
			int temp = b % 10;
			b /= 10;
			sum += Math.pow(temp, 2);
		}
		return sum;
	}
}