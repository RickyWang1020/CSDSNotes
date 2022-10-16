import java.util.Arrays;

public class DijkstraMat {

    int V = 110, E = 6000;
    int INF = 0x3f3f3f3f;
    // construct the adjacency matrix
    int[][] m = new int[V][V];
    // dist[x] is the shortest path length from source to x
    int[] dist = new int[V];
    // keep track of what points are visited
    boolean[] visited = new boolean[V];

    // in g, the configuration are given as [[from, to, weight],...], such as [[2,1,1],[2,3,1],[3,4,1]]
    // n is the number of nodes
    // s is the starting node (nodes are labeled from 1 to n)
    public int[] dijkstraMat(int[][] g, int n, int s) {

        // initialize the adjacency matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                m[i][j] = m[j][i] = (i == j) ? 0 : INF;
            }
        }
        // store the given graph configurations
        for (int[] c : g) {
            int u = c[0], v = c[1], w = c[2];
            m[u][v] = w;
        }

        // dijkstra algorithm in iterative manner
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
        dist[s] = 0;
        // iterate n times
        for (int p = 1; p <= n; p++) {
            // every time, find the node t that has the smallest dist[] and has not been visited
            int t = -1;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && (t == -1 || dist[i] < dist[t])) {
                    t = i;
                }
            }
            // visit the node t
            visited[t] = true;
            // relax on every other node with dist[t]
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[t] + m[t][i]);
            }
        }

        return dist;
    }

}
