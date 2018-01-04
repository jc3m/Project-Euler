import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class P345 {
    private int global_width = 5;

    public static void main(String[] args) {
        P345 runner = new P345();
        runner.run();
    }

    public void run() {
        int width = global_width;
        String fp = "P345_matrix2.txt";

        //int width = 15;
        //String fp = "P345_matrix.txt";

        boolean[] rows = new boolean[global_width];
        boolean[] columns = new boolean[global_width];

        int[][] matrix = readIn(fp, width);

        printGrid(matrix);
        //printGrid(costGrid);

        int sum = 0;
        int[] pair;

        for (int i = 0; i < global_width; i++) {
            double[][] costGrid = genCosts(matrix, rows, columns);
            printGrid(costGrid);
            pair = findMax(matrix, costGrid, rows, columns);
            rows[pair[0]] = true;
            columns[pair[1]] = true;
            printVals(pair[0], pair[1], costGrid, matrix);
        }
    }

    private double[][] genCosts(int[][] matrix, boolean rows[], boolean[] columns) {
        double[][] costGrid = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                costGrid[i][j] = cost(i, j, matrix, rows, columns);
            }
        }
        return costGrid;
    }

    private void printVals(int i, int j, double[][] costGrid, int[][] matrix) {
        System.out.println("Value: " + matrix[i][j]);
        System.out.println("Cost: " + costGrid[i][j]);
    }

    private double cost(int i, int j, int[][] matrix, boolean[] rows, boolean[] cols) {
        int val = matrix[i][j];
        double cost = 0;
        for (int r = 0; r < matrix.length; r++) {
            if (!cols[r])
                cost += matrix[r][j];
        }
        cost -= val;
        for (int r = 0; r < matrix.length; r++) {
            if (!rows[r])
                cost += matrix[i][r];
        }
        cost -= val;
        return (cost/(double)val);
    }

    private int[] findMax(int[][] matrix, double[][] costGrid, boolean[] rows, boolean[] cols) {
        int[] res = {-1, -1};
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < costGrid.length; i++) {
            for (int j = 0; j < costGrid[i].length; j++) {
                if (!rows[i] && !cols[j] && costGrid[i][j] < min) {
                    min = costGrid[i][j];
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    private int[][] readIn(String filepath, int width) {
        String temp;
        BufferedReader br;
        int[][] res = new int[width][];

        try {
            br = new BufferedReader(new FileReader(filepath));
            int c = 0;

            while ((temp = br.readLine()) != null) {
                String[] strArr = temp.split(" ");
                res[c] = strToIntArr(strArr);
                c += 1;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    private int[] strToIntArr(String[] in) {
        int[] res = new int[global_width];
        int counter = 0;
        for (int i = 0; i < in.length; i++) {
            String t = in[i];
            try {
                res[counter] = Integer.parseInt(t);
                counter++;
            } catch(Exception e) {
            }
        }
        return res;
    }

    public void printGrid(double[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    public void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}