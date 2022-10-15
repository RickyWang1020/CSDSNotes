# Topological Sort

## Application

Generate a topological ordering (i.e., if there is a directed edge from A to B, A must appear before B in the ordering) for a DAG in **`O(|V|+|E|)`** time

## Algorithm

Pick a node, perform DFS on it, if a node appears as a leaf or it points to visited nodes, add it to the front of the answer.

Repeat until all nodes are visited, return the answer.
