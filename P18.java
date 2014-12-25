package OneHundred;
import java.util.*;

public class P18
{
    public static void main(String[] args){
        int size = 15;
        Scanner reader = new Scanner("75 95 64 17 47 82 18 35 87 10 20 4 82 47 65 19 1 23 75 3 34 88 2 77 73 7 63 67 99 65 4 28 6 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 4 68 89 53 67 30 73 16 69 87 40 31 4 62 98 27 23 9 70 98 73 93 38 53 60 4 23");
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
