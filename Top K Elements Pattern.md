**📌 1. What does “Top K” mean?**

**“Top K” means:**

- K largest elements
- K smallest elements
- K most frequent elements
- K closest elements

**📌 Example:**
```
Array = [3, 1, 5, 12, 2, 11]
K = 3

Top 3 largest → [12, 11, 5]
```
# 🧠 2. When should you use this pattern?

**👉 If the question contains words like:**

- “Top K”
- “Kth largest / smallest”
- “Most frequent”
- “Closest K elements”

**👉 Then think:**
➡️ Use Heap (Priority Queue)

**⚙️ 3. Core Concept: Heap**
**🔺 Types of Heap**
**✅ Min Heap**
- Smallest element is on top
- Used for → Top K largest elements

**✅ Max Heap**
- Largest element is on top
- Used for → Top K smallest elements
**🚀 4. Important Patterns**
**✅ Pattern 1: K Largest Elements**
**💡 Logic:**
- Use Min Heap
- Keep heap size = K
- If size > K → remove smallest
**🧾 Code (Java)**
 ```java
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

for(int num : arr){
    minHeap.add(num);
    if(minHeap.size() > k){
        minHeap.poll();
    }
}
```
👉 At the end, heap contains K largest elements
**
✅ Pattern 2: K Smallest Elements**
**💡 Logic:**
- Use Max Heap
```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

for(int num : arr){
    maxHeap.add(num);
    if(maxHeap.size() > k){
        maxHeap.poll();
    }
}
```
**✅ Pattern 3: Kth Largest Element**

**👉 Just return:**
```java
return minHeap.peek();
```
# ✅ Pattern 4: Top K Frequent Elements
**💡 Steps:**
1. Create frequency map
2. Use heap based on frequency

```java
Map<Integer, Integer> map = new HashMap<>();

for(int num : arr){
    map.put(num, map.getOrDefault(num, 0) + 1);
}

PriorityQueue<Integer> minHeap = new PriorityQueue<>(
    (a, b) -> map.get(a) - map.get(b)
);

for(int num : map.keySet()){
    minHeap.add(num);
    if(minHeap.size() > k){
        minHeap.poll();
    }
}
```
# ✅ Pattern 5: K Closest Elements

**👉 Use distance:**
```java
Math.abs(num - target)
```
# ⚡ 5. Time Complexity
| Method  | Complexity |
| ------- | ---------- |
| Heap    | O(N log K) |
| Sorting | O(N log N) |

👉 Heap is better when K is small

# 🎯 6. Heap vs Sorting
| Situation              | Use     |
| ---------------------- | ------- |
| Need full sorted array | Sorting |
| Need only K elements   | Heap ✅  |

# 🧩 7. Real Interview Questions

**This pattern is used in:**

- Kth Largest Element
- Top K Frequent Elements
- K Closest Points to Origin
- Connect Ropes (min cost)
- Sort Characters by Frequency
# 🧠 8. Easy Rule to Remember
```
Top K Largest → Min Heap
Top K Smallest → Max Heap
Frequency → Map + Heap
Closest → Distance + Heap
```
# 💡 9. Simple Visualization
```
K = 3
Heap = [5, 11, 12]
```
**New element = 6**

- Compare with smallest (5)
- 6 > 5 → remove 5, add 6

**👉 New heap:**
```
[6, 11, 12]
```
# 🚀 Final Summary

- 👉 Top K Pattern = Heap-based optimization
- 👉 Avoids full sorting
- 👉 Very common in interviews


