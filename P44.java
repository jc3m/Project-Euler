public class P44 {
	//public ArrayList<Integer> pentNums;

	public static void main(String[] args) {
		P44 runner = new P44();
		runner.run();
        //runner.generate(10);
	}

    public void run() {
        long min = Long.MAX_VALUE;
        for (int i = 1; ; i++) {
            long pentI = generate(i);
            if (pentI - generate(i-1) > min)
                break;
            for (int j = i-1; j > 1; j--) {
                long pentJ = generate(j);
                long diff = pentI - pentJ;
                long sum = pentI + pentJ;
                if (diff >= min)
                    break;
                else if (isPent(diff) && isPent(sum) && diff < min)
                    min = diff;
            }
        }
        System.out.println(min);
    }

    private boolean isPent(long n) {
        return (1+Math.sqrt(24*n+1))%6 == 0;
    }

	private long generate(int ind) {
        long n = (long)ind;
        return n*(3*n-1)/2;
    }
}