import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinTree {

    // inorder traversal, iterative using a stack
    static List<Integer> inOrderStack(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        // a pointer to the "current node"
        TreeNode cur = node;
        while (cur != null || !s.isEmpty()) {
            // continue to go left and push the left child to the stack
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            // pop out the top node in stack
            cur = s.pop();
            result.add(cur.val);
            // see whether the current node has right child
            cur = cur.right;
        }
        return result;
    }

    // preorder traversal, iterative using a stack
    static List<Integer> preOrderStack(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (node == null) {return result;}
        s.push(node);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            result.add(cur.val);
            if (cur.right != null) {s.push(cur.right);}
            if (cur.left != null) {s.push(cur.left);}
        }
        return result;
    }

    // postorder traversal, iterative using two stacks
    static List<Integer> postOrderTwoStack(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (node == null) {return result;}
        s1.push(node);
        // iteratively put root to s2 and put root's children to s1
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) {s1.push(cur.left);}
            if (cur.right != null) {s1.push(cur.right);}
        }
        // collect results from s2
        while (!s2.empty()) {
            result.add(s2.pop().val);
        }
        return result;
    }

    // postorder traversal, iterative using a stack
    static List<Integer> postOrderStack(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (node == null) {return result;}
        TreeNode cur = node;
        TreeNode prev = null;
        while (cur != null || !s.isEmpty()) {
            // continue to go to the very left
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            // take the top one on the stack as the current node
            cur = s.peek();
            // only when the current node has no right child or the previously printed element is current's right child
            // we will print the current node (because post-order prints the middle node at the end)
            if (cur.right == null || prev == cur.right) {
                result.add(cur.val);
                s.pop();
                prev = cur;
                cur = null;
            }
            // otherwise, continue the exploration on the right side
            else {
                cur = cur.right;
            }
        }
        return result;
    }


    static void inOrderRecur(TreeNode node) {
        if (node.left != null) {inOrderRecur(node.left);}
        System.out.printf("%s ", node.val);
        if (node.right != null) {inOrderRecur(node.right);}
    }

    static void preOrderRecur(TreeNode node) {
        System.out.printf("%s ", node.val);
        if (node.left != null) {preOrderRecur(node.left);}
        if (node.right != null) {preOrderRecur(node.right);}
    }

    static void postOrderRecur(TreeNode node) {
        if (node.left != null) {postOrderRecur(node.left);}
        if (node.right != null) {postOrderRecur(node.right);}
        System.out.printf("%s ", node.val);
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(3, new TreeNode(9, new TreeNode(1, new TreeNode(2), new TreeNode(4)), null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        // the iterative approaches to traversal
        List<Integer> inorder = inOrderStack(test);
        System.out.println(inorder);
        List<Integer> preorder = preOrderStack(test);
        System.out.println(preorder);
        List<Integer> postorder_2s = postOrderTwoStack(test);
        System.out.println(postorder_2s);
        List<Integer> postorder_s = postOrderStack(test);
        System.out.println(postorder_s);

        // the recursive approaches to traversal
        inOrderRecur(test);
        System.out.println();
        preOrderRecur(test);
        System.out.println();
        postOrderRecur(test);
        System.out.println();

    }
}
