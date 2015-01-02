public class P71 {
	public static void main(String[] args) {
		P71 runner = new P71();
		runner.run();
	}

	public void run() {
		double goal = 3.0/7.0;
		double minNum = -1;
		double minDem = -1;
		double minDev = 100000;
		for (double i = 1; i <= 1000000 * goal; i++) {
			for (double j = (int)((i-1)/goal); j <= (i+1)/goal; j++) {
				double dev = goal - i/j;
				if (dev < minDev && dev > 0) {
					minDev = dev;
					minNum = i;
					minDem = j;
				}
			}
		}
		System.out.println(minNum + "/" + minDem);
	}
}