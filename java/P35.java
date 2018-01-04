package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P35
{
    static ArrayList<Integer> primes = generatePrimes();
    
    public static void main(String[] args){
        int counter = 0;
        for(int i = 0; i < primes.size(); i++){
            if(isCircular(primes.get(i))){
                counter++;
                System.out.println(counter);
            }
        }
    }
    
    public static boolean isCircular(int a){
        int currVal = a;
        if(a < 10){
            return true;
        }
        
        int length = Integer.toString(a).toCharArray().length;
        for(int i = 0; i < length; i++){
            //System.out.println(currVal);
            if(primes.indexOf(currVal) < 0){
                return false;
            }
            currVal = rotate(currVal);
        }
        return true;
    }
    
    public static int rotate(int a){
        char[] num = Integer.toString(a).toCharArray();
        int length = num.length;
        int lastVal = Integer.parseInt(Character.toString(num[num.length-1]));
        int value = a/10;
        value += lastVal * Math.pow(10, length-1);
        return value;
    }
    
    public static ArrayList<Integer> generatePrimes(){
        ArrayList<Integer> primes = new ArrayList();
        primes.add(2);
        int c = 3;
        while(c <= 1000000){
            //System.out.println(c);
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
        //System.out.println(primes);
        return primes;
    }
}
