package OneHundred;
import java.util.*;

public class P4
{
    public static void main(String[] args){
        ArrayList<Integer> number = new ArrayList();
        int totalVal = 0;
        for(int r = 999; r > 99; r--){
            for(int c = 990; c > 99; c-=11){
                int val = r*c;
                StringBuilder test = new StringBuilder(Integer.toString(val));
                if(test.toString().equals(test.reverse().toString())){
                    if(val > totalVal){
                        totalVal = val;
                    }
                }
            }
        }
        System.out.println(totalVal);
    }
}
