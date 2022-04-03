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

    static List<Integer> inOrder(TreeNode node) {
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
        TreeNode test = new TreeNode(3, new TreeNode(9, new TreeNode(1), null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        // the iterative approaches to traversal
        List<Integer> inorder = inOrder(test);
        System.out.println(inorder);

        // the recursive approaches to traversal
        inOrderRecur(test);
        System.out.println();
        preOrderRecur(test);
        System.out.println();
        postOrderRecur(test);
        System.out.println();

    }
}