package OneHundred;

import java.lang.StringBuilder;

/**
 * Write a description of class P36 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P36
{
    public static void main(String[] args){
        int sum = 0;
        for(int i = 0; i < 1000000; i++){
            if(check(i)){
                sum+= i;
            }
        }
        System.out.println(sum);
    }
    
    public static boolean check(int a){
        StringBuilder test = new StringBuilder(Integer.toString(a));
        if(!Integer.toString(a).equals(test.reverse().toString())){
            return false;
        }
        String binary = Integer.toBinaryString(a);
        test = new StringBuilder(binary);
        if(!binary.equals(test.reverse().toString())){
            return false;
        }
        return true;
    }
}
