package OneHundred;
import java.util.*;

public class P10
{
    public static void main(String[] args){
        ArrayList<Integer> primes = new ArrayList();
        primes.add(2);
        int c = 3;
        while(primes.get(primes.size()-1) < 2000000){
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
                System.out.println(c);
            }
            c++;
        }
        primes.remove(primes.size()-1);
        long totalVal = 0L;
        for(int i = 0; i < primes.size(); i++){
            totalVal += primes.get(i);
        }
        System.out.println(totalVal);
    }
}
