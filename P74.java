import java.util.ArrayList;

public class P74 {
	public static void main(String[] args) {
		P74 runner = new P74();
		runner.run();
		//System.out.println(runner.generate(Integer.parseInt(args[0])));
	}

	public void run() {
		int count = 0;
		for (int i = 1; i < 1000000; i++) {
			if (generate(i) == 60)
				count++;
		}
		System.out.println(count);
	}

	private int generate(int num) {
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		sequence.add(num);
		int nextNum = nextFac(sequence.get(sequence.size()-1));
		while (!sequence.contains(nextNum)) {
			sequence.add(nextNum);
			nextNum = nextFac(sequence.get(sequence.size()-1));
		}
		return sequence.size();
	}

	private int nextFac(int num) {
		int sum = 0;
		int copy = num;
		while (copy > 0) {
			int digit = copy % 10;
			copy /= 10;
			sum += factorial(digit);
		}
		return sum;
	}

	private int factorial(int num) {
		if (num <= 1)
			return 1;
		else
			return num * factorial(num-1);
	}
}