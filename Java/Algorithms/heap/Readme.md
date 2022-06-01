# Heap

## Array Representation of Binary Tree

- **Complete BT**: the second last level is full, and the last level from left to right is completely filled (i.e., in the array representation, there is no gap in between nodes)
- **Full BT**: the leaf nodes all have the same heights
- Full BT is also a Complete BT

## Min/Max Heap Concepts

- Is a **Complete Binary Tree**
- Min heap: Parent Node is Always `<=` Children Nodes; Max heap: Parent Node is Always `>=` Children Nodes
- If `N` is the parent node's index, then `2N` is left child node, `2N+1` is right child node

## Inserting an element 

In a Max heap:

- Put the new element at the end of heap array (in tree representation, it will be the position next to the last leaf node)
- Compare this element with its parent, grandparent,..., and swap upwards if this element is `>` its parent value
- Stop until this element is `<=` its parent value
- Time complexity: `O(logn)`

## Deleting an element 

In a Max heap: **(We are only allowed to remove the Root element from heap)**

- Delete the root element and put the last leaf node to the root's place
- Compare the current top element with the max of its two children, and swap downwards (with the max of the two children) if the current top value `<` the max of two children values
- Stop until the current element `>=` both of its chlidren values
- Time complexity: `O(logn)`

## Heap Sort

- **Insert** every element into the heap, and then **Delete** every element from the heap, so that the elements are sorted
- Time complexity: `O(nlogn)`

## Priority Queue
