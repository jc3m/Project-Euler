public class P85 {
	public static void main(String[] args) {
		P85 runner = new P85();
		runner.run(Integer.parseInt(args[0]));
	}

	public void run(int z) {
		int goal = z;
		int minDev = Integer.MAX_VALUE;
		int minM = -1;
		int minN = -1;

		for (int m = 1; m < goal; m++) {
			for (int n = m; n < goal/m; n++) {
				int dev = Math.abs(calc(m, n) - goal);
				if (dev < minDev) {
					minDev = dev;
					minM = m;
					minN = n;
				}
			}
		}
		System.out.println("Rectangles: " + calc(minM, minN) + ", Area: " + minM * minN + ", M: " + minM + ", N: "+ minN);
	}

	private int calc(int m, int n) {
		return m * (m + 1) * n * (n + 1) / 4;
	}
}