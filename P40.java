package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P40
{
    static String big = "";
    
    public static void main(String[] args){
        generate();
        char[] larg = big.toCharArray();
        System.out.println("Size is: " + larg.length);
        ArrayList<Integer> nums = new ArrayList();
        int current = 1;
        while(current <= 1000000){
            int temp = Integer.parseInt(Character.toString(larg[current - 1]));
            nums.add(temp);
            System.out.println(temp);
            current *= 10;
        }
        
        int total = 1;
        
        for(int i = 0; i < nums.size(); i++){
            total *= nums.get(i);
        }
        
        System.out.println(total);
    }
    
    public static void generate(){
        int current = 1;
        while(big.length() <= 1000000){
            big += Integer.toString(current);
            current++;
            System.out.println(big.length());
        }
        System.out.println("Generate finished");
    }
}
