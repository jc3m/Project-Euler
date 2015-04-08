package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P37
{
    private static ArrayList<Integer> primes = generatePrimes(10000);
    
    public static void main(String[] args){
        int primeSize = 10000;
        int counter = 9;
        ArrayList<Integer> numbers = new ArrayList();
        while(numbers.size() < 11){
            if(counter > primeSize){
                primes = generatePrimes(primeSize * 2);
                primeSize *= 2;
                System.out.println("PrimeSize updated: " + primeSize);
            }
            if(tPrime(counter)){
                numbers.add(counter);
                System.out.println(numbers);
            }
            counter++;
        }
        
        int total = 0;
        for(int i = 0; i < numbers.size(); i++){
            total += numbers.get(i);
        }
        System.out.println(total);
    }
    
    public static boolean tPrime(int a){
        ArrayList<Integer> list = generate(a);
        for(int i = 0; i < list.size(); i++){
            if(primes.indexOf(list.get(i)) < 0){
                return false;
            }
        }
        return true;
    }
    
    public static ArrayList<Integer> generatePrimes(int a){
        ArrayList<Integer> primes = new ArrayList();
        primes.add(2);
        int c = 3;
        while(c <= a){
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
    
    public static ArrayList<Integer> generate(int a){
        int b = a;
        int size = 0;
        while(b >= 10){
            size++;
            b /= 10;
        }
        size++;
        //System.out.println("Length: " + size);
        ArrayList<Integer> list = new ArrayList();
        list.add(a);
        
        for(int i = 1; i < size; i++){
            list.add((int)(a/Math.pow(10, i)));
        }
        
        for(int i = 1; i < size; i++){
            int num = Integer.parseInt(Integer.toString(a).substring(i, size));
            list.add(num);
        }
        
        return list;
    }
}
