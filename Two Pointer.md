# 🔥 1. Two Pointer kya hota hai?

**👉 Two pointer technique me hum 2 indices/pointers use karte hain instead of 1**
- left (start se)
- right (end se ya left ke aage)

**👉 Goal:**
- Time complexity reduce karna (O(n²) → O(n))
- Efficient searching / pairing / window finding

# 🧠 2. Kab use kare (IMPORTANT)
**✅ Use Two Pointer when:**
  1. Array sorted ho (MOST IMPORTANT)
  2. Pair find karna ho
     - Sum = target
     - Difference = k
  3. Subarray / window related problems
  4. Palindrome check
  5. Duplicate remove karna ho
  6. In-place modification karna ho

# ❌ Kab use NA kare:
- Array unsorted ho aur sorting allowed na ho
- Random access logic ho (DP / Graph type)

# ⚡ 3. Types of Two Pointer Patterns
**🟢 Type 1: Opposite Direction (left ↔ right)**

**👉 Most common**
```
left = 0
right = n-1
```
**Use case:**
- Pair sum
- Palindrome
- Sorted array problems

**🔹 Example: Two Sum (Sorted)**
```
int left = 0, right = arr.length - 1;

while (left < right) {
    int sum = arr[left] + arr[right];

    if (sum == target) return true;
    else if (sum < target) left++;
    else right--;
}
```

# 💡 Logic:
- sum chhota → left badhao
- sum bada → right kam karo
**🟡 Type 2: Same Direction (Slow & Fast Pointer)**

**👉 Dono pointer same side move karte hain**
```
slow = 0
fast = 0
```
**Use case:**
- Remove duplicates
- Cycle detection
- Partition problems
**🔹 Example: Remove Duplicates**
```
  int slow = 0;

for (int fast = 1; fast < n; fast++) {
    if (arr[fast] != arr[slow]) {
        slow++;
        arr[slow] = arr[fast];
    }
}

```
# 🔵 Type 3: Sliding Window (Advanced Two Pointer)

**👉 Window expand + shrink**
```
left = 0
for right in range(n)
```
**Use case:**
- Longest substring
- Subarray sum
- Window problems
**🔹 Example: Longest Subarray Sum ≤ K**
 ```
 int left = 0, sum = 0;

for (int right = 0; right < n; right++) {
    sum += arr[right];

    while (sum > k) {
        sum -= arr[left];
        left++;
    }
}
```

# 🔴 Type 4: Partitioning (Quick Sort type)

**👉 Left-right swap logic**

**Use case:**
- Sort 0,1,2 (Dutch National Flag)
- Partition array


# 🚀  Kaise identify kare ki Two Pointer lagega?

**👉 Ye checklist yaad rakhna:**

-  Sorted array?
-  Pair ya subarray problem?
-  Brute force O(n²) lag raha hai?
-  Window expand-shrink ho raha hai?

👉 Agar 2–3 YES → Two pointer try karo


# ⚠️ 6. Common Mistakes
- ❌ Unsorted array me directly use karna
- ❌ Infinite loop (left/right update bhool jana)
- ❌ Wrong condition (<= vs <)
- ❌ Sliding window me shrink logic galat

