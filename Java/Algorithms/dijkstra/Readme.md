# Dijkstra Algorithm for Single-Source Shortest Path

## Relaxation

`d[x]` is the shortest path length from source to a vertex `x`, `c(x,y)` is the cost of a direct path from `x` to `y`. Let `u`, `v` be two vertices:

```
if (d[u] + c(u,v) < d[v]):
  d[v] = d[u] + c(u, v)
```

## Algorithm

1. Initialization: start from the source node, write down all nodes' `d` value (if a node is not reachable from source, its `d` is infinity)
2. Pick the node with the smallest `d` value, check all its connected nodes **that have not been picked**, perform relaxations
3. Repeat step 2 until all nodes are picked, output the shortest paths lengths (`d`) from source to all other nodes

Time complexity: `O(|V|^2)` (if all the nodes are connected to each other)

## Implementation

1. Graph construction: adjacency list or adjacency matrix
2. `dist[]` array for shortest paths lengths
3. `visited[]` array for tracking whether a node has been settled down
4. Iterative method or Priority Queue method

## Drawback

- If there is a negative weight edge, it might work, or it might not work
