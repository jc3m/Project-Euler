import java.util.Arrays;
import java.math.BigInteger;

public class P57 {
	public static void main(String[] args) {
		P57 runner = new P57();
		runner.run();
	}

	public void run() {
		int counter = 0;
		for (int j = 1; j <= 1000; j++) {
			if (greaterNum(j))
				counter++;
		}
		System.out.println(counter);
	}

	private boolean greaterNum(int iter) {
		Fraction test = findFraction(iter);
		return test.frac[0].toString().length() > test.frac[1].toString().length();
	}

	public Fraction findFraction(int iter) {
		Fraction one = new Fraction(BigInteger.ONE, BigInteger.ONE);
		return one.add(recurseFrac(iter));
	}

	private Fraction recurseFrac(int iter) {
		if (iter == 1)
			return new Fraction(BigInteger.ONE, new BigInteger("2"));
		Fraction two = new Fraction(new BigInteger("2"), BigInteger.ONE);
		return two.add(recurseFrac(iter-1)).inverse();
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
			return frac[0].toString() + ", " + frac[1].toString();
		}
	}
}