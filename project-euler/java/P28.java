package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P28
{
    public static void main(String[] args){
        ArrayList<ArrayList> matrix = new ArrayList();
        int size = 1;
        int totalVal = 1;
        int topRight = 9;
        int increment = 2;
        int currVal = 1;
        while(size < 1001){
            for(int i = 0; i < 4; i++){
                currVal += increment;
                totalVal += currVal;
            }
            increment += 2;
            topRight = (int)Math.pow(Math.pow(topRight, .5) + 1, 2);
            size += 2;
        }
        System.out.println(totalVal);
    }
}
