import java.util.Arrays;

public class P43 {
    long total = 0;

	public static void main(String[] args) {
		P43 runner = new P43();
		int[] temp = {4,6,0,1,3,5,7,2,8,9};
		//System.out.println(runner.convert(temp));
		runner.run();
	}

	public void run() {
		int[] v = {0,1,2,3,4,5,6,7,8,9};
		permute(v, 10);
		System.out.println(total);
	}

	private static void swap(int[] v, int i, int j) {
		int t = v[i];
		v[i] = v[j];
		v[j] = t;
	}
 
	public void permute(int[] v, int n) {
		if (n == 1) {
			if(subTest(v)) {
				System.out.println(convert(v));
				total += convert(v);
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				permute(v, n-1);
				if (n % 2 == 1) {
					swap(v, 0, n-1);
				}
				else {
					swap(v, i, n-1);
				}
			}
		}
	}

	private long convert(int[] v) {
		long total = 0;
		for (int i = v.length-1; i >= 0; i--) {
            total += Math.pow(10, v.length-i-1) * v[i];
		}
		return total;
	}
    
    private boolean subTest(int[] v) {
        int[] testVals = {2, 3, 5, 7, 11, 13 ,17};
        for (int i = 0; i < testVals.length; i++) {
        	if (compute(v, i+1) % testVals[i] != 0) return false;
        }
        return true;
    }

    private int compute(int[] v, int i) {
        return v[i] * 100 + v[i+1] * 10 + v[i+2];
    }
}