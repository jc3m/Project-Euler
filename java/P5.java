package OneHundred;

import java.util.*;

public class P5
{
    public static void main(String[] args){
        int i = 19;
        boolean running = true;
        while(running){
            boolean isVal = true;
            for(int c = 1; c <= 20; c++){
                if(i%c != 0){
                    isVal = false;
                }
            }
            if(isVal == true){
                System.out.println(i);
                running = false;
            }
            i += 19;
        }
    }
}
