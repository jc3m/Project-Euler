import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P54 {
	public static void main(String[] args) {
		P54 runner = new P54();
		runner.run();
	}

	public void run() {
		hand[][] hands = read("p054_poker.txt");
	}

	private hand[][] read(String path) {
		BufferedReader br = null;
		String text;
		ArrayList<String> hands = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(path));
			while ((text = br.readLine()) != null) {
				hands.add(text);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		hand[][] res = new hand[hands.size()][2];

		for (int i = 0; i < hands.size(); i++) {
			String round = hands.get(i);
			String[] strs = round.split(" ");
			hand handA = new hand();
			hand handB = new hand();
			for (int j = 0; j < strs.length; j++) {
				if (j < 5)
					handA.add(new card(strs[j]));
				else
					handB.add(new card(strs[j]));
			}
			res[i][0] = handA;
			res[i][1] = handB;
		}

		return res;
	}

	private class hand {
		card[] cards;
		int size;

		public hand() {
			cards = new card[5];
			size = 0;
		}

		public void add(card c) {
			cards[size] = c;
			size++;
		}

		public void valSort() {
			for (int i = 0; i < cards.length; i++) {
				for (int j = i; j > 0; j--) {
					if (cards[j].value < cards[j-1].value)
						swap(j, j-1);
					else
						break;
				}
			}
		}

		public void suitSort() {
			for (int i = 0; i < cards.length; i++) {
				for (int j = i; j > 0; j--) {
					if (cards[j].suit < cards[j-1].suit)
						swap(j, j-1);
					else
						break;
				}
			}
		}

		private void swap(int a, int b) {
			card temp = cards[a];
			cards[a] = cards[b];
			cards[b] = temp;
		}

		public int highCard() {
			valSort();
			if (cards[0] == 1)
				return 14;
			return cards[4].value;
		}

		public boolean isFlush() {
			suitSort();
			return cards[0].suit == cards[4].suit;
		}

		public boolean isStraight() {
			valSort();
			if (cards[0].val == 1 && cards[1] == 10) {
				for (int i = 1; i < cards.length-1; i++) {
					if (cards[i+1].value - cards[i].value != 1)
						return false;
				}
				return true;
			}
			for (int i = 0; i < cards.length-1; i++) {
				if (cards[i+1].value - cards[i].value != 1)
					return false;
			}
			return true;
		}

		public boolean isStraightFlush() {
			return isStraight() && isFlush();
		}
		
		public boolean isFour() {
			valSort();
			boolean firstFour = true;;
			for (int i = 1; i < 4; i++) {
				if (cards[i].val != cards[0].val)
					firstFour = false;
			}
			if (firstFour)
				return true;
			for (int i = 1; i < 3; i++) {
				if (cards[i].val != cards[4].val)
					return false;
			}
			return true;
		}

		public boolean isFullHouse() {
			valSort();
			boolean a1 = cards[0] == cards[1] && cards[2] == cards[3] && cards[3] == cards[4];
			boolean a2 = cards[0] == cards[1] && cards[1] == cards[2] && cards[3] == cards[4];
			return a1 || a2;
		}

		public boolean isThree() {
			valSort()
			for (int i = 0; i < 2; i++) {
				if (cards[i] == cards[i+1] && cards[i] == cards[i+2])
					return true;
			}
			return false;
		}

		public boolean isTwoPairs() {
			valSort();
			boolean a1, a2, a3;
			a1 = cards[0] == cards[1] && cards[2] == cards[3];
			a2 = cards[0] == cards[1] && cards[3] == cards[4];
			a3 = cards[1] == cards[2] && cards[3] == cards[4];
			return a1 || a2 || a3;
		}

		public boolean isPair() {
			valSort()
			for (int i = 0; i < 3; i++) {
				if (cards[i] == cards[i+1])
					return true;
			}
			return false;
		}
	}

	private class card implements Comparator {
		char suit;
		int value;

		public card(String val) {
			String num = val.substring(0,1);
			suit = val.toLowerCase().charAt(1);
			try {
				value = Integer.parseInt(num);
			} catch (Exception e) {
				if (num.equals("A"))
					value = 1;
				else if (num.equals("T"))
					value = 10;
				else if (num.equals("J"))
					value = 11;
				else if (num.equals("Q"))
					value = 12;
				else
					value = 13;
			}
		}

		public int compare(Object other) {
			return this.value - ((card)other).value;
		}
	}
}