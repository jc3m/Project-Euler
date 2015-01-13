package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P27
{
    static ArrayList<Integer> firstPrimes = generatePrimes(1000);
    static ArrayList<Integer> primes = generatePrimes(2000);
    
    public static void main(String[] args){
        int largest = 0;
        int largestA = 0;
        int largestB = 0;
        for(int i = -1000; i < 1000; i++){
            for(int c = 0; c < firstPrimes.size(); c++){
                int temp = test(i, c);
                if(temp > largest){
                    largest = temp;
                    largestA = i;
                    largestB = c;
                }
            }
        }
        System.out.println(largestA * largestB);
    }
    
    public static int test(int a, int b){
        int numPrimes = 0;
        boolean nextPrime = true;
        int counter = 0;
        while(nextPrime){
            int value = (int)Math.pow(counter, 2) + (counter * a) + b;
            if(primes.indexOf(value) > 0){
                counter++;
                numPrimes++;
            }
            else{
                nextPrime = false;
            }
        }
        return numPrimes;
    }
    
    public static ArrayList<Integer> generatePrimes(int lim){
        ArrayList<Integer> primes = new ArrayList();
        primes.add(2);
        int c = 3;
        while(primes.size() <= lim){
            boolean isPrime = true;
            int b = 0;
            while(isPrime && b < primes.size()){
                if(c % primes.get(b) == 0){
                    isPrime = false;
                }
                b++;
            }
            if(isPrime){
                primes.add(c);
            }
            c++;
        }
        return primes;
    }
}
