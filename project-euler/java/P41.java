public class P41 {
    public static void main(String[] args) {
        P41 runner = new P41();
        runner.run();
        //System.out.println(runner.run());
    }

    private int run() {
    	for (int i = 987654321; i > 0; i--) {
    		if (isPan(i) && testPrime(i)) {
    			System.out.println(i);
    			return 0;
    		}
    	}
    	return -1;
    }

    private int getLength(int i) {
    	int a = i;
    	int counter = 1;
    	while (a > 10) {
            a /= 10;
            counter++;
    	}
    	return counter;
    }

    private boolean isPan(int num) {
    	int copy = num;
    	int length = getLength(num);
    	boolean[] arr = new boolean[length];
    	for (int i = 0; i < length; i++){
    	    if (num%10 == 0 || num%10 > length) return false;
    		arr[num%10-1] = true;
    		num /= 10;
    	}

    	for (int i = 0; i < arr.length; i++)
    		if (arr[i] == false) return false;
    	return true;
    }

    private boolean testPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        else {
            for (int i = 5; i < Math.sqrt(n) + 1; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
	}
}