package OneHundred;
import java.util.ArrayList;
/**
* Write a description of class EvenFib here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class P2
{
    public static void main(String [] args){
        ArrayList fibs = new ArrayList();
        fibs.add(1);
        fibs.add(2);
        int val = 0;
        while((int)fibs.get(fibs.size() - 1) < 4000000){
            fibs.add((int)fibs.get(fibs.size() - 2) + (int)fibs.get(fibs.size() - 1));
        }
        for(int i = 0; i < fibs.size(); i++){
            if((int)fibs.get(i) % 2 == 0){
                val += (int)fibs.get(i);
            }
        }
        System.out.println(val);
    }
}
