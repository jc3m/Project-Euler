package OneHundred;
import java.util.*;
import java.io.File;
import java.math.*;

@SuppressWarnings("unchecked")
public class P22
{
    public static void main(String[] args) throws Exception{
        Scanner reader = new Scanner(new File("names.txt"));
        String list = reader.nextLine();
        ArrayList<String> names = new ArrayList();
        StringTokenizer tokenizer = new StringTokenizer(list, "\" ,");
        while(tokenizer.hasMoreTokens()){
            names.add(tokenizer.nextToken());
        }
        Collections.sort(names);

        System.out.println(names.toString());
        BigInteger totalVal = new BigInteger("0");
        for(int i = 1; i <= names.size(); i++){
            BigInteger val = new BigInteger((Integer.toString(toNumVal(names.get(i-1)))));
            val = val.multiply(new BigInteger(Integer.toString(i)));
            totalVal = totalVal.add(val);
        }
        System.out.println(totalVal.toString());
    }

    public static int toNumVal(String s){
        ArrayList<String> alphabet = new ArrayList();
        alphabet.add("Placeholder");
        alphabet.add("A");
        alphabet.add("B");
        alphabet.add("C");
        alphabet.add("D");
        alphabet.add("E");
        alphabet.add("F");
        alphabet.add("G");
        alphabet.add("H");
        alphabet.add("I");
        alphabet.add("J");
        alphabet.add("K");
        alphabet.add("L");
        alphabet.add("M");
        alphabet.add("N");
        alphabet.add("O");
        alphabet.add("P");
        alphabet.add("Q");
        alphabet.add("R");
        alphabet.add("S");
        alphabet.add("T");
        alphabet.add("U");
        alphabet.add("V");
        alphabet.add("W");
        alphabet.add("X");
        alphabet.add("Y");
        alphabet.add("Z");
        char[] name = s.toCharArray();
        int value = 0;
        for(int i = 0; i < name.length; i++){
            value += Math.abs(alphabet.indexOf(Character.toString(name[i])));
        }
        return value;
    }
    
}
