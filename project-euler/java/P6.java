package OneHundred;

/**
 * Write a description of class SumSquare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P6
{
    public static void main(String[] args){
        int val1 = 0;
        int val2 = 0;
        for(int i = 1; i <= 100; i++){
            val1 += Math.pow(i, 2);
        }
        System.out.println(val1);
        for(int i = 1; i <= 100; i++){
            val2 += i;
        }
        System.out.println(val2);
        System.out.println(Math.pow(val2, 2) - val1);
    }
}
