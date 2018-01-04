import java.util.Arrays;
import java.util.Hashtable;
import java.util.Collections;

public class P203 {
    public static void main(String[] args) {
        P203 runner = new P203();
        runner.run();
    }

    private void run() {
        int height = 51;
        long[][] triangle = genPascal(height);

        //print2D(triangle);
        
        Hashtable<Long, Integer> table = findUnique(triangle);
        long[] uniques = castOver(table.values().toArray());
        Arrays.sort(uniques);
        
        //System.out.println(Arrays.toString(uniques));
        
        long max = findMax(uniques);
        int primeCap = (int)(Math.sqrt(max)) + 1;
        int[] primes = sieve(primeCap);
        long[] primeSq = square(primes);
        //System.out.println(Arrays.toString(primeSq));

        long total = 0;
        for (int i = 0; i < uniques.length; i++) {
            if (checkNum(uniques[i], primeSq))
                total += uniques[i];
        }

        System.out.println(total);
    }

    private boolean checkNum(long num, long[] primeSq) {
        for (int i = 0; i < primeSq.length; i++) {
            if (num % primeSq[i] == 0)
                return false;
            if (num < primeSq[i]) {
                //System.out.println(num);
                return true;
            }
        }

        System.out.println("Error");
        return false;
    }

    private long findMax(long[] arr) {
        long max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private long[] castOver(Object[] arr) {
        long[] res = new long[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (long)(Long)(arr[i]);
        }
        return res;
    }

    private Hashtable findUnique(long[][] triangle) {
        Hashtable<Integer, Long> res = new Hashtable();
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                Long temp = triangle[i][j];
                Integer hashcode = temp.hashCode();
                if (!res.containsKey(hashcode)) {
                    res.put(hashcode, temp);
                }
            }
        }
        return res;
    }

    private long[][] genPascal(int height) {
        long[][] res = new long[height][];
        for (int i = 0; i < height; i++) {
            res[i] = new long[i+1];
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (j == 0 || j == res[i].length - 1)
                    res[i][j] = 1;
                else
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
            }
        }
        return res;
    }

    private void print2D(long[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    private long[] square(int[] arr) {
        long[] res = new long[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (long)(Math.pow(arr[i], 2));
        }
        return res;
    }

    public int[] sieve(int n) {
        boolean[] sieve = new boolean[n+1];
        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = true;
        }
        int current = 2;
        while (current < sieve.length) {
            if (sieve[current]) {
                for (int i = current*2; i < sieve.length; i += current) {
                    sieve[i] = false;
                }
            }
            current++;
        }
        int size = 0;
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i])
                size++;
        }
        int[] res = new int[size];
        int index = 0;
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                res[index] = i;
                index++;
            }
        }
        return res;
    }
}