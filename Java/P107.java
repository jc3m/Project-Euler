import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class P107 {
    int width;

    public static void main(String[] args) {
        P107 runner = new P107();
        runner.run();
    }

    public void run() {
        String fp = "p107_network.txt";
        //String fp = "p107_test.txt";

        String[][] raw = readIn(fp);
        //printGrid(raw);
        Integer[][] graph = readGraph(raw);
        //printGrid(graph);
        System.out.println(total(graph));
        System.out.println(prims(graph));
        System.out.println((total(graph) - prims(graph)));
    }

    private int total(Integer[][] graph) {
        int t = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                t += graph[i][j];
            }
        }
        return t/2;
    }

    private int prims(Integer[][] graph) {
        //Integer[][] res = new Integer[width][width];
        HashSet<Integer> visited = new HashSet<Integer>();
        int weight = 0;
        visited.add(0);
        while (visited.size() != width) {
            int t[] = findMin(visited, graph);
            weight += graph[t[0]][t[1]];
            visited.add(t[1]);
        }
        return weight;
    }

    private int[] findMin(HashSet v, Integer[][] graph) {
        Iterator<Integer> itr = v.iterator();
        int[] res = {-1, -1};
        int minEdge = Integer.MAX_VALUE;
        while (itr.hasNext()) {
            int ind = itr.next();
            for (int i = 0; i < graph[ind].length; i++) {
                if (!v.contains(i) && graph[ind][i] != 0 && graph[ind][i] < minEdge) {
                    minEdge = graph[ind][i];
                    res[0] = ind;
                    res[1] = i;
                }
            }
        }
        return res;
    }

    private Integer[][] readGraph(String[][] in) {
        Integer[][] res = new Integer[width][width];
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length; j++) {
                if (in[i][j].equals("-"))
                    res[i][j] = 0;
                else
                    res[i][j] = Integer.parseInt(in[i][j]);
            }
        }
        return res;
    }

    private void printGrid(Object[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    private String[][] readIn(String filename) {
        BufferedReader br;
        String[][] res;
        String temp;
        try {
            br = new BufferedReader(new FileReader(filename));
            String[] init = br.readLine().split(",");
            width = init.length;
            res = new String[width][];
            res[0] = init;
            int counter = 1;

            while ((temp = br.readLine()) != null) {
                res[counter] = temp.split(",");
                counter++;
            }

            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[1][1];
    }
}