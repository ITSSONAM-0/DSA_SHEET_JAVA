
# 🎯 BST OPERATIONS - QUICK REFERENCE

## ⚡ TOP 5 MUST CODE

### 1️⃣ VALIDATE BST
```java
boolean isValidBST(Node root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

boolean isValidBST(Node root, long minVal, long maxVal) {
    if (root == null) return true;

    if (root.data <= minVal || root.data >= maxVal) return false;

    return isValidBST(root.left, minVal, root.data) &&
           isValidBST(root.right, root.data, maxVal);
}
```
**Key:** Use min/max bounds, not just immediate children

---

### 2️⃣ INSERT INTO BST
```java
Node insert(Node root, int value) {
    if (root == null) return new Node(value);

    if (value < root.data) {
        root.left = insert(root.left, value);
    } else if (value > root.data) {
        root.right = insert(root.right, value);
    }

    return root;
}
```
**Logic:** Left if smaller, right if larger

---

### 3️⃣ SEARCH IN BST
```java
Node search(Node root, int value) {
    if (root == null) return null;

    if (value == root.data) return root;

    return (value < root.data) 
        ? search(root.left, value) 
        : search(root.right, value);
}
```
**Time:** O(log n) average, O(n) worst (skewed)

---

### 4️⃣ DELETE FROM BST
```java
Node deleteNode(Node root, int value) {
    if (root == null) return null;

    if (value < root.data) {
        root.left = deleteNode(root.left, value);
    } else if (value > root.data) {
        root.right = deleteNode(root.right, value);
    } else {
        // Node found - 3 cases

        // Case 1: Leaf node
        if (root.left == null && root.right == null) {
            return null;
        }

        // Case 2: One child
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        // Case 3: Two children
        Node temp = root.right;
        while (temp.left != null) {
            temp = temp.left;  // smallest in right subtree
        }

        root.data = temp.data;
        root.right = deleteNode(root.right, temp.data);
    }

    return root;
}
```
**Tricky Part:** Two children case - use inorder successor

---

### 5️⃣ KTH SMALLEST
```java
int kthSmallest(Node root, int k) {
    int[] count = new int[1];   // to simulate pass-by-reference
    int[] result = new int[1];

    inorder(root, k, count, result);
    return result[0];
}

void inorder(Node node, int k, int[] count, int[] result) {
    if (node == null || count[0] >= k) return;

    inorder(node.left, k, count, result);

    count[0]++;
    if (count[0] == k) {
        result[0] = node.data;
        return;
    }

    inorder(node.right, k, count, result);
}
```
**Magic:** Inorder of BST = Sorted array ⭐

---

## 🔥 NEXT 5

| Operation | Template | Company |
|-----------|----------|---------|
| **Kth Largest** | Reverse inorder (R-Root-L) | Infosys |
| **Floor** | Go left when > target | Infosys |
| **Ceiling** | Go right when < target | TCS |
| **Successor** | Smallest in right subtree | Wipro |
| **LCA in BST** | Use BST property (O(log n)) | All |

---

## 💡 INTERVIEW SCRIPTS

### Q: "How will you validate BST?"

> "Sir, I use the bounds approach. I track min and max values.
> 
> At each node, I check if current value is within [min, max].
> - For left subtree, max becomes current value
> - For right subtree, min becomes current value
> 
> This ensures ALL left < current < ALL right.
> Time: O(n), Space: O(h)"

### Q: "Delete a node with two children?"

> "Sir, I find the inorder successor (smallest node in right subtree).
> 
> I copy the successor's value to current node.
> 
> Then I delete the successor from right subtree.
> 
> This maintains BST property."

### Q: "Find Kth smallest efficiently?"

> "Sir, inorder traversal of BST gives sorted array!
> 
> I do inorder and count. When count reaches k, I have answer.
> 
> Time: O(n) worst, but O(k) if k is small.
> Space: O(h) for recursion."

---

## ⚠️ CRITICAL MISTAKES

```java
// ❌ WRONG: Only checking immediate children
boolean isValidBST(Node root) {
    if (root.left != null && root.left.data > root.data) return false;
    // This misses violations deeper in subtree!
    return true;
}

// ✅ RIGHT: Use min/max bounds
boolean isValidBST(Node root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

boolean validate(Node root, long minVal, long maxVal) {
    if (root == null) return true;

    if (root.data <= minVal || root.data >= maxVal) return false;

    return validate(root.left, minVal, root.data) &&
           validate(root.right, root.data, maxVal);
}
```

```java
// ❌ WRONG: Not finding inorder successor properly
Node temp = root.right;
// Directly using right child (WRONG)
root.data = temp.data;

// ✅ RIGHT: Find SMALLEST in right subtree
Node temp = root.right;
while (temp.left != null) {
    temp = temp.left;  // go left until smallest
}
root.data = temp.data;
```

```java
// ❌ WRONG: Allows duplicates
if (root.data < minVal || root.data > maxVal)

// ✅ RIGHT: No duplicates allowed
if (root.data <= minVal || root.data >= maxVal)
```

---
**🔥 Node Class (Java)**
```java
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
```

## 📋 COMPANY-WISE CHECKLIST

### TCS (75% BST)
```
☐ Insert
☐ Search
☐ Validate
☐ Delete
☐ Kth Smallest
☐ Inorder = Sorted (KEY!)
```

### Infosys (85% BST)
```
☐ Everything from TCS
☐ Kth Largest (reverse inorder)
☐ Floor/Ceiling
☐ LCA in BST (using property)
☐ Successor/Predecessor
```

### Wipro (70% BST)
```
☐ Insert/Search
☐ Validate
☐ Delete (all 3 cases)
☐ Kth Smallest
☐ Successor/Predecessor
```

---

## 🎯 DELETION CASES MEMORY AID

```
       NODE_TO_DELETE

Case 1: ◯ (no children)     → DELETE
           
Case 2: ◯                   → REPLACE WITH CHILD
         └─◯
         
Case 3: ◯                   → REPLACE WITH SUCCESSOR
         ├─◯                  (smallest in right subtree)
         └─◯

Successor location:
        ◯─────────────────┐
                          ◯ (right child)
                          └─◯ (go left until null) ← SUCCESSOR
                            └─◯
```

---

## ⏱️ TIME COMPLEXITIES

| Operation | Average | Worst | Why Worst? |
|-----------|---------|-------|-----------|
| Insert | O(log n) | O(n) | Skewed tree |
| Search | O(log n) | O(n) | Skewed tree |
| Delete | O(log n) | O(n) | Skewed tree |
| Validate | O(n) | O(n) | Always visit all |
| Kth Smallest | O(n) | O(n) | Full traversal |

**Skewed tree = All nodes on one side (like linked list)**

---

## 🚀 INTERVIEW DAY TIPS

**Before coding:**
1. Clarify: Duplicates allowed?
2. Mention: "I'll use BST property for efficiency"
3. Explain approach: "I'll do inorder..." or "I'll use bounds..."

**While coding:**
1. Handle nullptr first (base case)
2. Write comparison logic clearly
3. Test on paper with dry run

**Common edge cases:**
- Single node tree
- Empty tree
- All nodes on left (skewed left)
- All nodes on right (skewed right)
- Duplicates present

---

## 📊 PATTERN DIFFICULTY

```
Easy (Can code blind):
  ├─ Insert
  ├─ Search
  ├─ Validate
  └─ Kth Smallest

Medium (Need thought):
  ├─ Delete (especially 2 children)
  ├─ Floor/Ceiling
  └─ Successor/Predecessor

Hard (Rare, study if time):
  ├─ Balanced BST
  ├─ AVL Trees
  └─ Red-Black Trees
```

---

## 💪 FINAL CHECKLIST

```
Core (MUST):
☐ Can validate BST with bounds
☐ Can insert new node
☐ Can search for node
☐ Can delete all 3 cases
☐ Understand inorder = sorted

Important:
☐ Can find Kth smallest
☐ Can find inorder successor
☐ Know why worst case is O(n)
☐ Can explain skewed tree

Nice to have:
☐ Floor/Ceiling
☐ Kth largest
☐ LCA in BST (optimized)
```

---

**Practice these 5 and you'll handle 85% BST questions!** 🌳✅
