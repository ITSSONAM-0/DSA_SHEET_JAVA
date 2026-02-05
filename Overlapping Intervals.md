# 🔹 Overlapping Intervals Pattern 
❓ Problem kya hoti hai?

Tumhe intervals diye hote hain:
```
[1,3], [2,6], [8,10], [15,18]
```
Har interval ka matlab:
```
[start , end]
```
# Tumhe batana hota hai:
- kaun overlap karta hai
- kaun alag hai
- ya phir unko merge karna hota hai

# 🧠 Golden Rule (Ye yaad rakhna 🔑)
Step 1: SORT intervals by start time

👉 bina sort kiye overlap kabhi clearly nahi dikhega
```
Sort by start:
[1,3], [2,6], [8,10], [15,18]
```
# 🔁 Overlap check karne ka formula

- Current interval = [s, e]
- Last interval = [lastStart, lastEnd]

✅ Overlap tab hota hai jab:
```
s <= lastEnd
```
❌ Overlap nahi hota jab:
```
s > lastEnd
```
# ✏️ Dry Run (Slow & Clear)
Step 1: First interval lo
```
result = [1,3]
```
Step 2: Next interval = [2,6]

Check:
```
2 <= 3  ✅ overlap
```
➡ merge:
```
new end = max(3,6) = 6
result = [1,6]
```
Step 3: Next interval = [8,10]

Check:
```
8 <= 6 ❌ no overlap
```
➡ new interval add karo
```
result = [1,6], [8,10]
```
Step 4: Next interval = [15,18]
```
15 <= 10 ❌ no overlap
```
➡ add
```
result = [1,6], [8,10], [15,18]
```
# ✅ Final Answer
```
[1,6], [8,10], [15,18]
```
# 🧩 Pattern Template (Interview Master Formula)
```
1. Sort intervals by start
2. Take first interval
3. Loop remaining intervals
4. If overlap → merge
5. Else → add new interval
```
# 💻 Java Code (Clean & Easy)
```
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                current = intervals[i];
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
```
# 🧠 Why this works?
- Sorting ensures correct order
- Har interval sirf last interval se compare hota hai
- Time Complexity: O(n log n)
- Space: O(n)


```
1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18
|---|---|---|---|---|---|---|---|---|----|----|----|----|----|----|

[1---------3]
    [2---------------6]

                    [8-----------10]

                                              [15-------------18]
```
# 🧠 One-Line Visual Rule (Interview Gold ⭐)
```
Agar next.start <= last.end  → OVERLAP
Agar next.start >  last.end  → NO OVERLAP
```
