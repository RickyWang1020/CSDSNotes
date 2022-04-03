## Binary Tree

### In-order Traversal

- 中序遍历：左中右
- Without recursion: **stack**
    -  从root开始，持续把左node放入stack直至遇到null
    -  从stack中开始pop元素，每次pop即为一个“print”的顺序结果
    -  对于pop出的node，查看它有没有右node，如果有的话将这个右node也放入stack
    -  对于这个右node，持续把它的左node放入stack直至null
    -  如此操作直到stack空

### Pre-order Traversal

先序遍历：中左右

### Post-order Traversal

后序遍历：左右中

### Level-order Traversal

层序遍历
