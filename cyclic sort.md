****📌 1. Cyclic Sort Kya Hai?

**👉 Ye ek in-place sorting algorithm hai
👉 Time Complexity: O(n)
👉 Space Complexity: O(1)
👉 Sirf tab use hota hai jab:**

- Numbers 1 se N tak ho
- Ya 0 se N tak ho
- Range fixed ho


# 🧠 2. Intuition (Sabse Important)

Agar array me numbers 1 se N tak hain, to:
| Number | Correct Index |
| ------ | ------------- |
| 1      | 0             |
| 2      | 1             |
| 3      | 2             |
| n      | n-1           |

**Matlab:
correctIndex = arr[i] - 1

Agar current element apni correct position par nahi hai → swap karo.**
**🛠 3. Basic Algorithm**
```java
int i = 0;
while (i < arr.length) {
    int correctIndex = arr[i] - 1;

    if (arr[i] != arr[correctIndex]) {
        swap(arr, i, correctIndex);
    } else {
        i++;
    }
}
```
**📍 4. Kab Use Karte Hai?**

Cyclic sort tab use hota hai jab:

**✅ 1. Missing Number Find Karna**
- Ek number missing hai
- Range 1 to N

**✅ 2. Duplicate Find Karna**
- Ek ya multiple duplicate

**✅ 3. All Missing Numbers
- ✅ 4. First Missing Positive
- ✅ 5. Find Corrupt Pair (Duplicate + Missing)**

**🔥 Important Pattern Based Questions**
**1️⃣ Find Missing Number (0 to N)**

Example:
[4,0,2,1]

**Logic:**
- correctIndex = arr[i]
- Swap till correct position
- Last me jo index match nahi kare → wahi missing

**2️⃣ Find Duplicate Number**

Example:
[1,3,4,2,2]

Swap karte waqt agar:
```
arr[i] == arr[correctIndex]
```
Aur i != correctIndex → duplicate mil gaya
**3️⃣ Find All Missing Numbers**

Example:
[4,3,2,7,8,2,3,1]

Sort karo → jo index mismatch kare:
```
arr[i] != i+1
```
To i+1 missing hai

**4️⃣ Find Corrupt Pair**

Example:
[3,1,2,5,2]

Output:
```
Duplicate = 2
Missing = 4
```
**🧩 Cyclic Sort Variations**
| Type                   | Correct Index Formula |
| ---------------------- | --------------------- |
| 1 to N                 | arr[i] - 1            |
| 0 to N                 | arr[i]                |
| First Missing Positive | ignore negative & > n |


**🚨 Important Conditions**

**❌ Use mat karo agar**:
- Numbers random ho
- Large range ho (like 1 to 10^9)
- Continuous range na ho


**🆚 Cyclic Sort vs Normal Sort**
| Feature  | Cyclic Sort      | Arrays.sort() |
| -------- | ---------------- | ------------- |
| Time     | O(n)             | O(n log n)    |
| Space    | O(1)             | O(1)          |
| Use Case | Fixed range only | Any data      |


**💡 Real Interview Flow

Interviewer bole:

Array me 1 se N tak numbers hain, ek missing hai.

👉 Turant socho: Cyclic Sort Pattern

**
**🧠 Deep Understanding**

Cyclic sort actually sorting ke liye nahi,
👉 Ye mainly position-based problem solving technique hai.

**Isme hum:
**
- Har element ko uski correct jagah rakhte hain
- Phir mismatch check karte hain
**📝 Step-by-Step Question Solve Strategy**
1. Check range → 1 to N?
2. Decide correctIndex formula
3. While loop lagao
4. Swap until correct
5. Traverse → mismatch find karo

