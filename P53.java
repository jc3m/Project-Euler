import java.math.BigInteger;

public class P53 {
	public static void main(String[] args) {
		P53 runner = new P53();
		System.out.println(runner.run());
		//System.out.println(runner.run());
	}

	public int run() {
		int total = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j < i; j++) {
				BigInteger temp = combination(i, j);
        		if (temp.compareTo(new BigInteger("1000000")) > 0) {
        			total++;
        		}
			}
		}
		return total;
	}

	private BigInteger combination(int n, int r) {
		//System.out.println("r: " + r + " n: " + n);
		BigInteger R = new BigInteger(Integer.toString(r));
		BigInteger N = new BigInteger(Integer.toString(n));
		BigInteger P = new BigInteger(Integer.toString(n-r));

        return fac(N).divide(fac(R).multiply(fac(P)));
	}

	private BigInteger fac(BigInteger n) {
		if (n.compareTo(new BigInteger("1")) <= 0)
			return new BigInteger("1");
		return n.multiply(fac(n.subtract(new BigInteger("1"))));
	}
}