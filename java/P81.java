import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P81 {
	private int matrixSize;

	public static void main(String[] args) {
		P81 runner = new P81();
		runner.run();
	}

	public void run() {
		String filepath = "p081_matrix.txt";
		int[][] matrix = readFile(filepath);
		matrixSize = matrix.length;
		for (int i = matrix.length-1; i >= 0; i--) {
			for (int j = matrix[0].length-1; j >= 0; j--) {
				if (!corner(i, j)) {
					if (bottom(i, j)) {
						matrix[i][j] += matrix[i][j+1];
					}

					else if (side(i, j)) {
						matrix[i][j] += matrix[i+1][j];
					}

					else {
						matrix[i][j] += Math.min(matrix[i+1][j], matrix[i][j+1]);
					}
				}
			}
		}
		System.out.println(matrix[0][0]);
	}

	private boolean bottom(int i, int j) {
		return i + 1 == matrixSize;
	}

	private boolean side(int i, int j) {
		return j + 1 == matrixSize;
	}

	private boolean corner(int i, int j) {
		return i == j && j == matrixSize-1;
	}

	private int[][] readFile(String filepath) {
		ArrayList<String> rows = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String curr = "";
			while ((curr = br.readLine()) != null) {
				rows.add(curr);
			}
		}	
		catch (IOException e) {
			e.printStackTrace();
		}

		int width = rows.get(0).split(",").length;
		int[][] matrix = new int[rows.size()][width];
		for (int i = 0; i < rows.size(); i++) {
			String[] nums = rows.get(i).split(",");
			for (int j = 0; j < nums.length; j++) {
				matrix[i][j] = Integer.parseInt(nums[j]);
			}
		}
		return matrix;
	}
}