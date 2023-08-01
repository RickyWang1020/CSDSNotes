# Detect cycle in undirected graph, True means has cycle, False means has no cycle
def detectCycleUndirected(graph, n):

    def dfs(node, v, parent):
        # mark the current node as visited
        v[node] = True
        # iterate all possible next-step nodes
        for next_node in graph[node]:
            # if this next-step node is not visited, do dfs from this node
            if not v[next_node]:
                # if dfs results in a cycle, return True
                if dfs(next_node, visited, node):
                    return True
            # else, if the next-step node is visited, and it is not the current node's parent, also return True
            elif next_node != parent:
                return True
        return False

    visited = [False for _ in range(n)]

    # for every node, if it is not visited, do dfs from it
    for i in range(n):
        if not visited[i]:
            if dfs(i, visited, -1):
                return True
    return False


cyclic_graph = {
    0: [1, 2],
    1: [0, 2],
    2: [0, 1, 3],
    3: [2, 4],
    4: [3]
}
acyclic_graph = {
    0: [1],
    1: [0, 2, 4],
    2: [1, 3],
    3: [2],
    4: [1]
}
print("The first graph should be cyclic, the result is", detectCycleUndirected(cyclic_graph, 5))
print("The second graph should be acyclic, the result is", detectCycleUndirected(acyclic_graph, 5))


# Detect cycle in directed graph
def detectCycleDirected(graph, n):
    def dfs(node, visited):
        # if the current node is being visited, it means there is a cycle
        if visited[node] == 2:
            return True
        # if the current node has been visited, we can just return
        if visited[node] == 1:
            return False

        # mark current node as visiting
        visited[node] = 2
        # for every next-step node, do dfs from it
        for next_node in graph[node]:
            if dfs(next_node, visited):
                return True
        # after finishing dfs of all next-step nodes, mark current node as visited
        visited[node] = 1
        return False

    # 0 means not visited, 1 means has visited, 2 means visiting (if meet a node with status 2 then means a cycle)
    visited = [0 for _ in range(n)]

    # for every node, do dfs from it to see if there is cycle
    for i in range(n):
        if dfs(i, visited):
            return True
    return False


cyclic_digraph = {
    0: [1, 2],
    1: [2, 3],
    2: [3, 4],
    3: [4, 0],
    4: [1]
}
acyclic_digraph = graph_d = {
    0: [1, 2],
    1: [3, 4],
    2: [5, 6],
    3: [7],
    4: [7],
    5: [8],
    6: [9],
    7: [],
    8: [],
    9: []
}

print("The first digraph should be cyclic, the result is", detectCycleDirected(cyclic_digraph, 5))
print("The second digraph should be acyclic, the result is", detectCycleDirected(acyclic_digraph, 10))
