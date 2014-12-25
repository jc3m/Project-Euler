public class P38 {
	public static void main(String[] args) {
	    P38 obj = new P38();
	    //String str = "112346789";
	    //System.out.println(str.substring(0,1));
	    //System.out.println(obj.isPan(str));
	    obj.run();
	}

	//largest n = 9876
    private int run() {
    	int max = 0;
    	for (int i = 1; i < 9876; i++) {
    		int res = testPan(i);
    		if(res > max) {
    			max = res;
    		}
    	}
    	System.out.println(max);
    	return max;
    }

    private int testPan(int i) {
    	int length = 0;
    	int counter = 1;
        while (length < 9) {
            length += getLength(i*counter);
            counter++;
        }
        if (length != 9) return -1;
        String res = "";
        for (int k = 1; k < counter; k++) {
        	res += Integer.toString(i*k);
        }
        if(!isPan(res)) return -1;
        return Integer.parseInt(res);
    }

    private boolean isPan(String str) {
    	boolean[] arr = new boolean[9];
    	for (int i = 0; i < 9; i++){
    	    if (Integer.parseInt(str.substring(i, i+1)) == 0) return false;
    		arr[Integer.parseInt(str.substring(i, i+1))-1] = true;
    	}

    	for (int i = 0; i < arr.length; i++)
    		if (arr[i] == false) return false;
    	return true;
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
}