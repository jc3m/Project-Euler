import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class P59 {
	public static void main(String[] args) {
		P59 runner = new P59();
		runner.run();
	}

	public void run() {
		String text = readText(new File("p059_cipher.txt"));
		String[] vals = text.split(",");
		int[] dec = new int[vals.length];
		for (int i = 0; i < vals.length; i++) {
			dec[i] = Integer.parseInt(vals[i]);
		}

		String looped = convertToString(dec);
		ArrayList<String> block = blocks(looped, 3);
		ArrayList<String> ress = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			ress.add(findLoop(block.get(i)));
		}

		String finalStr = stitch(ress);
		char[] last = finalStr.toCharArray();
		System.out.println(finalStr);

		int total = 0;
		for (int i = 0; i < last.length; i++) {
			total += (int)(last[i]);
		}
		System.out.println(total);
	}

	public String stitch(ArrayList<String> arr) {
		int total = arr.get(0).length() + arr.get(1).length() + arr.get(2).length();
		String res = "";
		for (int i = 0; i < total; i++) {
			res += arr.get(i%3).substring(i/3, i/3+1);
		}
		return res;
	}

	public String findLoop(String str) {
		ArrayList<String> phrases = new ArrayList<String>();
		for (int i = 'a'; i <= 'z'; i++) {
			String plain = test((char)i, str);
			phrases.add(plain);
		}
		return best(phrases);
	}

	public String convertToString(int[] arr) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			res.append((char)arr[i]);
		}
		return res.toString();
	}

	public static ArrayList<String> blocks(String text, int keysize) {
		ArrayList<StringBuilder> sbs = new ArrayList<StringBuilder>();
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < keysize; i++) {
			sbs.add(new StringBuilder());
		}

		for (int i = 0; i < text.length(); i++) {
			int ind = i % keysize;
			sbs.get(ind).append(text.substring(i, i+1));
		}
		for (int i = 0; i < sbs.size(); i++) {
			res.add(sbs.get(i).toString());
		}
		return res;
	}

	public String readText(File text) {
		String res = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(text));
			String cipher;
			while ((cipher = br.readLine()) != null) {
				res += cipher;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	private String test(char key, String str) {
		StringBuilder sb = new StringBuilder();
		char[] cipher = str.toCharArray();
		for (int i = 0; i < cipher.length; i++) {
			int temp = (int)cipher[i] ^ (int)key;
			sb.append((char)temp);
		}
		return sb.toString();
	}

	private String best(ArrayList<String> list) {
		int bestScore = 0;
		int bestInd = -1;
		for (int i = 0; i < list.size(); i++) {
			if (score(list.get(i)) > bestScore) {
				bestScore = score(list.get(i));
				bestInd = i;
			}
		}
		return list.get(bestInd);
	}

	private int score(String str) {
		char[] common = {' ','e','t','a','o','i','n','s','h','r','d','l','u'};
		char[] phrase = str.toLowerCase().toCharArray();
		int res = 0;
		for (int i = 0; i < phrase.length; i++) {
			for (int j = 0; j < common.length; j++) {
				if (common[j] == phrase[i]) {
					res += (common.length - j)/5 + 1;
				}
			}
			if ((int)phrase[i] < 32)
				res -= 5;
		}
		return res;
	}
}