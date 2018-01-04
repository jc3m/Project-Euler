package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P24
{
    public static ArrayList<String> permutation = new ArrayList();
    public static void main(String[] args){
        permute("", "0123456789");
        Collections.sort(permutation);
        System.out.println(permutation.get(1000000-1));
    }
    
    public static void permute(String beginningString, String endingString) {
        if (endingString.length() <= 1)
            permutation.add(beginningString + endingString);
        else{
            for (int i = 0; i < endingString.length(); i++) {
                try{
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                    permute(beginningString + endingString.charAt(i), newString);
                }
                catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}