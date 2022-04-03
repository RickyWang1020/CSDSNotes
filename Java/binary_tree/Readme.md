# Binary Tree

## In-order Traversal

- 中序遍历：左中右
- Without recursion: **stack**
    -  从root开始，持续把当前node放入stack，并移步到下一个左节点，直至遇到null
    -  如果当前node不是null或者stack不为空，从stack中pop元素，每次pop即为一个“print”的顺序结果
    -  对于pop出的node，查看它有没有右node，如果有的话将这个右node也放入stack
    -  对于这个右node，持续把它的左node放入stack直至null
    -  如此操作，直到node为null或者stack空

## Pre-order Traversal

- 先序遍历：中左右
- Without recursion: **stack**
    - 先把root放入stack
    - 当stack不为空的时候，从stack中pop出一个元素，print该元素
    - 把该元素的**右node**（如果有）和**左node**（如果有）依次放入stack
    - 如此操作，直至stack空

## Post-order Traversal

- 后序遍历：左右中
- Without recursion: **stack**
    - 把**右node**和**root**依次放入stack，并移步到root的左node，直至遇到null
    - 如果stack不为空，从stack中pop一个node元素
    - 如果该node元素有右node并且右node**在stack top**，表示右子树还没被遍历，此时需要再pop出一个元素（是右node），并且把原node再放回stack；如果该node元素有右node并且右node**不在stack top**，表示右子树已经遍历完成，只需要print该node元素
    - 如此糙走，直至stack为空

## Level-order Traversal

层序遍历

## References

https://stackoverflow.com/questions/33022427/how-can-i-traverse-binary-search-tree-without-recursion
