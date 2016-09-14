import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class P89 {

	private static int[] numbers = { 1000,  900,  500,  400,  100,   90,  
		50,   40,   10,    9,    5,    4,    1 };

	private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
		"L",  "XL",  "X",  "IX", "V",  "IV", "I" };

	public static void main(String[] args) {
		P89 runner = new P89();
		runner.run();
	}

	public void run() {
		String filepath = "p089_roman.txt";
		ArrayList<String> nums = readNums(filepath);
		int oldTotal = 0;
		int newTotal = 0;
		for (int i = 0; i < nums.size(); i++) {
			String str = nums.get(i);
			oldTotal += str.length();
			newTotal += decimalToRoman(romanToDecimal(str)).length();
		}
		System.out.println(oldTotal - newTotal);
	}

	public int romanToDecimal(java.lang.String romanNumber) {
		int decimal = 0;
		int lastNumber = 0;
		String romanNumeral = romanNumber.toUpperCase();
		/* operation to be performed on upper cases even if user enters roman values in lower case chars */
		for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
			char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
				case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

				case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

				case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

				case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;

				case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;

				case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				lastNumber = 5;
				break;

				case 'I':
				decimal = processDecimal(1, lastNumber, decimal);
				lastNumber = 1;
				break;
			}
		}
		return decimal;
	}

	public int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}

	private ArrayList<String> readNums(String filepath) {
		BufferedReader br;
		String current;
		ArrayList<String> nums = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((current = br.readLine()) != null) {
				nums.add(current);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nums;
	}

	public String decimalToRoman(int num) {
        String roman = "";  // The roman numeral.
        int N = num;        // N represents the part of num that still has
                            //   to be converted to Roman numeral representation.
        for (int i = 0; i < numbers.length; i++) {
            while (N >= numbers[i]) {
            	roman += letters[i];
            	N -= numbers[i];
            }
        }
        return roman;
    }
}