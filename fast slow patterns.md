# 🚶‍♂️🚶‍♀️ Fast & Slow Pointer kya hota hai?
Is technique me do pointers use hote hain:
- 🐢 Slow pointer → 1 step aage
- 🐇 Fast pointer → 2 steps aage

Dono ek hi list / array / structure par chalte hain, bas speed alag hoti hai.

# 🤔 Use kyun karte hain?
Fast & Slow pointer mainly use hota hai:
1. Linked List me cycle detect karne ke liye
2. Middle element nikalne ke liye
3. Happy Number jaisi problems
4. Palindrome check (linked list)

👉 Matlab jab tumhe comparison without extra space chahiye.

# 🧠 Imagine karo (Real Life Example)
Socho ek circular race track hai 🏃‍♂️🏃‍♀️
- Slow = cycle se walk kar raha
- Fast = cycle se run kar raha

👉 Agar track circular hai, to fast banda slow ko pakka pakad lega
👉 Agar circular nahi hai, fast track ke bahar nikal jayega (null)

🔥 Yahi logic cycle detection ka base hai

# 🔁 Example 1: Cycle Detection (Most Important)
Linked List:

```
1 → 2 → 3 → 4 → 5
          ↑       ↓
          ← ← ← ←
```
# 🧑‍💻 Logic:
- slow = head
- fast = head

Loop me:
- slow = slow.next
- fast = fast.next.next

Agar:
- slow == fast → cycle exists ✅
- fast == null → no cycle ❌


```
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            if (slow == fast) {
                return true;           // cycle found
            }
        }
        return false;
    }
}
```
# 🧪 Dry Run (Simple)
```
slow: 1 → 2 → 3 → 4
fast: 1 → 3 → 5 → 3
```
# At one point:

```
slow == fast
```

✅ Cycle detected

# 📍 Example 2: Middle of Linked List
List:

```
1 → 2 → 3 → 4 → 5
```





# 🔁 Example 1: Cycle Detection (Most Important)
Linked List:
```
1 → 2 → 3 → 4 → 5
          ↑       ↓
          ← ← ← ←
```
# 🧑‍💻 Logic:
- slow = head
- fast = head

Loop me:
- slow = slow.next
- fast = fast.next.next

Agar:
- slow == fast → cycle exists ✅
- fast == null → no cycle ❌

# Java Code
```
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            if (slow == fast) {
                return true;           // cycle found
            }
        }
        return false;
    }
}
```
# 🧪 Dry Run (Simple)
```
slow: 1 → 2 → 3 → 4
fast: 1 → 3 → 5 → 3
```
At one point:
```
slow == fast
```
✅ Cycle detected

📍 Example 2: Middle of Linked List
List:
```
1 → 2 → 3 → 4 → 5
```
# Movement:
```
slow: 1 → 2 → 3
fast: 1 → 3 → 5
```
👉 Jab fast end pe pahunchta hai, slow middle pe hota hai 🎯
```
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```
Fast pointer 2x speed se chalta hai
Isliye:
- Cycle hai → fast slow ko pakad lega
- End hai → fast pehle null ho jayega
- Middle chahiye → slow exact beech me hoga
****

❌ Common Mistakes (Very Important)

❌ while(fast.next != null) ❌
✔️ while(fast != null && fast.next != null) ✅

❌ Fast ko 1 step chalana
✔️ Fast ko 2 steps

# One-Line Yaad Rakhne ka Formula

Fast 2 steps, Slow 1 step → cycle, middle, comparison problems solved








# 1️⃣ Happy Number (Fast & Slow Pointer magic ✨)
❓ Happy Number kya hota hai?
A number happy hota hai agar:
    - digits ke square ka sum repeat karke
    - 1 aa jaye

Example:
```
19 → 1² + 9² = 82
82 → 8² + 2² = 68
68 → 6² + 8² = 100
100 → 1² = 1 ✅
```
# 🤔 Fast & Slow pointer kyun?
Agar number happy nahi hai, to digits ke square ka sum cycle bana leta hai
👉 exactly linked list cycle jaisa 😎

# 🧠 Logic
- slow → 1 baar square sum
- fast → 2 baar square sum
- agar slow == fast:
     - 1 hai → happy
     - warna → not happy

```
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow);          // 1 step
            fast = getNext(getNext(fast)); // 2 steps
        } while (slow != fast);

        return slow == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}
```
# 🎯 Interview Line

“Happy number problem is cycle detection using fast and slow pointer.”

# 2️⃣ Find STARTING POINT of Cycle (Very Important 🔥)
Question:
Cycle hai → start kaha se ho rahi hai?

# 🧠 Golden Rule (Yaad rakhna ⭐)
1. Pehle slow & fast ko milne do
2. Ek pointer head pe le aao
3. Dono ko 1-1 step chalao
4. Jahan milenge → cycle start


```
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // step 1: detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        // step 2: find start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // cycle start
    }
}
```
# 🧠 Why it works?

Mathematically distances equal ho jaati hain
(interviewers LOVE this explanation 😄)


# 3️⃣ Palindrome Linked List (Fast & Slow again 😎)
Example:

```
1 → 2 → 2 → 1  ✅
1 → 2 → 3 →  ❌
```
# 🧠 Steps
1. Middle nikaalo (fast & slow)
2. Second half reverse karo
3. First half vs second half compare

```
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode second = reverse(slow);
        ListNode first = head;

        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
```
# 🧠 Pattern Summary (SUPER IMPORTANT 🔥)
| Problem       | Use Fast & Slow? |
| ------------- | ---------------- |
| Cycle detect  | ✅                |
| Cycle start   | ✅                |
| Middle of LL  | ✅                |
| Happy Number  | ✅                |
| Palindrome LL | ✅                |


# 📝 One-line Cheat Code 😄

Fast = 2 step, Slow = 1 step → Cycle, Middle, Comparison

# 1️⃣ Linked List Cycle II
👉 Cycle hai ya nahi nahi, cycle start kaha se hoti hai 🔥

# 🧠 Intuition (easy language)
- Fast & Slow ko chalao
- Jahan milenge → cycle confirm
- Ek pointer ko head pe lao
- Dono ko 1–1 step chalao
- Jahan milenge → cycle ka start

# 🧑‍💻 Java Code
```
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        // Step 1: detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        // No cycle
        if (fast == null || fast.next == null) return null;

        // Step 2: find cycle start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
```
# 🧪 Dry Run
```
1 → 2 → 3 → 4 → 5
          ↑       ↓
          ← ← ← ←
```
- Meeting point: 4
- Head se + meeting point se 1–1 step → 3
✅ Cycle start = 3

- ❌ Common Mistake
- ❌ Direct head compare mat karo
- ✔️ Pehle meeting point find karo


# 2️⃣ Remove Nth Node From End
👉 End se nth node delete karna (single pass)

# 🧠 Intuition
- Fast ko n steps aage bhejo
- Phir slow & fast dono chalao
- Jab fast end pe ho → slow delete position se pehle hoga

🧑‍💻 Java Code
```

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;

        // fast ko n steps aage
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // dono ko saath chalao
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // delete
        slow.next = slow.next.next;

        return dummy.next;
    }
}
```
# 🧪 Dry Run
```
List: 1 → 2 → 3 → 4 → 5
n = 2
```
Delete → 4

- ❌ Mistake

- ❌ Dummy node use nahi karna
- ✔️ Head delete case handle nahi hota

# 3️⃣ Find the Duplicate Number
👉 Array me ek number repeat ho raha hai (cycle concept)

# 🧠 Intuition (important 🔥)
Array ko linked list ki tarah treat karo:

```
index → nums[index]
```
Duplicate → cycle start 😎
# 🧑‍💻 Java Code
```
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // step 1: find meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // step 2: find start of cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
```
# 🧪 Dry Run
```
nums = [1,3,4,2,2]
```
Cycle start = 2
✅ Duplicate number


# 🎯 Interview Line

“Array ko linked list treat karke Floyd cycle detection use kiya.”

# 4️⃣ Palindrome Linked List
👉 Aage se aur peeche se same?

# 🧠 Steps
1. Middle find (slow-fast)
2. Second half reverse
3. Compare both halves

# 🧑‍💻 Java Code
```
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;

        // find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode second = reverse(slow);
        ListNode first = head;

        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
```
# 🧪 Dry Run
```
1 → 2 → 2 → 1
```
✔️ Palindrome

# 🧠 Final Pattern Summary (MEMORIZE THIS 🔥)
| Problem          | Fast & Slow Use  |
| ---------------- | ---------------- |
| Cycle detect     | meet             |
| Cycle start      | reset slow       |
| Remove nth       | distance gap     |
| Duplicate number | array = LL       |
| Palindrome       | middle + reverse |


“Fast and Slow pointers help detect cycles, find middle, and compare elements in O(1) space.”
