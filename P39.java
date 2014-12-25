public class P39 {
	public static void main(String[] args) {
		P39 runner = new P39();
		//System.out.println(runner.checkRight(30, 40, 120));
		//runner.tryRight(120);
		System.out.println(runner.run());
	}

	public int run() {
		int max = 0;
		int p = -1;
		for (int i = 12; i < 1000; i++) {
			int tries = tryRight(i);
			if(tries > max) {
				max = tries;
				p = i;
			}
		}
		return p;
	}

	private int tryRight(int perim) {
		int total = 0;
		for (int i = 1; i <= perim/2; i++) {
			for (int j = i; j <= perim/2; j++) {
				if(checkRight(i, j, perim)) {
					//System.out.println(i + ", " + j);
					total++;
				}
			}
		}
		return total;
	}

    private boolean checkRight(int i, int j, int perim) {
    	int k = perim - i - j;
    	if (i*i + j*j == k * k)
    		return true;
    	return false;
    }
}