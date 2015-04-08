package OneHundred;
/**
 * Write a description of class P9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P9
{
    public static void main(String[] args){
        for(double x = 1; x < 1000; x++){
            for(double y = 1; y < 1000; y++){
                double z = Math.sqrt(x*x + y*y);
                if(z+x+y == 1000){
                    System.out.println(x*y*z);
                    System.exit(0);
                }
            }
        }
    }
}
