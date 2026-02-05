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



# 🔷 Overlapping Intervals Pattern
❓ Kaha use karte hain? (WHERE)
# 1️⃣ Time-based problems ⏰
Jahan time slots ya ranges hote hain:
  - Meeting rooms
  - Calendar booking
  - Class schedule
  - Train / flight timings
👉 Example: Do meetings same time pe ho rahi hain ya nahi?

# 2️⃣ Range-based data 📊
Jahan data start → end form me hota hai:
  - Date ranges (leave, hotel booking)
  - Salary slabs
  - Price ranges
  - Age groups
👉 Example: Two offers ek hi date range me valid hain?

# 3️⃣ Geometry / Lines problems 📐
Jahan lines ya segments overlap karte hain:
   - Balloons on x-axis
   - Street lights coverage
   - Signal ranges

👉 Example: Ek arrow kitne balloons burst karega?

# 4️⃣ Resource allocation 🧠
Jahan limited resources hote hain:
   - Minimum rooms
   - Minimum arrows
   - Minimum removals

👉 Example: Minimum meetings rooms required?

# 🔷 ❓ KYU use karte hain? (WHY)
🔴 Problem without this pattern

Agar har interval ko har interval se compare karo:
```
O(n²) ❌
```
Slow + confusing + interview me ❌

# 🟢 Pattern use karne ka fayda
```
Sort + one pass = O(n log n) ✅
```
- Clean logic
- Easy dry run
- Interviewer ko clear thinking dikhti hai

# 🔑 CORE REASON (Sabse important)

Intervals me decision sirf "previous interval" se lena hota hai,
poori list se nahi.

Sorting ke baad:
```
current interval ka overlap sirf last interval se matter karta hai
```
Isliye:
- merge easy
- count easy
- insert easy


# 🧠 Real-Life Analogy (Easy yaad rahega)
🧳 Train Platform Example 🚆
```
Train A: 10–12
Train B: 11–1   → overlap → same platform nahi
Train C: 2–4    → no overlap → same platform
```
➡ Ye pure Overlapping Intervals pattern hai

# 🔄 Decision Table (WHY clearly)
| Question        | Kya decide karna hai | Pattern kyu         |
| --------------- | -------------------- | ------------------- |
| Merge intervals | combine              | overlap check       |
| Insert interval | fit karna            | ordered intervals   |
| Calendar        | allow / deny         | overlap layers      |
| Balloons        | min arrows           | max overlap         |
| Non-overlap     | remove               | conflict resolution |


# 🎯 Interview-Level Answer ( ⭐)

“We use the Overlapping Intervals pattern when a problem involves
ranges or time slots and requires decisions based on conflicts or overlaps.
Sorting the intervals allows us to process them in one pass efficiently.”

# 🧠 Pehchaan ka Shortcut (Exam / Interview)
Agar problem me dikhe:
   - [start, end]
   - time / range / segment
   - overlap / conflict / merge / minimum / maximum

👉 Seedha dimaag me aana chahiye:
“Ye Interval Overlap pattern hai” 🔥




# 🧠 MASTER INTERVAL PATTERN (Sabka Base)

```
1️⃣ Sort intervals (mostly by start, kabhi-kabhi by end)
2️⃣ Compare current interval with previous
3️⃣ Decide:
    - merge?
    - skip?
    - count?
    - insert?
```
# 🔑 Universal Overlap Rule
```
current.start <= prev.end  → overlap
current.start >  prev.end  → no overlap
```
# 1️⃣ Basic Merge – Merge Intervals
🎯 Goal

Overlapping intervals ko merge karna

Visual Thinking
```
[1----3]
    [2--------6]   → overlap → merge → [1------6]
```
Action
 - Overlap → end = max(end)
 - No overlap → new interval add

****
Idea
  - Sort by start
  - Overlap → merge
  - Else → new interval


```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        res.add(curr);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                curr = intervals[i];
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
```
 # 2️⃣ Insert Interval
Idea
 - Pehle left non-overlap
 - Phir merge overlap
 - Phir right add

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;

        // left part
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        // overlap part
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // right part
        while (i < intervals.length) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
```



# 3️⃣ My Calendar II
Idea
  - bookings → single booking
  - overlaps → double booking
  - Agar new interval overlaps with overlaps → ❌


```java
class MyCalendarTwo {
    List<int[]> bookings = new ArrayList<>();
    List<int[]> overlaps = new ArrayList<>();

    public boolean book(int start, int end) {
        for (int[] o : overlaps) {
            if (Math.max(o[0], start) < Math.min(o[1], end))
                return false; // triple booking
        }

        for (int[] b : bookings) {
            int s = Math.max(b[0], start);
            int e = Math.min(b[1], end);
            if (s < e) overlaps.add(new int[]{s, e});
        }

        bookings.add(new int[]{start, end});
        return true;
    }
}
```
# 4️⃣ Minimum Number of Arrows to Burst Balloons
Idea
  - Sort by end
  - Overlap → same arrow
  - Else → new arrow

```java
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}
```
# 5️⃣ Non-overlapping Intervals
Idea
  - Sort by end
  - Overlap aaye → remove one
  - Greedy: jo pehle end ho usko rakho


```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++; // remove current
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
```
# 🧠 ONE-LINE MEMORY TRICK
```
Merge / Insert  → sort by start
Remove / Arrow → sort by end
Overlap check  → start < end
```
