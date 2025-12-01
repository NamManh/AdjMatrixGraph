//Nam Manh Ho
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class AdjMatrixGraph {

    public static final int DEF_VERT_COUNT = 10;
    private double[][] adjMatrix;
    private int vertCount;

    // Constructor using default vertex count
    public AdjMatrixGraph() {
        this(DEF_VERT_COUNT);
    }

    // Constructor using given size
    public AdjMatrixGraph(int size) {
        if (size <= 0) size = DEF_VERT_COUNT;
        vertCount = size;
        adjMatrix = new double[size][size];
        for (int i = 0; i < size; i++) Arrays.fill(adjMatrix[i], 0.0);
    }

    // Adds edge if indices are valid and weight ≠ 0
    public void addEdge(int from, int to, double weight) {
        if (from < 0 || from >= vertCount || to < 0 || to >= vertCount) return;
        if (weight == 0.0) return;
        adjMatrix[from][to] = weight;
    }

    // Prints adjacency matrix
    public void printAdjMatrix() {
        for (int i = 0; i < vertCount; i++) {
            for (int j = 0; j < vertCount; j++) {
                System.out.print((long) adjMatrix[i][j]);
                if (j < vertCount - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Depth-first traversal starting at 0
    public void printDFS() {
        printDFSFrom(0);
    }

    public void printDFSFrom(int start) {
        if (start < 0 || start >= vertCount) return;
        boolean[] visited = new boolean[vertCount];
        dfs(start, visited);
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v);
        for (int i = 0; i < vertCount; i++)
            if (!visited[i] && adjMatrix[v][i] != 0.0)
                dfs(i, visited);
    }

    // Breadth-first traversal starting at 0
    public void printBFS() {
        printBFSFrom(0);
    }

    public void printBFSFrom(int start) {
        if (start < 0 || start >= vertCount) return;
        boolean[] visited = new boolean[vertCount];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.println(v);
            for (int i = 0; i < vertCount; i++)
                if (!visited[i] && adjMatrix[v][i] != 0.0) {
                    visited[i] = true;
                    q.add(i);
                }
        }
    }
}
