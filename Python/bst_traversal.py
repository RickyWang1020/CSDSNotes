class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# inorder traversal（中序遍历）: left-root-right
# will produce an ascending order of nodes
def inorder(node):
    # left node recursion
    if node.left:
        inorder(node.left)
    # middle node operation here
    print(node.val)
    # right node recursion
    if node.right:
        inorder(node.right)

# preorder traversal（先序遍历）: root-left-right
def preorder(node):
    # middle node operation here
    print(node.val)
    # left node recursion
    if node.left:
        preorder(node.left)
    # right node recursion
    if node.right:
        preorder(node.right)

# postorder traversal（后序遍历）: left-right-root
def postorder(node):
    # left node recursion
    if node.left:
        postorder(node.left)
    # right node recursion
    if node.right:
        postorder(node.right)
    # middle node operation here
    print(node.val)

# test

tree = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(6))

inorder(tree)
preorder(tree)
postorder(tree)
