import java.util.LinkedList;
import java.util.Arrays;

public class Graph {
    int V;
    int E;
    LinkedList<Integer>[] grid;
    int[] weights;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        grid = new LinkedList[V];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new LinkedList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public LinkedList<Integer> neighbors(int a) {
        return grid[a];
    }

    public void addEdge(int ind1, int ind2) {
        grid[ind1].add(ind2);
        E++;
    }

    public void addWeights(int[] weights) {
        this.weights = weights;
    }

    public void printWeights() {
        System.out.println(Arrays.toString(weights));
    }

    public int getWeight(int v1, int v2) {
        return weights[v2];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : grid[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}