# 1️⃣ Heap Kya Hota Hai

**Heap = Special Binary Tree (Priority Queue)**

**Types:**
| Heap Type    | Rule                    |
| ------------ | ----------------------- |
| **Min Heap** | smallest element top pe |
| **Max Heap** | largest element top pe  |

Example (Min Heap):
```
        1
      /   \
     3     5
    / \
   7   9
```
Top element → minimum

# 2️⃣ Java Me Heap Kaise Use Karte Hai

**Java me PriorityQueue use hota hai.**

**Min Heap:**
```java

PriorityQueue<Integer> pq = new PriorityQueue<>();
```
**Max Heap**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
```
# 3️⃣ Heap Pattern Kab Use Hota Hai

**Question me agar ye words aaye 👇**
| Keyword              | Pattern  |
| -------------------- | -------- |
| Top K                | Heap     |
| Kth largest          | Heap     |
| Kth smallest         | Heap     |
| Smallest element     | Min Heap |
| Largest element      | Max Heap |
| K closest            | Heap     |
| Merge K sorted lists | Heap     |

# 4️⃣ Heap Pattern Kyu Use Karte Hai

**Example:**

**Array:**
[7,2,9,4,1,6]
Find 3rd largest

**Method 1 (Sort)**
O(n log n)

**Method 2 (Heap)**
O(n log k)
Much faster when k small ho

# 5️⃣ Heap Pattern Template

**Top K Largest**
```
1 → Min heap banao
2 → elements add karo
3 → size > k ho to remove karo
4 → end me heap me k largest honge
```
**Java Template**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

for(int num : nums){

    pq.add(num);

    if(pq.size() > k){
        pq.poll();
    }
}

return pq.peek();
```

# 6️⃣ Important Heap Patterns

**1️⃣ Kth Largest Element**

**Example:**
```
Input:
[3,2,1,5,6,4]
k = 2

Output:
5
```
Approach → Min Heap size k

** 2️⃣ Top K Frequent Elements**

**Example:**
```
nums = [1,1,1,2,2,3]
k = 2
```
Output:
```
[1,2]
```
Use:
```
HashMap + Heap
```
**3️⃣ K Closest Points to Origin**
```
points = [[1,3],[-2,2]]
k = 1
```
Use:
```
Max Heap
```
**4️⃣ Merge K Sorted Lists**

Very famous interview question.

**Use:**
```
Min Heap
```
Time Complexity
```
O(N log K)
```
# 5️⃣ Sliding Window Maximum

**Use:**
```
Max Heap
```
# 7️⃣ Heap Problem Solving Flow

Interview me step:

```
1 → check if Top / K / Largest / Smallest
2 → decide Min heap or Max heap
3 → heap size = k
4 → iterate array
5 → maintain heap
```
# 8️⃣ Heap vs Sorting
| Method  | Time       |
| ------- | ---------- |
| Sorting | O(n log n) |
| Heap    | O(n log k) |

**Heap best when:**
```
k << n
```
#  Interview Trick

**Agar question me:**
```
Top
K
Closest
Frequent
Smallest
Largest
```

