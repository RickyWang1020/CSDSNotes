// 1. adjacency matrix
// Good for dense graph (many edges): |E| approx |V|^2

// m[a][b] = c means: an edge from a to b with weight c
int[][] m = new int[V][V]

// adding an edge in the graph
void add(int start, int end, int w) {
    m[start][end] = w;
}


// 2. adjacency list
// Good for sparse graph: |E| approx |V|

// head: (initialized with all -1) store the head pointer for the "linked list" storing the set of edges associated with one node
// edge: store the node that one edge points to
// nextEdge: 
// weight: store the weight of an edge
int[] head = new int[V], edge = new int[E], nextEdge = new int[E], weight = new int [E];
// idx is for numbering the edges
int idx;

void add(int start, int end, int w) {
    edge[idx] = end;
    nextEdge[idx] = head[start];
    head[start] = idx;
    weight[idx] = w;
    idx ++;
}

// to iterate all edges that starts from a
for (int i = head[a]; i != -1; i = nextEdge[i]) {
    // there exists an edge from a to b, with weight c
    int b = edge[i], c = weight[i];
}


// 3. class definition
// fewer used

class Edge {
    int start, end, weight;
    Edge(int _start, int _end, int _weight) {
        start = _start;
        end = _end;
        weight = _weight;
    }
}

// use a list to store all edge objects
List<Edge> es = new ArrayList<>();

for (Edge e: es) {
    // do something
}
