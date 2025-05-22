import java.util.*;

public class Main {

    // Function to check if it's safe to color the current 
    // vertex with the given color
    static boolean issafe(int vertex, int col, List<Integer>[] adj,
                                                 int[] color) {
                                                     
        for (int it : adj[vertex]) {
            // If adjacent vertex has the same color, not safe
            if (color[it] != -1 && col == color[it])
                return false;
        }
        return true;
    }

    // Recursive function to try all colorings
    static boolean cancolor(int vertex, int m, List<Integer>[] adj, 
                                                          int[] color) {
                                                              
        // If all vertices are colored successfully
        if (vertex == color.length)
            return true;

        // Try all colors from 0 to m-1
        for (int i = 0; i < m; i++) {
            if (issafe(vertex, i, adj, color)) {
                color[vertex] = i;
                if (cancolor(vertex + 1, m, adj, color))
                    // If the rest can be colored, return true
                    return true;
                color[vertex] = -1;
            }
        }

        return false; // No valid coloring found
    }

    static boolean graphColoring(int v, int[][] edges, int m) {
        List<Integer>[] adj = new ArrayList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new ArrayList<>();

        // Build adjacency list from edges
        for (int[] it : edges) {
            adj[it[0]].add(it[1]);
            adj[it[1]].add(it[0]);
        }

        int[] color = new int[v];
        Arrays.fill(color, -1);
        return cancolor(0, m, adj, color);
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2},{0,3}, {1, 3}, {2, 3}};
        int m = 3;

        // Check if the graph can be colored with m colors 
        // such that no adjacent nodes share the same color
        System.out.println(graphColoring(V, edges, m) ? "true" : "false");
    }
}