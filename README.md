# **DSA Full Notes in Java **

---

## **1. Time & Space Complexity**

### **Big-O Notation**

* O(1) – Constant
* O(n) – Linear
* O(log n) – Logarithmic
* O(n log n) – Merge Sort, QuickSort (avg)
* O(n²) – Bubble, Insertion, Selection Sort

### **Diagram: Complexity Comparison**

```
Time ↑
|        n²
|      /
|     /
|    /  n log n
|   /  /
|  /  /   n
| /  /   /
|/  /   /   log n
+----------------------→ Input Size
```

---

## **2. Arrays**

### **Basics**

* Fixed size
* Contiguous memory
* Fast access → O(1)

### **Java Example**

```java
int[] arr = {1, 2, 3, 4};
System.out.println(arr[2]); // 3
```

### **Sliding Window Example**

```java
public int maxSubArray(int[] nums, int k){
    int sum = 0;
    for(int i = 0; i < k; i++) sum += nums[i];

    int max = sum;
    for(int i = k; i < nums.length; i++){
        sum += nums[i] - nums[i-k];
        max = Math.max(max, sum);
    }
    return max;
}
```

---

## **3. Strings**

### **String vs StringBuilder**

* String → Immutable
* StringBuilder → Mutable, Fast

### **Check Palindrome**

```java
boolean isPalindrome(String s){
    int i = 0, j = s.length() - 1;
    while(i < j){
        if(s.charAt(i) != s.charAt(j)) return false;
        i++; j--;
    }
    return true;
}
```

---

## **4. Hashing**

### **Data Structures**

* HashMap → Key-Value
* HashSet → Unique values

### **Frequency Map**

```java
HashMap<Character, Integer> map = new HashMap<>();
for(char c : s.toCharArray())
    map.put(c, map.getOrDefault(c, 0) + 1);
```

### **Diagram: HashMap Buckets**

```
Index: 0   → (null)
Index: 1   → (K1,V1) -> (K5,V5)
Index: 2   → (K2,V2)
Index: 3   → (null)
Index: 4   → (K3,V3)
```

---

## **5. Recursion & Backtracking**

### **Recursion Tree of Fibonacci(4)**

```
           f(4)
         /     \
      f(3)     f(2)
     /   \     /  \
  f(2)  f(1) f(1) f(0)
```

### **Recursion Code**

```java
int fib(int n){
    if(n <= 1) return n;
    return fib(n-1) + fib(n-2);
}
```

### **Backtracking Example: Subsets**

```java
void solve(int idx, int[] nums, List<Integer> curr, List<List<Integer>> ans){
    ans.add(new ArrayList<>(curr));
    for(int i = idx; i < nums.length; i++){
        curr.add(nums[i]);
        solve(i + 1, nums, curr, ans);
        curr.remove(curr.size() - 1); // BACKTRACK
    }
}
```

---

## **6. Searching**

### **Binary Search**

```java
int bs(int[] arr, int target){
    int l = 0, r = arr.length - 1;
    while(l <= r){
        int mid = (l + r) / 2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return -1;
}
```

### **Diagram**

```
[2, 4, 7, 9, 12]
       ↑ mid
```

---

## **7. Sorting**

### **Merge Sort**

```java
void mergeSort(int[] arr, int l, int r){
    if(l >= r) return;
    int mid = (l + r) / 2;
    mergeSort(arr, l, mid);
    mergeSort(arr, mid+1, r);
    merge(arr, l, mid, r);
}
```

---

## **8. Linked List**

### **Reverse Linked List (MOST ASKED)**

```java
Node reverse(Node head){
    Node prev = null;
    Node curr = head;
    while(curr != null){
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

### **Diagram**

```
1 → 2 → 3 → null
↓
3 → 2 → 1 → null
```

---

## **9. Stack**

### **Next Greater Element**

```java
int[] nge(int[] arr){
    int n = arr.length;
    int[] res = new int[n];
    Stack<Integer> st = new Stack<>();

    for(int i = n-1; i >= 0; i--){
        while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
        res[i] = st.isEmpty() ? -1 : st.peek();
        st.push(arr[i]);
    }
    return res;
}
```

---

## **10. Queue**

### **Using LinkedList**

```java
Queue<Integer> q = new LinkedList<>();
q.add(10);
q.add(20);
q.poll(); // removes 10
```

---

## **11. Trees**

### **Binary Tree Traversals**

```java
void inorder(Node root){
    if(root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

### **Tree Diagram**

```
       5
     /   \
    3     7
   / \   / \
  2  4  6   8
```

---

## **12. Binary Search Tree (BST)**

### **Insert in BST**

```java
Node insert(Node root, int val){
    if(root == null) return new Node(val);
    if(val < root.val) root.left = insert(root.left, val);
    else root.right = insert(root.right, val);
    return root;
}
```

---

## **13. Graphs**

### **BFS**

```java
void bfs(int start, List<List<Integer>> graph){
    boolean[] vis = new boolean[graph.size()];
    Queue<Integer> q = new LinkedList<>();

    q.add(start);
    vis[start] = true;

    while(!q.isEmpty()){
        int node = q.poll();
        System.out.print(node + " ");
        for(int nbr : graph.get(node)){
            if(!vis[nbr]){
                vis[nbr] = true;
                q.add(nbr);
            }
        }
    }
}
```

### **Graph Diagram**

```
0 —— 1 —— 2
|     \
|      3
4
```

---

## **14. Heaps**

### **Using PriorityQueue**

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
pq.add(10);
pq.add(5);
pq.add(20);
System.out.println(pq.poll()); // 5
```

---

## **15. Greedy Algorithms**

### **Activity Selection**

```java
Arrays.sort(activities, (a,b) -> a.end - b.end);
```

---

## **16. Dynamic Programming (DP)**

### **Fibonacci (DP)**

```java
int fib(int n){
    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++)
        dp[i] = dp[i-1] + dp[i-2];
    return dp[n];
}
```

---

## **17. Bit Manipulation**

### **Check if Number is Power of 2**

```java
boolean isPowerOf2(int n){
    return (n & (n-1)) == 0;
}
```

---

## **18. Trie**

```java
class Trie{
    class Node{ Node[] children = new Node[26]; boolean end; }
    Node root = new Node();

    void insert(String word){
        Node cur = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(cur.children[idx] == null)
                cur.children[idx] = new Node();
            cur = cur.children[idx];
        }
        cur.end = true;
    }
}
```

---



# **Core DSA Theory + Code Explanation (Beginner Friendly)**

## **1. What is DSA? (Theory)**

DSA ka matlab **Data Structures and Algorithms**.

* **Data Structures** → Data ko store aur organize karne ka tarika.
* **Algorithms** → Kisi problem ko solve karne ka step-by-step procedure.

### **Why DSA important?**

* Problem‑solving skills improve hoti hain.
* Coding interviews me 90% questions DSA ke hotey hain.
* Efficient code likhna sikhata hai.

---

## **2. Array – Basic Concept + Code Explanation**

### **Theory**

* Array ek **continuous memory block** hota hai.
* Index-based access hota hai → O(1) time.
* Size fixed hota hai.

### **Diagram**

```
Index: 0  1  2  3  4
Data: 10 20 30 40 50
```

### **Java Example + Explanation**

```java
int[] arr = {10, 20, 30, 40};
System.out.println(arr[2]); // 2nd index = 30
```

* Array create hua
* Values store hui
* Index se O(1) me access kiya

---

## **3. String – Theory + Code**

### **Theory**

* String **immutable** hoti hai.
* Ek baar create hone ke baad modify nahi hoti.
* StringBuilder mutable hota hai → Fast.

### **Code: Reverse String using Two Pointers**

```java
String s = "hello";
int i = 0, j = s.length() - 1;
while(i < j){
    if(s.charAt(i) != s.charAt(j)){
        // check
    }
    i++; j--;
}
```

**Concept** → Two pointers start and end se move karte hain.

---

## **4. HashMap – Basic Theory + Code**

### **Theory**

* **Key–Value** pair store karta hai.
* Searching O(1) average.
* Hash function value ko bucket me map karta hai.

### **Code Example**

```java
HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 3);
map.put("banana", 5);
System.out.println(map.get("apple")); // 3
```

### **Explanation**

* `put()` → data insert hota hai
* `get()` → key ke through value milti hain

---

## **5. Recursion – Theory + Code Explanation**

### **Theory**

Recursion = jab function khud ko call kare.

### **Example: Factorial**

```java
int fact(int n){
    if(n == 1) return 1;        // base case
    return n * fact(n - 1);     // recursive case
}
```

### **Explanation**

* Base case → recursion ko stop karta hai
* Recursive case → function khud ko call karta hai

---

## **6. Binary Search – Concept + Code**

### **Theory**

Binary Search tab use hota hai jab data **sorted** ho.

* Middle element compare hota hai.
* Search space half hota rehta hai.
* Time → O(log n)

### **Code**

```java
int bs(int[] arr, int target){
    int l = 0, r = arr.length - 1;
    while(l <= r){
        int mid = (l + r) / 2;
        if(arr[mid] == target) return mid;
        if(arr[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return -1;
}
```

### **Explanation**

* middle calculate hota hai
* compare hota hai
* half array remove hota hai

---

## **7. Linked List – Basic Concept + Code**

### **Theory**

LinkedList nodes ka chain hota hai.
Har node ke paas:

* value
* next pointer

### **Diagram**

```
10 → 20 → 30 → null
```

### **Reverse Linked List Code**

```java
Node reverse(Node head){
    Node prev = null;
    Node curr = head;
    while(curr != null){
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

### **Explanation**

* Pointers change hotey hain
* Links reverse hote hain

---

## **8. Stack – Concept + Example**

### **Theory**

* LIFO (Last in First out)
* Example → Undo, Browser back

### **Code**

```java
Stack<Integer> st = new Stack<>();
st.push(10);
st.push(20);
st.pop(); // 20
```

---

## **9. Queue – Concept + Example**

### **Theory**

* FIFO (First in First out)
* Example → Ticket line, CPU scheduling

### **Code**

```java
Queue<Integer> q = new LinkedList<>();
q.add(5);
q.add(10);
q.poll(); // removes 5
```

---

## **10. Tree – Basic Theory**

* Tree = Hierarchical structure
* Binary Tree → har node ke 2 children max

### **Traversals**

* Inorder → Left Root Right
* Preorder → Root Left Right
* Postorder → Left Right Root

### **Code**

```java
void inorder(Node root){
    if(root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

---

## **11. Graph – Theory + BFS Code**

### **Theory**

Graph nodes and edges ka collection hota hai.

* BFS queue use karta hai
* DFS stack/recursion

### **BFS Code**

```java
void bfs(int start, List<List<Integer>> graph){
    boolean[] vis = new boolean[graph.size()];
    Queue<Integer> q = new LinkedList<>();

    q.add(start);
    vis[start] = true;

    while(!q.isEmpty()){
        int node = q.poll();
        System.out.print(node + " ");
        for(int nbr : graph.get(node)){
            if(!vis[nbr]){
                vis[nbr] = true;
                q.add(nbr);
            }
        }
    }
}
```

---

## **12. DP (Dynamic Programming) – Basic Explanation**

### **Theory**

DP = Recursion + Optimization.

* Memoization → top-down
* Tabulation → bottom-up

### **Code: Fibonacci DP**

```java
int fib(int n){
    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++)
        dp[i] = dp[i-1] + dp[i-2];
    return dp[n];
}
```

---
# Good luck....
