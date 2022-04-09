// BFS
// 如果不需要确定当前遍历到了哪一层
public void naive_bfs(node) {
    queue.offer(node);
    while (queue 不空) {
        cur = queue.poll();
        // 对当前节点做操作
        process_current(cur);
        for (节点 in cur的所有相邻节点) {
            if (该节点有效且未访问过) {
                queue.offer(该节点);
            }
        }
    }
}

// 如果需要确定当前遍历到了哪一层
public void bfs_level(node) {
    level = 0;
    queue.offer(node);
    while (queue 不空) {
        // 每次遍历一层
        size = queue.size();
        while (size -- > 0) {
            cur = queue.poll();
            // 对当前节点做操作
            process_current(cur);
            for (节点 in cur的所有相邻节点) {
                if (该节点有效且未被访问过) {
                    queue.offer(该节点);
                }
            }
            level ++;
        } 
    }
}
  
// DFS
public void dfs(node, path (此处也可以是visited数组), ...) {
    if (数据非法或者越界) {return;}
    if (node满足想要的结果条件) {
        result.add(包含node的path);
    }
    if (可以剪枝) {return;}
    for (next节点 in node的所有相邻节点) {
        把node加入path (或者把visited数组对应元素改成true);
        dfs(next, new_path, ...);
        把node从path中删除 (或者把visited数组对应元素改成false);
    }
}
