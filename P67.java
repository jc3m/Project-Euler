package OneHundred;
import java.util.*;
import java.io.File;

public class P67
{
    public static void main(String[] args) throws Exception{
        int size = 100;
        Scanner reader = new Scanner(new File("triangle67.txt"));
        ArrayList triangle = new ArrayList();
        for(int i = 1; i <= size; i++){
            ArrayList temp = new ArrayList();
            for(int c = 0; c < i; c++){
                if(reader.hasNextInt()){
                    int b = reader.nextInt();
                    //System.out.println(b);
                    temp.add(b);
                }
            }
            triangle.add(temp);
        }
        
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int c = 0; c < ((ArrayList)triangle.get(i)).size(); c++){
                int a = (int)((ArrayList)triangle.get(i+1)).get(c);
                int b = (int)((ArrayList)triangle.get(i+1)).get(c+1);
                ((ArrayList)triangle.get(i)).set(c, greater(a, b) + (int)((ArrayList)triangle.get(i)).get(c));
            }
        }
        System.out.println(((ArrayList)triangle.get(0)).get(0));
    }

    private static int greater(int a, int b){
        if(a > b){
            return a;
        }
        else{
            return b;
        }
    }
}
