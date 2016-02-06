import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P49 {
	ArrayList<Integer> primes;
	ArrayList<String> permutations;
	public static void main(String[] args) {
		P49 runner = new P49();
		runner.run();
	}

	public void run() {
		primes = new ArrayList<Integer>();
		permutations = new ArrayList<String>();
		generate();
		for (int i = 1000; i <= 9999; i++) {
			if (testNum(i)) {
				System.out.println(i);
			}
		}
	}

	private boolean testNum(int i) {
		int[] arr = strToInt(i);
		//System.out.println(Arrays.toString(arr));
		permute(arr, 4);
		//System.out.println(Arrays.toString(permutations.toArray()));
		ArrayList<Integer> tester = new ArrayList<Integer>();
		for (int j = 0; j < permutations.size(); j++) {
			int temp = Integer.parseInt(permutations.get(j));
			if (primes.contains(temp) && temp >= i)
				tester.add(temp);
		}
		if (tester.size() < 3) {
			//System.out.println("Failed size test!");
			return false;
		}
		Collections.sort(tester);
		//System.out.println(Arrays.toString(tester.toArray()));
		int counter = 0;
		for (int k = 0; k < tester.size(); k++) {
			for (int j = k + 1; j < tester.size(); j++) {
				int search = 2 * tester.get(j) - tester.get(k);
				if (tester.contains(search) && tester.get(j) - tester.get(k) != 0) {
					System.out.println(Arrays.toString(tester.toArray()));
					System.out.println(Integer.toString(tester.get(k)) + Integer.toString(tester.get(j))
						 + Integer.toString(search));
					return true;
				}
			}
		}
		return false;
	}

	private int[] strToInt(int i) {
		char[] charArr = Integer.toString(i).toCharArray();
		int[] res = new int[charArr.length];
		for (int j = 0; j < charArr.length; j++) {
			res[j] = Integer.parseInt(Character.toString(charArr[j]));
		}
		return res;
	}

	private static void swap(int[] v, int i, int j) {
		int t = v[i]; v[i] = v[j]; v[j] = t;
	}

	private String arrToStr(int[] v) {
		String str = "";
		for (int i = 0; i < v.length; i++) {
			str += Integer.toString(v[i]);
		}
		return str;
	}

	private void permute(int[] v, int n) {
		permutations.clear();
		perm(v, n);
	}
 
	private void perm(int[] v, int n) {
		if (n == 1) {
			String str = arrToStr(v);
			//System.out.println(str);
			permutations.add(str);
		} else {
			for (int i = 0; i < n; i++) {
				perm(v, n-1);
				if (n % 2 == 1) {
					swap(v, 0, n-1);
				} else {
					swap(v, i, n-1);
				}
			}
		}
	}

	private void generate() {
		for (int i = 1000; i < 10000; i++) {
			if (isPrime(i))
				primes.add(i);
		}
	}

	private static boolean isPrime(int n) {
    	if (n <= 3) {
        	return n > 1;
    	} else if (n % 2 == 0 || n % 3 == 0) {
    	    return false;
    	} else {
    	    for (int i = 5; i * i <= n; i += 6) {
    	        if (n % i == 0 || n % (i + 2) == 0) {
    	            return false;
    	        }
    	    }
    	    return true;
    	}
	}
}