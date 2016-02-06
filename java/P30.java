package OneHundred;
import java.util.*;
/**
 * Write a description of class P30 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
@SuppressWarnings("unchecked")
public class P30
{
    public static void main(String[] args){
        ArrayList<Integer> values = new ArrayList();
        for(int i = 220; i < 413343; i++){
            if(compare(i)){
                values.add(i);
            }
        }
        System.out.println(values);
        int total = 0;
        for(int i = 0; i < values.size(); i++){
            total += values.get(i);
        }
        System.out.println(total);
    }
    
    public static ArrayList<Integer> single(int num){
        int val = num;
        ArrayList<Integer> single = new ArrayList();
        while(val >= 10){
            int temp = val % 10;
            val = val/10;
            single.add(temp);
        }
        single.add(0, val);
        //System.out.println(single);
        return single;
    }
    
    public static boolean compare(int val){
        ArrayList<Integer> num = single(val);
        int tempVal = 0;
        for(int i = 0; i < num.size(); i++){
            tempVal += (int)Math.pow(num.get(i), 5);
        }
        return tempVal == val;
    }
}
