package OneHundred;
    
import java.util.*;
import java.io.File;

@SuppressWarnings("unchecked")
public class P42
{
    static ArrayList<Integer> tNums = new ArrayList();
    static ArrayList<String> tWords = new ArrayList();
    static ArrayList<String> abc = new ArrayList();
    
    public static void main(String[] args) throws Exception
    {
        String rs = "`abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < 27; i++){
            abc.add(rs.substring(i, i+1));
        }
        //System.out.println(abc);
        generateT();
        Scanner reader = new Scanner(new File("words.txt"));
        String list = reader.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(list, "\" ,");
        //int total = 0;
        while(tokenizer.hasMoreTokens()){
            String hold = tokenizer.nextToken();
            
            int numVal = convert(hold);
            //System.out.println(hold + ": " + numVal);
            while(numVal > tNums.get(tNums.size() - 1)){
                generateT();
            }
            if(tNums.indexOf(numVal) >= 0){
                tWords.add(hold);
            }
        }
        //System.out.println(abc);
        //System.out.println(tNums);
        //System.out.println(tWords);
        System.out.println(tWords.size());
    }
    
    public static void generateT(){
        int next = tNums.size() + 1;
        int temp = next*(next+1)/2;
        tNums.add(temp);
    }
    
    public static int convert(String word){
        char[] w = word.toCharArray();
        int total = 0;
        for(int i = 0; i < w.length; i++){
            total += abc.indexOf(Character.toString(w[i]).toLowerCase());
        }
        return total;
    }
}
