public class P112 {
	public static void main(String[] args) {
		P112 runner = new P112();
		runner.run();
		//System.out.println(runner.isBouncy((double)Integer.parseInt(args[0])));
	}

	public void run() {
		double bouncy = 0;
		double total = 100;
		while (bouncy/total < 0.99) {
			if (isBouncy(++total))
				bouncy++;
		}
		System.out.println("Bouncy: " + bouncy + ", Total: " + total);
	}

	public boolean isBouncy(double num) {
		return !increasing(num) && !decreasing(num);
	}

	public boolean increasing(double num) {
		char[] chars = Integer.toString((int)num).toCharArray();
		int[] digits = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			digits[i] = Integer.parseInt(Character.toString(chars[i]));
		}
		for (int i = 0; i < digits.length-1; i++) {
			if (digits[i] > digits[i+1])
				return false;
		}
		return true;
	}

	public boolean decreasing(double num) {
		char[] chars = Integer.toString((int)num).toCharArray();
		int[] digits = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			digits[i] = Integer.parseInt(Character.toString(chars[i]));
		}
		for (int i = 0; i < digits.length-1; i++) {
			if (digits[i] < digits[i+1])
				return false;
		}
		return true;
	}
}