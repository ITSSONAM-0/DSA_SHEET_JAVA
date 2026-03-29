# 🌳 1. Tree kya hota hai?

**Tree = hierarchical data structure**

- Top node → Root
- Children nodes → connected below
- No cycles (important 🔥)

**👉 Example:**
```

        1
      /   \
     2     3
    / \
   4   5
```
# 📌 Important Terminology (INTERVIEW FAVORITE)
| Term   | Meaning              |
| ------ | -------------------- |
| Root   | Top node             |
| Parent | Node above           |
| Child  | Node below           |
| Leaf   | No children          |
| Height | Longest path (edges) |
| Depth  | Distance from root   |
| Degree | Number of children   |


# 🌳 2. Types of Trees
**1. Binary Tree**
- Max 2 children (left, right)
**2. Binary Search Tree (BST)**
- Left < Root < Right
**3. Balanced Tree**
- Height ≈ log(n)
**4. Complete Binary Tree**
- All levels filled except last (left aligned)
**5. Full Binary Tree**
- 0 or 2 children

# 🔁 3. Tree Traversals (VERY IMPORTANT)
**1. Inorder (LNR)**

Left → Node → Right
```java
void inorder(TreeNode root){
    if(root == null) return;
    inorder(root.left);
    System.out.print(root.val);
    inorder(root.right);
}
```
👉 BST me sorted output deta hai 🔥

**2. Preorder (NLR)**

Node → Left → Right
👉 Tree copy / build me use hota hai

**3. Postorder (LRN)**

Left → Right → Node
👉 Delete / bottom-up problems

**4. Level Order (BFS)**

Queue use hota hai

```java
Queue<TreeNode> q = new LinkedList<>();
q.add(root);

while(!q.isEmpty()){
    TreeNode curr = q.poll();
    System.out.print(curr.val);

    if(curr.left != null) q.add(curr.left);
    if(curr.right != null) q.add(curr.right);
}
```
# 🔥 4. Important Patterns (INTERVIEW GOLD)
**1. DFS Pattern (Recursive)**
**👉 90% tree questions**

- Height
- Diameter
- Max path sum
**2. BFS Pattern (Queue)**

**👉 Level-wise problems**

- Level order
- Right view
- Minimum depth
**3. Height Based Problems**
```java
int height(TreeNode root){
    if(root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
}
```
**4. Diameter of Tree**

👉 Longest path between two nodes

**5. Path Sum Problems**

👉 Root → leaf sum

**6. Lowest Common Ancestor (LCA)**

👉 Do nodes ka common parent

**7. Balanced Tree Check**

👉 Height difference ≤ 1

**8. Tree to Graph Thinking 🔥**

👉 Parent + child = graph

**Used in:**
- Burning tree
- Distance K
# 🌲 5. BST Special Concepts**
**Search**

O(log n)
```java
if(root.val > target) go left
else go right
```
**Insert**

Same logic as search

**Delete (INTERVIEW IMPORTANT)**

3 cases:

1. Leaf → delete
2. One child → replace
3. Two child → successor use
# 🔥 6. Most Asked Interview Questions

Ye sab MUST aata hai 👇

**Easy**
- Height of tree
- Traversals
- Count nodes
- Max depth
**Medium**
- Diameter
- LCA
- Balanced tree
- Path sum
- Level order zigzag
**Hard**
- Serialize / Deserialize
- Max path sum
- Vertical order traversal
- Burning tree

# ⚡ 7. Important Tricks
**🔹 Trick 1: Tree = Recursion**

👉 Har node pe same kaam

**🔹 Trick 2: Bottom-up vs Top-down**
| Type      | Example          |
| --------- | ---------------- |
| Top-down  | Path sum         |
| Bottom-up | Height, diameter |

**🔹 Trick 3: Global Variable Use**

👉 Diameter, max path

**💡 8. Complexity**
| Operation  | Time     |
| ---------- | -------- |
| Traversal  | O(n)     |
| BST search | O(log n) |
| Worst BST  | O(n)     |



****************
# 🌳 1. Height of Tree
**🔹 Concept**

👉 Height = longest path (edges or nodes) from root to leaf

**Example:
**
```
        1
      /   \
     2     3
    /
   4
```
- Longest path: 1 → 2 → 4
- Height = 3 nodes (ya 2 edges depending on definition)
# 🔹 Logic (MOST IMPORTANT 🔥)

**👉 Har node pe:**
```
height = 1 + max(leftHeight, rightHeight)
```
**code**
```java
class Solution {
    public int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
}
```
**🔹 Dry Run**
- Leaf node → return 1
- Parent → 1 + max(left, right)
**⏱ Complexity**
- Time: O(n)
- Space: O(h)
**🔁 2. Tree Traversals**

👉 4 types (INTERVIEW MUST)

 # **🔹 1. Inorder (LNR)**

👉 Left → Node → Right
```java
void inorder(TreeNode root) {
    if (root == null) return;

    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```
👉 BST me sorted output deta hai 🔥

**🔹 2. Preorder (NLR)**

👉 Node → Left → Right
```java
void preorder(TreeNode root) {
    if (root == null) return;

    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}
```
👉 Use: Tree copy, build tree

**🔹 3. Postorder (LRN)**

👉 Left → Right → Node
```java
void postorder(TreeNode root) {
    if (root == null) return;

    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
```
👉 Use: Delete tree, bottom-up problems

**🔹 4. Level Order (BFS)**

👉 Queue use hota hai
```java
import java.util.*;

void levelOrder(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        TreeNode curr = q.poll();
        System.out.print(curr.val + " ");

        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
    }
}
```
# 🔥 Key Difference
| Traversal   | Type |
| ----------- | ---- |
| Inorder     | DFS  |
| Preorder    | DFS  |
| Postorder   | DFS  |
| Level Order | BFS  |

# 🔢 3. Count Nodes
**🔹 Concept**

👉 Tree me total nodes count karna

**🔹 Logic**

👉 Har node:
```
count = 1 + left + right
```
**🔹 Java Code**
```java
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }
}
```

ex
```
        1
      /   \
     2     3
```
👉 Answer = 3

**⏱ Complexity**
- Time: O(n)
# 🌲 4. Max Depth (VERY IMPORTANT)

- 👉 Max Depth = Height of tree (same concept)

- ⚠️ Interview me dono alag naam se puch sakte hain but logic same hota hai

🔹 Java Code
```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
````
**🔥 Trick**

👉 Height = Depth = same (in most problems)

# 🧠 Important Observation (VERY IMPORTANT)

👉 Ye 3 problems SAME pattern follow karte hain:
| Problem | Formula              |
| ------- | -------------------- |
| Height  | 1 + max(left, right) |
| Count   | 1 + left + right     |
| Depth   | same as height       |

# 🚀 Master Pattern (INTERVIEW KEY)

👉 Har recursive tree problem:

```java
if(root == null) return base;

left = solve(root.left)
right = solve(root.right)

return combine(left, right)
````
