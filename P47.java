import java.util.ArrayList;

public class P47 {
	public static void main(String[] args) {
		P47 runner = new P47();
		//System.out.println(runner.isDistinct(646, 3));
		System.out.println(runner.run());
	}

	public long run() {
		long counter = 2;
		while (!isConsecutive(counter)) {
			if (counter % 1000 == 0)
				System.out.println("Counter: " + counter);
			counter++;
		}
		return counter;
	}

	private boolean isConsecutive(long counter) {
		for (long i = counter; i < counter + 4; i++) {
			if (!isDistinct(i, 4)) {
				return false;
			}
		}
		return true;
	}

	private boolean isDistinct(long i, int min) {
		long hold = i;
		ArrayList<Long> bucket = new ArrayList<Long>();
		long counter = 2;
		while (counter <= hold) {
			if (hold % counter == 0) {
				if (!bucket.contains(counter))
					bucket.add(counter);
				hold /= counter;
			}
			else
				counter++;
		}
		return bucket.size() >= min;
	}
}