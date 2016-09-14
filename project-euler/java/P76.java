public class P76 {
	int counts = 0;

	public static void main(String[] args) {
		P76 runner = new P76();
		runner.run();
	}

	public void run() {
		partition(100);
		System.out.println(counts-1);
	}

	private void partition(int n) {
		partition(n, n);
	}

	private void partition(int n, int max) {
		if (n == 0) {
			counts++;
			return;
		}

		for (int i = Math.min(max, n); i >= 1; i--) {
			partition(n-i, i);
		}
	}
}