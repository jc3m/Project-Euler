public class P206 {
	public static void main(String[] args) {
		P206 runner = new P206();
		runner.run();
	}

	public void run() {
		long min = 1010101010; // ~sqrt(1020304050607080900)
		long max = 1389026630; // ~sqrt(1929394959697989990)
		for (long i = min; i <= max; i += 10) {
			if (hasForm(i)) {
				System.out.println(i);
				return;
			}
		}
	}

	private boolean hasForm(long j) {
		long sqr = j * j;
		char[] chars = Long.toString(sqr).toCharArray();
		int[] digits = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			digits[i] = Integer.parseInt(Character.toString(chars[i]));
		}
		for (int i = 1; i < 10; i++) {
			if (digits[(i-1)*2] != i)
				return false;
		}
		return digits[18] == 0;
	}
}