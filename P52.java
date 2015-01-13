import java.util.Arrays;

public class P52 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		P52 runner = new P52();
		System.out.println(runner.run());
		long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime + "\t");
	}

	private int run() {
		int counter = 100000;
		while (!isPermutation(counter)) {
			counter++;
		}
		return counter;
	}

	private boolean isPermutation(int counter) {
		int[] base = hashDigits(counter);
		for (int i = 2; i <= 6; i++) {
			if(!Arrays.equals(base, hashDigits(i*counter)))
				return false;
		}
		return true;
	}

	private int[] hashDigits(int num) {
		int[] res = new int[10];
		int x = num;
		while (x > 0) {
			res[x%10]++;
			x /= 10;
		}
		return res;
	}
}