public class P12
{
    public static void main(String[] args){
        int counter = 1;
        int triangle = 1;
        while(true){
            //System.out.println(Integer.toString(triangle) + ": " + numFactors(triangle));
            if(numFactors(triangle) > 500){
                System.out.println(Integer.toString(triangle));
                System.exit(0);
            }
            counter++;
            triangle += counter;
        }
    }
    
    private static int numFactors(int num){
        int total = 0;
        for(int i = 1; i < (int)Math.sqrt(num)+1; i++){
            if(num % i == 0){
                total += 2;
            }
        }
        return total;
    }
}
