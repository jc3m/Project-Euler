package OneHundred;
import java.math.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class P25
{
    public static void main(String [] args){
        ArrayList<BigInteger> fibs = new ArrayList();
        fibs.add(new BigInteger("1"));
        fibs.add(new BigInteger("1"));
        int val = 0;
        while(fibs.get(fibs.size() - 1).toString().length() < 1000){
            fibs.add(fibs.get(fibs.size() - 2).add(fibs.get(fibs.size() - 1)));
        }
        System.out.println(fibs.size());
    }
}
