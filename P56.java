import java.math.BigInteger;

public class P56 {
	public static void main(String[] args) {
		P56 runner = new P56();
		System.out.println(runner.run());
	}

	public int run() {
		int max = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				int temp = sum(i, j);
				if (temp > max)
					max = temp;
			}
		}
		return max;
	}

	private int sum(int i, int j) {
		BigInteger a = new BigInteger(Integer.toString(i));
		//BigInteger b = new BigInteger(Integer.toString(j));
		BigInteger res = a.pow(j);
		char[] carr = res.toString().toCharArray();
		int[] iarr = new int[carr.length];
		for (int k = 0; k < carr.length; k++) {
			iarr[k] = Integer.parseInt(Character.toString(carr[k]));
		}
		int total = 0;
		for (int k = 0; k < iarr.length; k++) {
			total += iarr[k];
		}
		return total;
	}
}