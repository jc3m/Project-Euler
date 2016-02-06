package OneHundred;
import java.util.*;
import java.math.*;

@SuppressWarnings("unchecked")
public class P29
{
    public static void main(String[] args){
        ArrayList<BigInteger> numbers = new ArrayList();
        for(int i = 2; i <= 100; i++){
            for(int c = 2; c <= 100; c++){
                BigInteger temp = new BigInteger(Integer.toString(i));
                temp = temp.pow(c);
                if(numbers.indexOf(temp) < 0){
                    numbers.add(temp);
                }
            }
            System.out.println(i);
        }
        Collections.sort(numbers);
        //System.out.println(numbers);
        System.out.println(numbers.size());
    }
    
    
}
