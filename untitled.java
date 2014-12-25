public class test {
	public static void main(String[] args) {
		test runner = new test();
		runner.run();
	}

	public void runner() {
		getLength(12345);
		/*int counter = 0;
		for (int i = 1; i < 100) {
			if (isExponent(i))
				counter++;
		}*/
	}

	private int getLength(int i) {
		return Integer.toString(i).length();
	}
}