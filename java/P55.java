import java.math.BigInteger;

public class P55 {
	public static void main(String[] args) {
		P55 runner = new P55();
		//System.out.println(runner.isLychrel(new BigInteger(args[0])));
		runner.run();
	}

	private void run() {
		int counter = 0;
		for (int i = 1; i < 10000; i++) {
			if (!isLychrel(new BigInteger(Integer.toString(i))))
				counter++;
		}
		System.out.println(counter);
	}

	private boolean isLychrel(BigInteger i) {
		return lychrelRecur(i, 0);
	}

	private boolean lychrelRecur(BigInteger i, int step) {
		if (isPal(i) && step != 0)
			return true;
		else if (step >= 50)
			return false;
		else {
			StringBuilder mirror = new StringBuilder(i.toString());
			BigInteger reversed = new BigInteger(mirror.reverse().toString());
			return lychrelRecur(i.add(reversed), step+1);
		}
	}

	private boolean isPal(BigInteger i) {
		StringBuilder test = new StringBuilder(i.toString());
        if (test.toString().equals(test.reverse().toString())) {
            return true;
        }
        return false;
	}
}