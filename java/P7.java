package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P7
{
    public static void main(String[] args){
        ArrayList<Integer> primes = new ArrayList();
        primes.add(2);
        int c = 3;
        while(primes.size() <= 10001){
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
        System.out.println(primes.get(10000));
    }
}
