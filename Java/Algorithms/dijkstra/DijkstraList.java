import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraList {

    int V = 110, E = 6000;
    int INF = 0x3f3f3f3f;

    // construct the adjacency list
    int[] head = new int[V], edge = new int[E], nextEdge = new int[E], weight = new int[E];
    int idx;
    // dist[x] is the shortest path length from source to x
    int[] dist = new int[V];
    // keep track of what points are visited
    boolean[] visited = new boolean[V];

    void add(int start, int end, int w) {
        edge[idx] = end;
        nextEdge[idx] = head[start];
        head[start] = idx;
        weight[idx] = w;
        idx ++;
    }

    // in g, the configuration are given as [[from, to, weight],...], such as [[2,1,1],[2,3,1],[3,4,1]]
    // n is the number of nodes
    // s is the starting node (nodes are labeled from 1 to n)
    public int[] dijkstraList(int[][] g, int n, int s) {

        // initialize the heads of the linked list
        Arrays.fill(head, -1);

        // store the given graph configurations
        for (int[] c : g) {
            int u = c[0], v = c[1], w = c[2];
            add(u, v, w);
        }

        // dijkstra algorithm using priority queue
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);
        dist[s] = 0;

        // the pq stores pairs of elements: [node index, dist[node]]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{s, 0});

        while (!pq.isEmpty()) {
            // every time pick out the node with the smallest dist
            int[] p = pq.poll();
            int node = p[0], distance = p[1];

            // skip if the node has been visited
            if (visited[node]) continue;

            // visit this node
            visited[node] = true;
            // for all the edges going out of this node, do relaxation
            for (int i = head[node]; i != -1; i = nextEdge[i]) {
                // j is the vertex that the current node is pointing to using the edge i
                int j = edge[i];
                if (dist[j] > dist[node] + weight[i]) {
                    dist[j] = dist[node] + weight[i];
                    pq.offer(new int[]{j, dist[j]});
                }
            }
        }

        return dist;
    }

}
