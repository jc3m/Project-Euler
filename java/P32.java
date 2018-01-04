package OneHundred;

import java.util.*;

@SuppressWarnings("unchecked")
public class P32
{
    static ArrayList<Integer> nums = new ArrayList();
    public static void main(String[] args){
        for(int a = 1; a <10; a++){
            for(int b = 1000; b < 10000; b++){
                if(isPan(a, b)){
                    if(nums.indexOf(a*b) < 0){
                        nums.add(a*b);
                    }
                }
            }
        }
        for(int a = 10; a < 100; a++){
            for(int b = 100; b < 1000; b++){
                if(isPan(a, b)){
                    if(nums.indexOf(a*b) < 0){
                        nums.add(a*b);
                    }
                }
            }
        }
        int total = 0;
        for(int i = 0; i < nums.size(); i++){
            total += nums.get(i);
        }
        
        System.out.println(total);
    }

    public static boolean isPan(int a, int b){
        int val = a * b;

        int temp = a;
        ArrayList<Integer> nums = new ArrayList();

        while(temp >= 10){
            int hold = temp % 10;
            nums.add(hold);
            temp = temp/10;
        }
        nums.add(temp);

        temp = b;

        while(temp >= 10){
            int hold = temp % 10;
            nums.add(hold);
            temp = temp/10;
        }
        nums.add(temp);

        temp = val;

        while(temp >= 10){
            int hold = temp % 10;
            nums.add(hold);
            temp = temp/10;
        }
        nums.add(temp);

        for(int i = 1; i <= nums.size(); i++){
            if(nums.indexOf(i) == -1){
                return false;
            }
        }
        return true;
    }
}
