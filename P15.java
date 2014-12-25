package OneHundred;
public class P15
{
    public static void main(String[] args){
        long[][] lattice = new long[21][21];
        for(int i = 0; i < lattice.length; i++){
            lattice[0][i] = 1;
        }
        for(int i = 1; i < lattice[0].length; i++){
            lattice[i][0] = 1;
        }
        for(int r = 1; r < 21; r++){
            for(int c = 1; c < 21; c++){
                lattice[r][c] = lattice[r][c-1] + lattice[r-1][c];
            }
        }
        /*
        for(int r = 0; r < 21; r++){
            for(int c = 0; c < 21; c++){
                System.out.print(lattice[r][c] + "\t\t\t\t\t\t\t\t");
            }
            System.out.println("\n");
        }
        */
        System.out.println(lattice[20][20]);
    }
}
