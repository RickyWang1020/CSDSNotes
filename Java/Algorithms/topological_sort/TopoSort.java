import java.util.*;

public class TopoSort {
    static int V = (int) 1e4 + 10, E = 4 * V;
    static int idx;

    // adjacency list implementation
    static int[] head = new int[V], edge = new int[E], nextEdge = new int[E];
    // keep track of the in-degree of each node
    static int[] in = new int[E];

    static void add(int start, int end) {
        edge[idx] = end;
        nextEdge[idx] = head[start];
        head[start] = idx;
        idx ++;
        in[end] ++;
    }

    // n is the number of nodes
    // in g, the configuration are given as [[from, to],...], such as [[2,1],[1,3],[3,4]]
    public static List<Integer> topoSort(int n, int[][] g) {

        Arrays.fill(head, -1);
        for (int[] c: g) {
            add(c[0], c[1]);
        }

        LinkedList<Integer> result = new LinkedList<>();
        // put all the nodes with in-degree 0 into the deque
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                d.add(i);
            }
        }
        // topological sort
        while (!d.isEmpty()) {
            // pop a node with in-degree 0 from the deque
            int node = d.poll();
            result.addLast(node);
            // iterate through all its outgoing edges, and remove all these edges
            for (int i = head[node]; i != -1; i = nextEdge[i]) {
                int nextn = edge[i];
                // find the potential nodes with in-degree 0 and add to deque
                if (--in[nextn] == 0) {
                    d.add(nextn);
                }
            }
        }

        return (result.size() == n) ? result : new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        int[][] graph = new int[6][2];
        graph[0] = new int[]{5, 0};
        graph[1] = new int[]{4, 0};
        graph[2] = new int[]{4, 1};
        graph[3] = new int[]{3, 1};
        graph[4] = new int[]{2, 3};
        graph[5] = new int[]{5, 2};
        System.out.println(Arrays.deepToString(graph));
        List<Integer> res = topoSort(6, graph);
        System.out.println(res);

    }
}
