package OneHundred;
import java.util.*;
public class P17
{
    public static void main(String[] args){
        int totalVal = 0;
        for(int i = 1; i <= 1000; i++){
            System.out.println(i + ": " + convert(i));
            totalVal += convert(i).length();
        }
        System.out.println(totalVal);
    }
    
    public static void test(){
        while(true){
            System.out.print("Enter integer: ");
            Scanner input = new Scanner(System.in);
            System.out.println(convert(input.nextInt()));
        }
    }
    
    private static String convert(int i){
        int c = i;
        String rString = "";
        if(c == 1000){
            rString += "onethousand";
        }
        if(c >= 100 && c < 1000){
            switch(c/100){
                case 9: rString += "nine";
                break;
                case 8: rString += "eight";
                break;
                case 7: rString += "seven";
                break;
                case 6: rString += "six";
                break;
                case 5: rString += "five";
                break;
                case 4: rString += "four";
                break;
                case 3: rString += "three";
                break;
                case 2: rString += "two";
                break;
                case 1: rString += "one";
            }
            if(c%100 == 0){
                rString += "hundred";
            }
            else{
                rString += "hundredand";
            }
            c = c % 100;
        }
        if(c >= 20 && c < 100){
            switch(c/10){
                case 9: rString += "ninety";
                break;
                case 8: rString += "eighty";
                break;
                case 7: rString += "seventy";
                break;
                case 6: rString += "sixty";
                break;
                case 5: rString += "fifty";
                break;
                case 4: rString += "forty";
                break;
                case 3: rString += "thirty";
                break;
                case 2: rString += "twenty";
                break;
            }
            c = c % 10;
        }
        if(c >= 10 && c < 20){
            switch(c){
                case 19: rString += "nineteen";
                break;
                case 18: rString += "eighteen";
                break;
                case 17: rString += "seventeen";
                break;
                case 16: rString += "sixteen";
                break;
                case 15: rString += "fifteen";
                break;
                case 14: rString += "fourteen";
                break;
                case 13: rString += "thirteen";
                break;
                case 12: rString += "twelve";
                break;
                case 11: rString += "eleven";
                break;
                case 10: rString += "ten";
            }
        }
        if(c > 0 && c < 10){
            switch(c){
                case 9: rString += "nine";
                break;
                case 8: rString += "eight";
                break;
                case 7: rString += "seven";
                break;
                case 6: rString += "six";
                break;
                case 5: rString += "five";
                break;
                case 4: rString += "four";
                break;
                case 3: rString += "three";
                break;
                case 2: rString += "two";
                break;
                case 1: rString += "one";
                break;
            }
        }
        return rString;
    }
}
