import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private int counter; // counts the number of sets we have now
    private Map<Integer, Integer> parent; // (current, leader)
    private Map<Integer, Integer> follower_count; // (leader, number_of_followers)

    // constructor
    public UnionFind(int[] arr) {
        parent = new HashMap<>();
        follower_count = new HashMap<>();
        for (int v:arr) {parent.put(v, v);} // at the beginning, each node is its own leader
        for (int v:arr) {follower_count.put(v, 1);} // the number of followers (including itself) that the leader owns
        counter = parent.size(); // in case we have duplicated values in the array
    }

    // union two sets: given two elements, find their leaders and let one leader (usually the leader with a smaller set of followers) be the follower of the other leader (usually the leader with a larger set of followers)
    public void union(int x, int y) {
        // find the leader of element x, and find the leader of element y
        // we will make the leaders of the two groups union
        Integer root_x = find(x), root_y = find(y);
        if (root_x == null || root_y == null) {return;}
        // if x and y have the same leader, then no need to union them
        if (root_x.equals(root_y)) {return;}

        // otherwise, merge the two groups
        if (follower_count.get(root_x) >= follower_count.get(root_y)) {
            // if root_x has more followers, then let root_y also follow root_x
            follower_count.put(root_x, follower_count.get(root_x) + follower_count.get(root_y));
            follower_count.remove(root_y);
            parent.put(root_y, root_x);
        }
        else {
            // if root_y has more followers, then let root_x also follow root_y
            follower_count.put(root_y, follower_count.get(root_x) + follower_count.get(root_y));
            follower_count.remove(root_x);
            parent.put(root_x, root_y);
        }
        // since we union two sets, decrease the set counter;
        counter --;
    }

    // find the leader of a given node
    public Integer find(int n) {
        if (!parent.containsKey(n)) {return null;}
        // when we find n's leader, the leader's value in hashmap is definitely negative
        int root = n;
        while (parent.get(root) != root) {
            root = parent.get(root);
        }
        // 扁平化管理，直接让node以及它的所有中间leader指向最高的leader，避免日后找leader层级过深
        while (parent.get(n) != n) {
            int curr = n;
            n = parent.get(n);
            parent.put(curr, root);
        }
        return root;
    }

    public void printData() {
        System.out.printf("Parent list: %s \n Number of followers for every parent: %s \n Number of sets: %s\n", parent, follower_count, counter);
    }
}
