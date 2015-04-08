package OneHundred;
import java.util.*;

@SuppressWarnings("unchecked")
public class P23
{
    public static void main(String[] args){
        ArrayList<Integer> valid = new ArrayList();
        ArrayList<Integer> aNums = new ArrayList();
        for(int i = 1; i <= 28123; i++){
            if(isAbundant(divisors(i))){
                aNums.add(i);
            }
            valid.add(i);
        }
        for(int r = 0; r < aNums.size(); r++){
            for(int c = 0; c < aNums.size(); c++){
                if(aNums.get(r) + aNums.get(c) <= valid.get(valid.size()-1)){
                    int index = valid.indexOf(aNums.get(r) + aNums.get(c));
                    if(index != -1){
                        valid.remove(index);
                    }
                }
                System.out.println(valid.size());
            }
        }
        System.out.println(valid.toString());
        int total = 0;
        for(int i = 0; i < valid.size(); i++){
            total += valid.get(i);
        }
        System.out.println(total);
    }

    private static boolean isAbundant(ArrayList<Integer> list){
        int oNum = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        int tVal = 0;
        for(int i = 0; i < list.size(); i++){
            tVal += list.get(i);
        }
        return tVal > oNum;
    }

    private static ArrayList<Integer> divisors(int i){
        ArrayList<Integer> divs = new ArrayList();
        divs.add(1);
        for(int c = 2; c <= Math.sqrt(i); c++){
            if((i) % c == 0){
                if(c == i/c){
                    divs.add(c);
                }
                else{
                    divs.add(c);
                    divs.add(i/c);
                }
            }
        }
        divs.add(i);
        //System.out.println(divs.toString());
        return divs;
    }
}
