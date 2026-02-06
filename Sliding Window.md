# 🪟 Sliding Window kya hota hai? (Simple Language)
Socho tumhare paas ek array / string hai
Aur tumhe continuous (lagatar) elements par kaam karna hai.

👉 Har baar poora loop dubara chalane ke bajay,
ek window (khidki) banate ho jo slide karti rehti hai.

# Isse:
  - ⏱ Time Complexity kam hoti hai
  - ❌ Extra loops se bach jaate ho

# 🤯 Problem without Sliding Window

Example:
```
Array = [2,1,5,1,3,2]
k = 3
```
Har subarray ka sum nikalna:

# ❌ Brute Force
 - Har baar naya loop
 - Time = O(n²)

# 😎 Sliding Window ke sath
- Pehli window ka sum banao
- Phir:
   - left se ek element hatao
   - right se ek element add karo

✔️ Time = O(n)

# 🔹 Sliding Window ke TYPES (Most Important)
1️⃣ Fixed Size Sliding Window

👉 Window ka size fix hota hai (k diya hota hai)

**Use hota hai jab:**
 - Subarray of size k
 - Maximum / Minimum / Sum / Average

**Common Questions:**
  - Maximum sum subarray of size k
  - First negative number in every window of size k
  - Maximum in all subarrays of size k

**🔸 Example**
```
arr = [2,1,5,1,3,2]
k = 3
```
**java code**
```java
int maxSum = 0, windowSum = 0;
int k = 3;

for (int i = 0; i < arr.length; i++) {
    windowSum += arr[i];

    if (i >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[i - (k - 1)];
    }
}
```
# 🧠 Logic:
- Pehle k elements add
- Window aage badhao
- Left wala remove, right wala add

# 2️⃣ Variable Size Sliding Window (Most Powerful 💪)
👉 Window ka size condition pe depend karta hai
**Use hota hai jab:**
  - Condition diya ho:
    - sum ≥ k
    - unique characters
    - at most / at least k

**Common Questions:**
  - Longest subarray with sum ≤ k
  - Longest substring without repeating characters
  - Smallest subarray with sum ≥ k

**🔸 Example:**

Longest Subarray with Sum ≤ k
```java
int left = 0, sum = 0, maxLen = 0;

for (int right = 0; right < n; right++) {
    sum += arr[right];

    while (sum > k) {
        sum -= arr[left];
        left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);
}
```
**🧠 Logic:**
- right pointer se expand
- condition break hui → left move
- har step pe max length check

# 3️⃣ Sliding Window + HashMap / Set
👉 Jab frequency / duplicate ka kaam ho
**Use hota hai:**
 - Strings me
 - Unique / repeating characters
**Common Questions:**
 - Longest substring without repeating characters
 - Count anagrams
 - Minimum window substring

**🔸 Example:**

Longest Substring Without Repeating Characters
```java
HashSet<Character> set = new HashSet<>();
int left = 0, maxLen = 0;

for (int right = 0; right < s.length(); right++) {
    while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
    }
    set.add(s.charAt(right));
    maxLen = Math.max(maxLen, right - left + 1);
}
```
# 📌 Sliding Window kab use kare? (Golden Rule ⭐)
- ✔️ Array / String ho
- ✔️ Continuous subarray / substring ho
- ✔️ Max / Min / Longest / Shortest / Sum / Count bola ho

👉 90% cases me Sliding Window lagega
****
**❌ Sliding Window kab use nahi kare?**
- Subsequence (continuous nahi)
- Random elements
- Sorting based problems

# 🧠 Interview Tip (Very Important)

❓ Question me agar ye words dikhe:
 - subarray
 - substring
 - window
 - longest / smallest
 - continuous

🔥 Turant socho → Sliding Window
