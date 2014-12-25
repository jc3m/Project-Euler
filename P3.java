public class P3
{
    public static void main(String [] args) {
        long startTime = System.currentTimeMillis();
        int largest = 0;
        long value =  600851475143L;
        while(true){
            if (value == findPrime(value)) {
                System.out.println(value);
                break;
            }
            else {
                value = findPrime(value);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime + "\t");
    }
    
    public static long findPrime(long val){
        for(int i = 2; i < val; i++){
            if(val % i == 0){
                return val/i;
            }
        }
        System.out.println(val);
        return val;
    }
}
