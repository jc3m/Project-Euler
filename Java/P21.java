package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P21
{
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList();
        ArrayList<Integer> amicable = new ArrayList();
        for(int i = 1; i < 10000; i++){
            numbers.add(i);
        }
        for(int i = 0; i < numbers.size(); i++){
            if(divisors(i + 1).get(0) == 1){
                numbers.set(i, 0);
            }
        }
        for(int i = numbers.size() - 1; i >= 0; i--){
            if(numbers.get(i) == 0){
                numbers.remove(i);
            }
        }
        //System.out.println(numbers.toString());
        
        for(int i = 0; i < numbers.size(); i++){
            if(isAmicable(numbers.get(i))){
                amicable.add(numbers.get(i));
            }
        }
        System.out.println(amicable.toString());
        int total = 0;
        for(int i = 0; i < amicable.size(); i++){
            total += amicable.get(i);
        }
        System.out.println(total);
    }
    
    private static boolean isAmicable(int i){
        int temp = function(i);
        if(i == (function(temp))){
            if(i != temp){
                return true;
            }
        }
        return false;
    }

    private static int function(int i){
        ArrayList <Integer> temp = divisors(i);
        int total = 0;
        for(int c = 0; c < temp.size(); c++){
            total += temp.get(c);
        }
        return total;
    }

    private static ArrayList<Integer> divisors(int i){
        ArrayList<Integer> divs = new ArrayList();
        for(int c = 2; c <= Math.sqrt(i); c++){
            if((i) % c == 0){
                if(c == i/c){
                    divs.add(c);
                }
                else{
                    divs.add(c);
                    divs.add(i/c);
                }
            }
        }
        divs.add(1);
        //System.out.println(divs.toString());
        return divs;
    }
}
