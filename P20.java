package OneHundred;
import java.math.*;
/**
 * Write a description of class P20 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P20
{
    public static void main(String[] args){
        BigInteger factorial = new BigInteger("1");
        for(int i = 100; i > 0; i--){
            factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
        }
        int rVal = 0;
        int length = factorial.toString().length();
        for(int i = 0; i < length; i++){
            System.out.println(factorial.toString());
            rVal += Integer.parseInt(factorial.mod(new BigInteger("10")).toString());
            factorial = factorial.divide(new BigInteger("10"));
        }
        System.out.println(rVal);
    }
}
