package OneHundred;

import java.util.*;

@SuppressWarnings("unchecked")
public class P34
{
    public static void main(String[] args){
        int total = 0;
        for(int i = 3; i < 2000000; i++){
            if(isFac(i)){
                total += i;
            }
        }
        System.out.println(total);
    }

    public static boolean isFac(int b){
        int a = b;
        ArrayList<Integer> nums = new ArrayList();

        while(a >= 10){
            nums.add(a%10);
            a = a/10;
        }
        nums.add(a);
        
        int val = 0;
        for(int i = 0; i < nums.size(); i++){
            val += factorial(nums.get(i));
        }
        
        return val == b;
    }
    
    public static int factorial(int i){
        int val = 1;
        while(i > 1){
            val *= i;
            i--;
        }
        return val;
    }
}
