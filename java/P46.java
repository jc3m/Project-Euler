public class P46 {
	public static void main(String[] args) {
		P46 runner = new P46();
        System.out.println(runner.run());
	}

	private int run() {
		int counter = 9;
		while(!isSolution(counter)) {
			counter += 2;
		}
		return counter;
	}

	private boolean isSolution(int counter) {
		if(isPrime(counter))
			return false;
        for (int i = 2; i < counter; i++) {
        	if (isPrime(i) && testSquare(counter, i)) {
                return false;
        	}
        }
        return true;
	}

	private boolean testSquare(int counter, int prime) {
        double test = (double) (counter - prime) / 2;
        return Math.sqrt(test) == (double) (int) Math.sqrt(test);
	}

	private boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        else {
            for (int i = 5; i < Math.sqrt(n) + 1; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
	}
}