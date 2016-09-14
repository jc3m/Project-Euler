import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class P82 {
    private int average = 0;
    private int widthGlobal = 0;

    public static void main(String[] args) {
        P82 runner = new P82();
        runner.run();
    }

    public void run() {
        //String filename = "P82test.txt";
        String filename = "p082_matrix.txt";
        int[][] grid = readFile(filename);
        //printGrid(grid);
        int nodes = (int)Math.pow(grid.length, 2) + 1 + widthGlobal;
        Graph paths = new Graph(nodes);
        paths = genEdges(paths);
        //paths.addEdge(0, 1);
        //paths.addEdge(nodes-2, nodes-1);
        paths.addWeights(genWeights(grid));
        //paths.printWeights();
        //System.out.println(getAverage(grid));

        //System.out.println(paths.toString());

        for (int i = 0; i < widthGlobal; i++)
            paths.addEdge(nodes-i-1, widthGlobal * i + 1);
        //System.out.println(paths.toString());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < widthGlobal; i++) {
            int tempVal = dijkstra(nodes-i-1, genEnds(), paths);
            if (tempVal < min)
                min = tempVal;
        }
        System.out.println(min);
        //System.out.println(aStar(0, 26, paths));
    }

    private int dijkstra(int start, ArrayList<Integer> ends, Graph g) {
        int[] distance = new int[g.V()];
        int[] prev = new int[g.V()];
        prev[start] = -1;
        ArrayList<Integer> unvisited = new ArrayList<Integer>();
        int minimumDistance = Integer.MAX_VALUE;

        for (int i = 0; i < distance.length; i++) {
            if (i != start) {
                distance[i] = Integer.MAX_VALUE;
                prev[i] = -1;
            }
            unvisited.add(i);
        }

        while (!unvisited.isEmpty()) {
            int u = minScore(unvisited, distance);

            if (ends.contains((Integer)u)) {
                if (distance[u] < minimumDistance)
                    minimumDistance = distance[u];
                ends.remove((Integer)u);
                if (ends.isEmpty())
                    return minimumDistance;
                //System.out.println("Path found");
                //printPath(prev, end);
                //System.out.println(distance[u]);
            }

            unvisited.remove((Integer)u);

            LinkedList<Integer> n = g.neighbors(u);
            for (int i = 0; i < n.size(); i++) {
                int tn = n.get(i);
                int alt = distance[u] + g.getWeight(u, tn);

                if (alt < distance[tn]) {
                    distance[tn] = alt;
                    prev[tn] = u;
                }
            }
        }
        return -1;
    }

    private ArrayList<Integer> genEnds() {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i <= widthGlobal; i++) {
            res.add(i*widthGlobal);
        }
        return res;
    }

    private void printPath(int[] prev, int current) {
        while (current != 0) {
            String str = "[";
            str += Integer.toString((int)((current-1) / widthGlobal)) + ","
                + Integer.toString((current-1) % widthGlobal) + "]";
            System.out.println(str);
            current = prev[current];
        }
    }

    private int minScore(ArrayList<Integer> set, int[] f_score) {
        int minInd = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < set.size(); i++) {
            if (min > f_score[set.get(i)]) {
                min = f_score[set.get(i)];
                minInd = set.get(i);
            }
        }
        return minInd;
    }

    private int[] initializeArray(int size, int val) {
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = val;
        }
        return res;
    }

    private double getAverage(int[][] grid) {
        double sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
        }
        return sum/((double)(grid.length * grid.length));
    }

    private int[] genWeights(int[][] grid) {
        int[] res = new int[grid.length * grid[0].length + 2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                res[i*grid.length + j + 1] = grid[i][j];
            }
        }
        return res;
    }

    private Graph genEdges(Graph g) {
        int V = g.V();
        int width = (int)Math.sqrt(V-2);
        Graph res = g;
        for (int i = 1; i < V - 1 - widthGlobal; i++) {
            if (i > width)
                res.addEdge(i, i - width);
            if (i % width != 0)
                res.addEdge(i, i+1);
            if (i < V - 1 - width - widthGlobal)
                res.addEdge(i, i + width);
        }
        return res;
    }

    public void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    public int[][] readFile(String filename) {
        BufferedReader br;
        String str = "";
        int[][] grid;
        try {
            br = new BufferedReader(new FileReader(filename));
            int count = 0;
            while (br.readLine() != null)
                count++;
            grid = new int[count][count];
            widthGlobal = count;

            br = new BufferedReader(new FileReader(filename));
            int row = 0;
            while ((str = br.readLine()) != null) {
                String[] vals = str.split(",");
                for (int i = 0; i < vals.length; i++) {
                    grid[row][i] = Integer.parseInt(vals[i]);
                }
                row++;
            }
            return grid;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return new int[1][1];
    }
}