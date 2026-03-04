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



# 1️⃣ Kth Largest Element in Array

**Idea → Min Heap of size k**

**Steps:**
- Heap me numbers add karo
- Agar size k se bada ho → remove smallest
- End me heap top = kth largest

**Java Code**
```java
import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
```
**Time Complexity**

O(n log k)

# 2️⃣ Top K Frequent Elements

**Idea → HashMap + Min Heap**

**Steps**
- Frequency count
- Heap maintain size k

```java
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num,0)+1);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int key : map.keySet()){

            pq.add(new int[]{key,map.get(key)});

            if(pq.size()>k)
                pq.poll();
        }

        int[] res = new int[k];
        int i=0;

        while(!pq.isEmpty())
            res[i++] = pq.poll()[0];

        return res;
    }
}
```
# 3️⃣ K Closest Points to Origin

Distance formula
```
sqrt(x² + y²)
```
Use Max Heap

**Java Code**
```java
import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->

                (b[0]*b[0]+b[1]*b[1]) -
                (a[0]*a[0]+a[1]*a[1])
            );

        for(int[] p : points){

            pq.add(p);

            if(pq.size() > k)
                pq.poll();
        }

        int[][] res = new int[k][2];

        for(int i=0;i<k;i++)
            res[i] = pq.poll();

        return res;
    }
}
```
# 4️⃣ Merge K Sorted Lists

- Idea → Min Heap
- Heap me har list ka smallest node rakho.

**Java Code**
```java
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode node : lists)
            if(node != null)
                pq.add(node);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(!pq.isEmpty()){

            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if(node.next != null)
                pq.add(node.next);
        }

        return dummy.next;
    }
}
```
**Time**

O(N log K)

# 5️⃣ Find Median from Data Stream

**Use Two Heaps**
| Heap     | Work       |
| -------- | ---------- |
| Max Heap | left half  |
| Min Heap | right half |

```java
import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>((a,b)->b-a);

    PriorityQueue<Integer> minHeap =
        new PriorityQueue<>();

    public void addNum(int num){

        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian(){

        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
```
# 6️⃣ Kth Smallest Element in Sorted Matrix

Idea → Min Heap

```java
import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a,b)->b-a);

        for(int[] row : matrix){
            for(int num : row){

                pq.add(num);

                if(pq.size() > k)
                    pq.poll();
            }
        }

        return pq.peek();
    }
}
```
# 7️⃣ Task Scheduler

Idea → Max Heap + Greedy

**Steps**
```
1 count frequency
2 max heap
3 execute tasks
```
**Java Code**
```java
import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(char c : tasks)
            freq[c-'A']++;

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a,b)->b-a);

        for(int f : freq)
            if(f>0) pq.add(f);

        int time = 0;

        while(!pq.isEmpty()){

            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;

            while(cycle>0 && !pq.isEmpty()){

                int f = pq.poll()-1;

                if(f>0)
                    temp.add(f);

                time++;
                cycle--;
            }

            for(int t : temp)
                pq.add(t);

            if(pq.isEmpty()) break;

            time += cycle;
        }

        return time;
    }
}
```
# 8️⃣ Reorganize String
- Idea → Max Heap
- Goal → same letters adjacent nahi hone chahiye.

**Java Code**
```java
import java.util.*;

class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        for(char c : s.toCharArray())
            freq[c-'a']++;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int i=0;i<26;i++)
            if(freq[i]>0)
                pq.add(new int[]{i,freq[i]});

        StringBuilder sb = new StringBuilder();

        while(pq.size()>=2){

            int[] a = pq.poll();
            int[] b = pq.poll();

            sb.append((char)(a[0]+'a'));
            sb.append((char)(b[0]+'a'));

            if(--a[1]>0) pq.add(a);
            if(--b[1]>0) pq.add(b);
        }

        if(!pq.isEmpty()){

            if(pq.peek()[1]>1)
                return "";

            sb.append((char)(pq.poll()[0]+'a'));
        }

        return sb.toString();
    }
}
```
