package OneHundred;

import java.util.*;

@SuppressWarnings("unchecked")
public class P33
{
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList();
        ArrayList<Integer> dems = new ArrayList();
        for(int r = 0; r < 100; r++){
            for(int c = 0; c < 100; c++){
                if(cancel(r, c)){
                    nums.add(r);
                    dems.add(c);
                }
            }
        }
        int fNum = 1;
        int fDem = 1;
        for(int i = 0; i < nums.size(); i++){
            fNum *= nums.get(i);
        }
        for(int i = 0; i < nums.size(); i++){
            fDem *= dems.get(i);
        }
        System.out.println(nums);
        System.out.println(dems);
        System.out.println(reduce(fNum, fDem));
    }
    
    public static boolean cancel(int a, int b){
        if(b < a){
            return false;
        }
        
        double ratio = (double)a / (double)b;
        System.out.println("Ratio: " + ratio);
        int a1 = a % 10;
        int a2 = a / 10;
        int b1 = b % 10;
        int b2 = b / 10;
        
        if(a1 != b2 && a2 != b1){
            return false;
        }
        
        if(a2 == b2 || a1 == b1){
            return false;
        }
        
        double val1 = (double)a1/(double)b2;
        System.out.println("Val1: " + val1);
        double val2 = (double)a2/(double)b1;
        System.out.println("Val2: " + val2);
        if(val1 == ratio || val2 == ratio){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static int reduce(int a, int b){
        int bV = b;
        ArrayList<Integer> aDiv = getDivs(a);
        //System.out.println("aDiv: " + aDiv);
        ArrayList<Integer> bDiv = getDivs(b);
        //System.out.println("bDiv: " + bDiv);
        ArrayList<Integer> common = new ArrayList();
        for(int i = 0; i < aDiv.size(); i++){
            //System.out.println(aDiv.get(i));
            if(bDiv.indexOf(aDiv.get(i)) >= 0){
                //System.out.println("Loop: " + i);
                int temp = aDiv.get(i);
                aDiv.remove(i);
                bDiv.remove(bDiv.indexOf(temp));
                common.add(temp);
                i--;
            }
        }
        for(int i = 0; i < common.size(); i++){
            bV = bV/common.get(i);
        }
        return bV;
    }
    
    public static ArrayList<Integer> getDivs(int b){
        int a = b;
        ArrayList<Integer> list = new ArrayList();
        boolean cond = true;
        while(cond){
            int ac = getLowest(a);
            if(ac > 0){
                a = a/ac;
                list.add(ac);
            }
            else{
                cond = false;
            }
        }
        list.add(a);
        //System.out.println(list);
        return list;
    }
    
    public static int getLowest(int a){
        for(int i = 2; i <= Math.pow(a, 0.5); i++){
            if(a%i == 0){
                return i;
            }
        }
        return -1;
    }
}
