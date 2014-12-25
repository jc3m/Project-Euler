import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class P99 {
	public static void main(String[] args) {
		P99 runner = new P99();
		runner.run();
	}

	public void run() {
		ArrayList<String> pairs = new ArrayList<String>();
		BufferedReader br = null;
		try {
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("p099_base_exp.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				pairs.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		String[][] strVals = new String[pairs.size()][2];
		for (int i = 0; i < pairs.size(); i++) {
			strVals[i] = pairs.get(i).split(",");
		}

		double[] results = new double[strVals.length];
		for (int i = 0; i < results.length; i++) {
			results[i] = (double)Integer.parseInt(strVals[i][1]) * Math.log(Integer.parseInt(strVals[i][0]));
		}

		double maxVal = 0;
		double maxInd = -1;
		for (int i = 0; i < results.length; i++) {
			if (results[i] > maxVal) {
				maxVal = results[i];
				maxInd = i+1;
			}
		}
		System.out.println(maxInd);
	}
}