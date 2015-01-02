import java.util.Arrays;
import java.math.BigInteger;

public class P65 {
	public static void main(String[] args) {
		P65 runner = new P65();
		runner.run();
	}

	public void run() {
		Fraction frac = findFraction(99);
		System.out.println(sum(frac.frac[0]));
	}

	public int sum(BigInteger i) {
		String str = i.toString();
		int total = 0;
		for (int j = 0; j < str.length(); j++) {
			total += Integer.parseInt(str.substring(j, j+1));
		}
		return total;
	}

	public Fraction findFraction(int goal) {
		Fraction two = new Fraction(new BigInteger("2"), BigInteger.ONE);
		return two.add(recurseFrac(0, goal));
	}

	private Fraction recurseFrac(int iter, int goal) {
		if (iter == goal)
			return new Fraction(BigInteger.ZERO, BigInteger.ONE);
		if (iter % 3 == 1) {
			int base = (iter + 2) / 3 * 2;
			Fraction num = new Fraction(new BigInteger(Integer.toString(base)), BigInteger.ONE);
			return num.add(recurseFrac(iter+1, goal)).inverse();
		}
		Fraction one = new Fraction(BigInteger.ONE, BigInteger.ONE);
		return one.add(recurseFrac(iter+1, goal)).inverse();
	}

	private class Fraction {
		public BigInteger[] frac = new BigInteger[2];

		public Fraction(BigInteger num, BigInteger dem) {
			frac[0] = num;
			frac[1] = dem;
		}

		public Fraction inverse() {
			return new Fraction(frac[1], frac[0]);
		}

		public Fraction add(Fraction other) {
			BigInteger least = lcm(frac[1], other.frac[1]);
			BigInteger afactor = least.divide(frac[1]);
			BigInteger bfactor = least.divide(other.frac[1]);
			BigInteger resNum = afactor.multiply(frac[0]).add(bfactor.multiply(other.frac[0]));
			return new Fraction(resNum, least);
		}

		private BigInteger lcm(BigInteger a, BigInteger b) {
			return a.multiply(b).divide(a.gcd(b));
		}

		public String toString() {
			return frac[0].toString() + "/" + frac[1].toString();
		}
	}
}