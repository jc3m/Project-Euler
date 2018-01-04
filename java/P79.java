import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class P79 {
	public static void main(String[] args) {
		P79 runner = new P79();
		runner.run();
	}

	public void run() {
		ArrayList[] list = analyze();
		for (int i = 0; i < list.length; i++) {
			System.out.print(i + ": ");
			System.out.println(Arrays.toString(list[i].toArray()));
		}
	}

	private ArrayList[] analyze() {
		ArrayList<String> codes = readFiles();
		ArrayList<String> pairs = new ArrayList<String>();
		for (int i = 0; i < codes.size(); i++) {
			String curr = codes.get(i);
			char[] arr = curr.toCharArray();
			String[] strs = new String[3];
			strs[0] = Character.toString(arr[0]) + Character.toString(arr[1]);
			strs[1] = Character.toString(arr[0]) + Character.toString(arr[2]);
			strs[2] = Character.toString(arr[1]) + Character.toString(arr[2]);
			for (int j = 0; j < strs.length; j++) {
				if (!pairs.contains(strs[j]))
					pairs.add(strs[j]);
			}
		}

		ArrayList[] hashes = new ArrayList[10];

		for (int i = 0; i < hashes.length; i++) {
			hashes[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < pairs.size(); i++) {
			int ind = Integer.parseInt(pairs.get(i).substring(0, 1));
			int val = Integer.parseInt(pairs.get(i).substring(1, 2));
			hashes[ind].add(val);
		}

		return hashes;
	}

	private ArrayList<String> readFiles() {
		ArrayList<String> res = new ArrayList();
		BufferedReader br = null;
		try {
			String sCurrentLine;

			File keys = new File("p079_keylog.txt");
			br = new BufferedReader(new FileReader(keys));

			while ((sCurrentLine = br.readLine()) != null) {
				if (!res.contains(sCurrentLine))
					res.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return res;
	}
}