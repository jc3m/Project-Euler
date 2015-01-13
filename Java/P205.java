public class P205 {
	public static void main(String[] args) {
		P205 runner = new P205();
		runner.run();
	}

	public void run() {
		long z = 100000000;
		double pete = 0;
		for (long i = 0; i < z; i++) {
			if (peteWin()) 
				pete++;
		}
		System.out.println(pete/(double)z);
	}

	private boolean peteWin() {
		int peteTotal = 0;
		int colinTotal = 0;
		for (int i = 0; i < 9; i++) {
			peteTotal += 1 + (int)(Math.random() * 4);
		}

		for (int i = 0; i < 6; i++) {
			colinTotal += 1 + (int)(Math.random() * 6);
		}

		return peteTotal > colinTotal;
	}
}