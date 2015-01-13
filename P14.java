package OneHundred;
public class P14
{
    public static void main(String[] args){
        long maxCount = 0;
        long Tval = 0;
        for(long i = 0; i <= 1000000; i++){
            long val = i;
            long counter = 0;
            while(val > 1){
                if(val%2 == 0){
                    val = val/2;
                }
                else{
                    val = 3*val + 1;
                }
                counter++;
            }
            if(maxCount < counter){
                maxCount = counter;
                Tval = i;
            }
            System.out.println(i + ": " + counter);
        }
        System.out.println("Largest chain: " + Tval);
    }
}
