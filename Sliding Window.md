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


****
**🔹 STEP 1: Question ko classify karo**
Sabse pehle ye decide karo:
**❓ Window size diya hai?**
- YES → Fixed Size Sliding Window
- NO / condition based → Variable Size Sliding Window

Tumhare list ke saare questions = Fixed Size Sliding Window 👍
****
**🔹 STEP 2: Window size k identify karo**
Question me dhyaan se padho:
- size k
- window of length k
- subarray of size k
- substring of length k

👉 Ye hi tumhari window hogi
****
**🔹 STEP 3: First window ka kaam karo**
- pehle k elements / characters process karo
- sum / frequency / count banao
****
**🔹 STEP 4: Window slide karo**
- Har step pe
- right side add
- left side remove
***8
**🔹 STEP 5: Answer update karo
**
- max / min / count / list

  ****
  Ab isi framework se ek-ek question samajhte hain 👇



  *****
 # 1️⃣ Maximum Sum Subarray of Size K
**🧩 Kya poochha?**
- Subarray
- Size = k
- Maximum sum

**✅ Pattern**

✔ Fixed Size Sliding Window
****

**🔸 Steps**
1. window size = k
2. pehle k elements ka sum
3. slide window
4. left remove, right add
5. max sum update

# 🏆 FINAL MASTER RULE (Interview Gold ⭐)
| Question Hint           | Pattern         |
| ----------------------- | --------------- |
| Subarray / Substring    | Sliding Window  |
| Size k given            | Fixed Window    |
| Frequency / Permutation | HashMap / Array |
| Maximum in window       | Deque           |
| Average                 | Convert to Sum  |


# 1️⃣ Maximum Sum Subarray of Size K

```java
class Solution {
    public int maxSumSubarray(int[] nums, int k) {
        int windowSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[i - (k - 1)];
            }
        }
        return maxSum;
    }
}
```
# 2️⃣ Number of Subarrays Having Average ≥ Threshold

```
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, count = 0;
        int target = k * threshold;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (i >= k - 1) {
                if (sum >= target) count++;
                sum -= arr[i - (k - 1)];
            }
        }
        return count;
    }
}
```
# 3️⃣ Repeated DNA Sequences
```
import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) {
                result.add(sub);
            }
        }
        return new ArrayList<>(result);
    }
}
```
# 4️⃣ Permutation in String
```
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];
        for (char c : s1.toCharArray())
            freq[c - 'a']++;

        int left = 0, count = s1.length();

        for (int right = 0; right < s2.length(); right++) {
            if (freq[s2.charAt(right) - 'a']-- > 0)
                count--;

            if (count == 0) return true;

            if (right - left + 1 == s1.length()) {
                if (freq[s2.charAt(left) - 'a']++ >= 0)
                    count++;
                left++;
            }
        }
        return false;
    }
}
```
# 5️⃣ Sliding Subarray Beauty
```
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] freq = new int[101]; // -50 to 50 shift

        int left = 0;
        for (int right = 0; right < n; right++) {
            freq[nums[right] + 50]++;

            if (right - left + 1 == k) {
                int cnt = 0;
                for (int i = 0; i < 50; i++) { // only negatives
                    cnt += freq[i];
                    if (cnt >= x) {
                        result[left] = i - 50;
                        break;
                    }
                }
                freq[nums[left] + 50]--;
                left++;
            }
        }
        return result;
    }
}
```
# 6️⃣ Sliding Window Maximum
```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // remove out of window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offerLast(i);

            if (i >= k - 1)
                res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
}
```
# 🧠 ONE LINE REVISION (Exam / Interview)
- Sum / Avg / Count → normal sliding window
- Permutation / Repeated → frequency + window
- Maximum in window → Deque
- Fixed size k → most easy sliding window
