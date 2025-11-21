## ⭐ Problem Summary
Given a string `s`, humein **longest substring ka length** nikalna hai **jisme koi character repeat na ho**.

Example:  
`s = "abcabcbb"` → longest substring = `"abc"` → length = **3**

---

## ⭐ Approach (Sliding Window + HashSet)
Hum two pointers use karte hain:

- **left pointer** – window ki starting  
- **right pointer** – window ki ending  
- **HashSet** – current window ke unique characters store karne ke liye  

Agar koi **duplicate character milta hai**, hum **left pointer ko aage badhate hain** jab tak duplicate remove na ho jaye.

---

## ⭐ Step-by-Step Theory

### **Step 1 — Initialize**
```
Set<Character> set = new HashSet<>();
left = 0;
maxLen = 0;
```

### **Step 2 — Iterate with right pointer**
Har character ko check karo:

- Agar duplicate nahi → add to set
- Agar duplicate hai → left pointer shift karo jab tak duplicate remove na ho

### **Step 3 — Update max length**
```
maxLen = Math.max(maxLen, right - left + 1);
```

### **Step 4 — Return maxLen**

---

## ⭐ Dry Run Example (s = "pwwkew")

| Step | Right Pointer | Window (left..right) | Set | Action | maxLen |
|------|---------------|----------------------|-----|--------|--------|
| 0 | p | p | {p} | add | 1 |
| 1 | w | pw | {p,w} | add | 2 |
| 2 | w | w | {w} | shrink left, remove duplicate | 2 |
| 3 | k | wk | {w,k} | add | 2 |
| 4 | e | wke | {w,k,e} | add | 3 |
| 5 | w | kew | {k,e,w} | shrink left | 3 |

Final answer = **3**

---

## ⭐ Code (Java)

```java
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // If duplicate, move left pointer
            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current char and update max length
            set.add(current);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // Output: 3 ("abc")

        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3 ("wke")
    }
}
```

---

## ⭐ Time & Space Complexity

```
Time:  O(n)
Space: O(n)
```

---

## ⭐ Short Summary (Copy-Ready)

```
- Sliding window use hota hai
- Duplicate milte hi left pointer badhate hain
- HashSet se unique characters track karte hain
- maxLen = right - left + 1
```

---

Enjoy learning! 🚀  
 
