package OneHundred;

/**
 * Write a description of class M35 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P1
{
    public static void main(String[] args){
        int value = 0;
        for(int i = 0; i < 1000; i++){
            if(i % 3 == 0 || i % 5 == 0){
                value += i;
            }
        }
        System.out.println(value);
    }
}
