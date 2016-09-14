import java.math.*;

public class P16
{
    public static void main(String[] args){
        BigInteger val = new BigInteger("2");
        val = val.pow(1000);
        String value = val.toString();
        char[] array = value.toCharArray();
        int total = 0;
        for(int i = 0; i < array.length; i++){
            total += Integer.parseInt(Character.toString(array[i]));
        }
        System.out.println(total);
    }
}
