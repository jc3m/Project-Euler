package OneHundred;
import java.util.*;

public class P19
{
    public static void main(String[] args){
        ArrayList<Integer> firstDays = new ArrayList();
        ArrayList<Integer> sundays = new ArrayList();
        int totalDays = 0;
        for(int i = 1901; i <= 2000; i++){
            if(i % 400 == 0){
                totalDays += 365;
            }
            else if(i % 4 == 0){
                totalDays +=  366;
            }
            else{
                totalDays += 365;
            }
        }
        System.out.println("Total days: " + totalDays);
        int[] high = {1, 3, 5, 7, 8, 10, 0};
        int[] low = {4, 6, 9, 11};
        int firstDay = 1;
        firstDays.add(firstDay);
        int month = 1;
        while(firstDay <= totalDays){
            if(month % 12 == 2){
                if((month/12 + 1901) % 400 == 0){
                    firstDay += 29;
                }
                else if((month/12 + 1901) % 100 == 0){
                    firstDay += 28;
                }
                else if((month/12 + 1901) % 4 == 0){
                    firstDay += 29;
                }
                else{
                    firstDay += 28;
                }
            }
            else if(isMember(month % 12, high)){
                firstDay += 31;
            }
            else if(isMember(month % 12, low)){
                firstDay += 30;
            }
            firstDays.add(firstDay);
            month++;
        }

        //System.out.println("First days passed");
        //System.exit(0);

        int currDay = 6;
        sundays.add(currDay);
        while(currDay <= totalDays){
            currDay += 7;
            sundays.add(currDay);
        }

        //System.out.println("Sundays passed");

        int counter = 0;
        while(!firstDays.isEmpty() && !sundays.isEmpty()){
            //System.out.println("Comparing " + firstDays.get(0) + " and " + sundays.get(0));
            if(firstDays.get(0) < sundays.get(0)){
                firstDays.remove(0);
            }
            else if(firstDays.get(0) > sundays.get(0)){
                sundays.remove(0);
            }
            else{
                firstDays.remove(0);
                sundays.remove(0);
                counter++;
            }
            /*
            else{
            System.out.println("Error");
            break;
            }
             */
        }
        System.out.println(counter);
    }

    private static boolean isMember(int i, int[] list){
        for(int c = 0; c < list.length; c++){
            if(list[c] == i){
                return true;
            }
        }
        return false;
    }
}
