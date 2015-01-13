import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P54 {
	public static void main(String[] args) {
		P54 runner = new P54();
		//runner.test(args[0]);
		runner.run();
	}

	public void test(String str) {
		String round = str;
		String[] strs = round.split(" ");
		hand handA = new hand();
		hand handB = new hand();
		for (int j = 0; j < strs.length; j++) {
			if (j < 5)
				handA.add(new card(strs[j]));
			else
				handB.add(new card(strs[j]));
		}
		System.out.println("Player 1 score: " + handA.score());
		System.out.println("Player 2 score: " + handB.score());
		System.out.println("Hand1 Sorted: " + Arrays.toString(handA.cards));
		System.out.println("Hand2 Sorted: " + Arrays.toString(handB.cards));
	}

	public void run() {
		int counter = 0;
		hand[][] hands = read("p054_poker.txt");
		for (int i = 0; i < hands.length; i++) {
			if (hands[i][0].score() == hands[i][1].score()) {
				System.out.println(hands[i][0].score() + " at line: " + i);
				System.out.print(Arrays.toString(hands[i][0].cards) + Arrays.toString(hands[i][1].cards) + " - With winner: ");
				if (hands[i][0].beats(hands[i][1])) {
					System.out.println("player 1");
					counter++;
				}
				else
					System.out.println("player 2");
			}
			if (hands[i][0].score() > hands[i][1].score())
				counter++;
		}
		System.out.println(counter);
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
		int highCard;

		public hand() {
			cards = new card[5];
			size = 0;
		}

		public void add(card c) {
			cards[size] = c;
			size++;
		}

		public double score() {
			double score = 0;

			if (isStraightFlush()) {
				//System.out.println("Straing Flush");
				score = 8;
			}

			else if (isFour()) {
				//System.out.println("Four of a kind");
				score = 7;
			}

			else if (isFullHouse()) {
				//System.out.println("Full House");
				score = 6;
			}

			else if (isFlush()) {
				//System.out.println("Flush");
				score = 5;
			}

			else if (isStraight()) {
				//System.out.println("Straight");
				score = 4;
			}

			else if (isThree()) {
				//System.out.println("Three of a kind");
				score = 3;
			}

			else if (isTwoPairs()) {
				//System.out.println("Two Pairs");
				score = 2;
			}

			else if (isPair()) {
				//System.out.println("Pair");
				score = 1;
			}

			score += (double)highCard() / 14.0;
			return score;
		}

		private int checkAce(int num) {
			if (num == 1)
				return 14;
			return num;
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
			if (cards[0].value == 1)
				return 14;
			return cards[4].value;
		}

		public boolean isFlush() {
			suitSort();
			boolean flush = cards[0].suit == cards[4].suit;
			highCard = highCard();
			return flush;
		}

		public boolean isStraight() {
			valSort();
			if (cards[0].value == 1 && cards[1].value == 10) {
				for (int i = 1; i < cards.length-1; i++) {
					if (cards[i+1].value - cards[i].value != 1)
						return false;
				}
				highCard = 14;
				return true;
			}
			for (int i = 0; i < cards.length-1; i++) {
				if (cards[i+1].value - cards[i].value != 1)
					return false;
			}
			highCard = highCard();
			return true;
		}

		public boolean isStraightFlush() {
			return isStraight() && isFlush();
		}
		
		public boolean isFour() {
			valSort();
			boolean firstFour = true;;
			for (int i = 1; i < 4; i++) {
				if (cards[i].value != cards[0].value)
					firstFour = false;
			}
			if (firstFour) {
				highCard = checkAce(cards[2].value);
				return true;
			}
			for (int i = 1; i < 3; i++) {
				if (cards[i].value != cards[4].value)
					return false;
			}
			highCard = checkAce(cards[2].value);
			return true;
		}

		public boolean isFullHouse() {
			valSort();
			boolean a1 = cards[0].value == cards[1].value && cards[2].value == cards[3].value && cards[3].value == cards[4].value;
			boolean a2 = cards[0].value == cards[1].value && cards[1].value == cards[2].value && cards[3].value == cards[4].value;
			highCard = checkAce(cards[2].value);
			return a1 || a2;
		}

		public boolean isThree() {
			valSort();
			for (int i = 0; i < 2; i++) {
				if (cards[i].value == cards[i+1].value && cards[i].value == cards[i+2].value) {
					highCard = checkAce(cards[i].value);
					return true;
				}
			}
			return false;
		}

		public boolean isTwoPairs() {
			valSort();
			boolean a1, a2, a3;
			a1 = cards[0].value == cards[1].value && cards[2].value == cards[3].value;
			a2 = cards[0].value == cards[1].value && cards[3].value == cards[4].value;
			a3 = cards[1].value == cards[2].value && cards[3].value == cards[4].value;
			highCard = checkAce(cards[3].value);
			if (cards[1].value == 1)
				highCard = 14;
			return a1 || a2 || a3;
		}

		public boolean isPair() {
			valSort();
			for (int i = 0; i < 3; i++) {
				if (cards[i].value == cards[i+1].value) {
					highCard = checkAce(cards[i].value);
					return true;
				}
			}
			return false;
		}

		public boolean beats(hand other) {
			for (int i = 4; i >= 0; i--) {
				if (other.cards[i].value > cards[i].value)
					return false;
				if (cards[i].value > other.cards[i].value)
					return true;
			}
			System.out.println("break");
			return false;
		}
	}

	private class card{
		char suit;
		int value;
		String orig;

		public card(String val) {
			orig = val;
			String num = val.substring(0,1);
			suit = val.toLowerCase().charAt(1);
			if (num.equals("A"))
				value = 1;
			else if (num.equals("T"))
				value = 10;
			else if (num.equals("J"))
				value = 11;
			else if (num.equals("Q"))
				value = 12;
			else if (num.equals("K"))
				value = 13;
			else
				value = Integer.parseInt(num);
		}

		public String toString() {
			return orig;
		}
	}
}