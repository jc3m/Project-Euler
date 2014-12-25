public class test {
	public static void main(String[] args) {
		test runner = new test();
		runner.run(Integer.parseInt(args[0]));
	}

	public void run(int i) {
		System.out.println(isExponent(i));
		/*int counter = 0;
		for (int i = 1; i < 10) {
			if (isExponent(i))
				counter++;
		}*/
	}

	private boolean isExponent(int num) {
		int counter = 1;
		for (int i = 1; ; i++) {
			int val = (int)Math.pow(num, i);
			if (getLength(val) > i)
				return false;
			if (getLength(val) == i)
				return true;
		}
	}

	private int getLength(int i) {
		return Integer.toString(i).length();
	}
}