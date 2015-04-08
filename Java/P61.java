import java.util.ArrayList;
import java.util.LinkedList;

//Use Tarjan's Algorithm

public class P61 {
	public static void main(String[] args) {
		P61 runner = new P61();
		runner.run();
	}

	public void run() {
		int[] triangles = toIntArray(fourDigitTriangle());
		int[] squares = toIntArray(fourDigitSquare());
		int[] pents = toIntArray(fourDigitPent());
		int[] hex = toIntArray(fourDigitHex());
		int[] hept = toIntArray(fourDigitHept());
		int[] oct = toIntArray(fourDigitOct());
	}

	public int[] toIntArray(ArrayList<Integer> arr) {
		int[] res = new int[arr.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = arr.get(i);
		}
		return res;
	}

	public ArrayList<Integer> fourDigitTriangle() {
		ArrayList<Integer> triangles = new ArrayList<Integer>(); 
		for (int i = 1; ; i++) {
			if (generateTriangle(i) > 9999) {
				break;
			}
			if (generateTriangle(i) >= 1000)
				triangles.add(i);
		}
		return triangles;
	}

	public ArrayList<Integer> fourDigitSquare() {
		ArrayList<Integer> nums = new ArrayList<Integer>(); 
		for (int i = 1; ; i++) {
			if (generateSquare(i) > 9999) {
				break;
			}
			if (generateSquare(i) >= 1000)
				nums.add(i);
		}
		return nums;
	}

	public ArrayList<Integer> fourDigitPent() {
		ArrayList<Integer> nums = new ArrayList<Integer>(); 
		for (int i = 1; ; i++) {
			if (generatePent(i) > 9999) {
				break;
			}
			if (generatePent(i) >= 1000)
				nums.add(i);
		}
		return nums;
	}

	public ArrayList<Integer> fourDigitHex() {
		ArrayList<Integer> nums = new ArrayList<Integer>(); 
		for (int i = 1; ; i++) {
			if (generateHex(i) > 9999) {
				break;
			}
			if (generateHex(i) >= 1000)
				nums.add(i);
		}
		return nums;
	}

	public ArrayList<Integer> fourDigitHept() {
		ArrayList<Integer> nums = new ArrayList<Integer>(); 
		for (int i = 1; ; i++) {
			if (generateHept(i) > 9999) {
				break;
			}
			if (generateHept(i) >= 1000)
				nums.add(i);
		}
		return nums;
	}

	public ArrayList<Integer> fourDigitOct() {
		ArrayList<Integer> nums = new ArrayList<Integer>(); 
		for (int i = 1; ; i++) {
			if (generateOct(i) > 9999) {
				break;
			}
			if (generateOct(i) >= 1000)
				nums.add(i);
		}
		return nums;
	}

	public int generateTriangle(int n) {
		return n * (n + 1) / 2;
	}

	public int generateSquare(int n) {
		return n * n;
	}

	public int generatePent(int n) {
		return n * ((3 * n) - 1) / 2;
	}

	public int generateHex(int n) {
		return n * (2 * n - 1);
	}

	public int generateHept(int n) {
		return n * ((5 * n) - 3) /  2;
	}

	public int generateOct(int n) {
		return n * ((3 * n) - 2);
	}
}