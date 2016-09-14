import java.math.BigInteger;

public class P63 {
	public static void main(String[] args) {
		P63 runner = new P63();
		runner.run();
	}

	public void run() {
		int count = 0;
		for (int i = 1; i < 10; i++) {
			count += test(i);
		}
		System.out.println(count);
	}

	private int test(int num) {
		int counter = 0;
		for (int i = 1; ; i++) {
			int len = powLen(num, i);
			if (len == i)
				counter++;
			else
				break;
		}
		return counter;
	}

	private int powLen(int num, int exp) {
		BigInteger big = new BigInteger(Integer.toString(num));
		return big.pow(exp).toString().length();
	}
}