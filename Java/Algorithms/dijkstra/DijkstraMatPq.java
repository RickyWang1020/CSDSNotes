import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraMatPq {

    int V = 110;
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
    public int[] dijkstraMatPq(int[][] g, int n, int s) {

        // initialize the adjacency matrix
        // the diagonals are 0, other cells are infinite
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

        // dijkstra algorithm using priority queue
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{s, 0});
        while (!pq.isEmpty()) {

            // System.out.println(Arrays.deepToString(pq.toArray()));

            // pop out the node with currently the smallest dist from source
            int[] p = pq.poll();
            int node = p[0], d = p[1];

            // check if the current node has been visited, if yes, then skip; if no, then visit it
            if (visited[node]) continue;
            visited[node] = true;

            // iterate through all the other nodes
            for (int i = 1; i <= n; i++) {
                if (i == node) continue;
                if (dist[i] > dist[node] + m[node][i]) {
                    dist[i] = dist[node] + m[node][i];
                    pq.offer(new int[]{i, dist[i]});
                }
            }
        }

        return dist;
    }

}
