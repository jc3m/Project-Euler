package OneHundred;

import java.util.*;

@SuppressWarnings("unchecked")
public class P45
{
    static ArrayList<Long> triangle = new ArrayList();
    static ArrayList<Long> pentagon = new ArrayList();
    static ArrayList<Long> hexagon = new ArrayList();

    public static void main(String[] args){
        boolean notFound = true;
        tGen();
        pGen();
        while(notFound){
            hGen();
            Long lastH = hexagon.get(hexagon.size() - 1);
            if(lastH < 0){
                System.out.println("Not Found");
                notFound = false;
            }
            //System.out.println(hexagon.get(hexagon.size() - 1));
            while(lastH > triangle.get(triangle.size() - 1)){
                tGen();
                //System.out.println(lastH + " vs. " + triangle.get(triangle.size() - 1));
            }
            while(lastH > pentagon.get(pentagon.size() - 1)){
                pGen();
            }
            if(triangle.indexOf(lastH) >= 0 && pentagon.indexOf(lastH) >= 0){
                System.out.println("Num is: " + lastH);
                if(lastH > 40755){
                    notFound = false;
                }
            }
        }
    }

    private static void tGen(){
        Long n = triangle.size() + 1l;
        triangle.add(n*(n+1)/2);
    }

    private static void pGen(){
        Long n = pentagon.size() + 1l;
        pentagon.add(n*(3*n-1)/2);
    }

    private static void hGen(){
        Long n = hexagon.size() + 1l;
        hexagon.add(n*(2*n-1));
    }
}
