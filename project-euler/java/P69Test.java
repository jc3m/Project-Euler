import java.util.Arrays;

public class P69Test {
	public static void main(String[] args) {
		P69Test runner = new P69Test();
		runner.run();
	}

	public void run() {
		double max = 0;
		double bestNum = -1;
		for (int i = 2; ; i++) {
			System.out.println(i * 30030);
			if (30030 * i > 1000000) {
				System.out.println(bestNum);
				break;
			}
			if (max < (double)(i*30030)/(double)totient(i*30030)) {
				max = (double)(i*30030)/(double)totient(i*30030);
				bestNum = i*30030;
			}
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