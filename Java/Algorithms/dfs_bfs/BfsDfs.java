// BFS
// 如果不需要确定当前遍历到了哪一层
public void naive_bfs(node) {
    queue.offer(node);
    while (queue 不空) {
        cur = queue.poll();
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
            for (节点 in cur的所有相邻节点) {
                if (该节点有效且未被访问过) {
                    queue.offer(该节点);
                }
            }
            level ++;
        } 
    }
}
  
