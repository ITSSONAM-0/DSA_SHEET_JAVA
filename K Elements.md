# 🔷 1️⃣ Top K Elements Pattern Kya Hai?

**Jab question me bola jaye:**

- Top K largest elements
- K smallest numbers
- K most frequent elements
- K closest points
- Kth largest / Kth smallest

**👉 Tab 90% cases me Heap (Priority Queue) use hota hai.**

# 🔷 2️⃣ Ye Pattern Kyu Use Karte Hain?

**Agar brute force kare:**
- Array sort karo → O(N log N)
- First K ya last K le lo

**⛔ Problem: Agar N bahut bada hai aur K chhota hai (jaise N=1e6, K=10)

Sorting poora array waste hai ❌**

**✅ Optimized Approach**

Heap ka size sirf K rakho

Time Complexity = O(N log K)

👉 N log K << N log N
Jab K << N ho to bahut fast 🚀

# 🔷 3️⃣ Kaise Decide Kare – Min Heap ya Max Heap?
| Situation    | Heap Type         |
| ------------ | ----------------- |
| K Largest    | Min Heap (size K) |
| K Smallest   | Max Heap (size K) |
| Kth Largest  | Min Heap          |
| Kth Smallest | Max Heap          |

# 🔷 4️⃣ Intuition – K Largest Example

**Array:**
```</>
[3,2,1,5,6,4]
K = 2
```
Goal → 2 largest numbers

**Step Logic:**
1. First K elements heap me daalo
2.  Har naye element ke liye:
   -  Agar current element heap ke smallest se bada hai
   -  To heap me daalo aur smallest hata do

**Heap size kabhi K se bada nahi hoga.**
# 🔷 5️⃣ Java Code – K Largest Elements
```</>java
import java.util.*;

public class Solution {
    public static List<Integer> findKLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        return new ArrayList<>(minHeap);
    }
}
```
**Time = O(N log K)**

# 🔷 6️⃣ Kaha Use Hota Hai?
✅ 1. Kth Largest Element

✅ 2. Top K Frequent Elements

Frequency map + Min Heap

✅ 3. K Closest Points to Origin

Distance calculate + Max Heap

✅ 4. K Closest Numbers to X
✅ 5. Kth Smallest in Sorted Matrix

**🔷 7️⃣ Pattern Signal Kaise Pehchane?**

Agar question me ye words dikhe:
- "Top K"
- "K most frequent"
- "K closest"
- "K smallest"
- "K largest"
- "Kth element"

**➡ Immediately socho: Heap Pattern**

# 🔷 8️⃣ Brute Force vs Optimized
| Approach    | Time         |
| ----------- | ------------ |
| Sort        | O(N log N)   |
| Heap        | O(N log K)   |
| QuickSelect | O(N) average |

# 🔷 9️⃣ Heap vs QuickSelect
| Method      | Kab Use Kare                      |
| ----------- | --------------------------------- |
| Heap        | Streaming data / frequent updates |
| QuickSelect | Single Kth element                |

# 🔷 🔥 Interview Level Trap

Interviewer puch sakta hai:

Agar data stream aa raha ho to?

- Sorting impossible ❌
- QuickSelect not possible ❌

**Only solution → Heap ✅**
**
🧠 Final Intuition Line**
- 👉 Agar K chhota hai aur N bada hai → Heap use karo
- 👉 Agar exact Kth element chahiye → QuickSelect
- 👉 Agar sorted lists merge karni ho → K-Way Merge
**🔷 Step 1: Question me Pattern Kaise Pehchane?**
Agar question me ye keywords aaye:
- Top K
- K largest
- K smallest
- K most frequent
- K closest
- Kth largest / smallest

**👉 Turant dimaag me aaye: Heap Pattern**


# **🔷 Example 1: Kth Largest Element
Question:**
Array diya hai. Kth largest element find karo.

Example:
```</>
[3,2,1,5,6,4], k = 2
Output = 5
```
**🔥 Sochne ka Tarika**
1. Kth largest = Top K largest me se smallest element
2. Isliye Min Heap of size K use karenge

**✅ Steps:**
- Har element heap me daalo
- Agar heap size > k ho jaye → smallest remove karo
- End me heap ka top = answer
```</>java
import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
```
**
Time = O(N log K)**

**🔷 Example 2: Top K Frequent Elements**
**Question:**

Array me se K most frequent elements return karo.

**Example:**
```
nums = [1,1,1,2,2,3], k=2
Output = [1,2]
```
**🔥 Sochne ka Tarika
**
1. Frequency count karo (HashMap)
2. Heap me frequency ke basis pe store karo
3. Heap size K rakho

**✅ Steps:**
1. Map me frequency store karo
2. Min heap banao based on frequency
3. Agar size > k ho jaye → remove

```
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int key : map.keySet()) {
            minHeap.add(key);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
```

