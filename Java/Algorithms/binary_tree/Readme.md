# Binary Tree

## In-order Traversal

- 中序遍历：左中右
- Without recursion: **stack**
    -  从root开始，持续把当前node放入stack，并移步到下一个左节点，直至遇到null
    -  如果当前node不是null或者stack不为空，从stack中pop一个元素，每次pop即为一个“print”的顺序结果
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
- Without recursion: 2 stacks (easier)
    - 把root放入stack1
    - 如果stack1不为空，则pop stack1的一个元素放入stack2，同时把该元素的**左node**（如果有）和**右node**（如果有）依次放入stack1
    - 如此操作直到stack1空，然后按pop出stack2的所有元素即可
- Without recursion: **stack**
    - 把**右node**和**root**依次放入stack，并移步到root的左node
    - 如果stack不为空，从stack中pop一个node元素
    - 如果该node元素有右node并且右node**在stack top**，表示右子树还没被遍历，此时需要再pop出一个元素（是右node），并且把原node再放回stack；如果该node元素有右node并且右node**不在stack top**，表示右子树已经遍历完成，只需要print该node元素
    - 如此操作，直至stack空
- Without recursion: stack算法实现
    - 用一个prev变量来track之前一次print的元素，如果当前元素的右node是prev或null，那么我们再print当前元素（利用post-order性质）
    - 持续把左node放入stack直至null
    - 还有一个current变量用来记录stack顶端看到的元素
    - 如果current的右node是prev，或者null，那么pop出stack顶端的元素（即current）并print它，更新prev为current的元素；否则表示右子树还没有遍历过，更新current到右node

## Level-order Traversal

层序遍历

## References
[1] https://stackoverflow.com/questions/33022427/how-can-i-traverse-binary-search-tree-without-recursion

[2] https://www.geeksforgeeks.org/iterative-postorder-traversal/

[3] https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/

[4] https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45648/three-ways-of-iterative-postorder-traversing-easy-explanation
