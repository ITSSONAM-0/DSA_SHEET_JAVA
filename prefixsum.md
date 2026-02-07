# 🔹 Prefix–Suffix Pattern kya hota hai?
**Simple words mein:**
- Prefix → left se start karke cumulative calculation
- Suffix → right se start karke cumulative calculation

Matlab hum array / string ko do directions se process karte hain.

# 🔹 Visual samajh lo (Array Example)
**Array:**
nums = [2, 3, 4, 5]

**Prefix Sum**
```
prefix[0] = 2
prefix[1] = 2 + 3 = 5
prefix[2] = 5 + 4 = 9
prefix[3] = 9 + 5 = 14
```
**Suffix Sum**
```
suffix[3] = 5
suffix[2] = 4 + 5 = 9
suffix[1] = 3 + 9 = 12
suffix[0] = 2 + 12 = 14
```

# 🔹 Prefix–Suffix KYU use karte hain?
👉 Jab har index ke liye left + right ka data chahiye ho

**❌ Brute force:**
- Har index ke liye left/right loop
- Time: O(n²) 😵

**✅ Prefix–Suffix:**
- Ek hi pass left
- Ek hi pass right
- Time: O(n) 😎

# 🔹 KAB use karte hain? (Golden Clues)
Agar question mein ye words dikhe:
- “left side ka sum / product”
- “right side ka sum / product”
- “excluding current element”
- “range sum query”
- “before index / after index”

**💡 Samajh jao → Prefix–Suffix lagega**

# 🔹 KAHA use hota hai? (Popular DSA Questions)
**1️⃣ Product of Array Except Self**

Har index ke liye:
```
answer[i] = prefixProduct[i-1] * suffixProduct[i+1]
```
**2️⃣ Prefix Sum Queries**

Range sum fast nikalna:
```
sum(l, r) = prefix[r] - prefix[l-1]
```
**3️⃣ Trapping Rain Water**
- Left max & Right max → prefix & suffix

**4️⃣ Equilibrium Index**
- Left sum == Right sum

# 🔹 Prefix–Suffix ka Basic Template (Java)
**✅ Prefix Sum**
```
int n = nums.length;
int[] prefix = new int[n];

prefix[0] = nums[0];
for(int i = 1; i < n; i++){
    prefix[i] = prefix[i - 1] + nums[i];
}
```
**✅ Suffix Sum**
```
int[] suffix = new int[n];

suffix[n - 1] = nums[n - 1];
for(int i = n - 2; i >= 0; i--){
    suffix[i] = suffix[i + 1] + nums[i];
}
```
# 🔹 Ek Easy Real-Life Analogy 🌧️
Socho tum pahadon ke beech khade ho:
- Left side ke tallest pahad = prefix max
- Right side ke tallest pahad = suffix max
- Beech mein pani = min(leftMax, rightMax) - height[i]

**➡️ Ye hi Trapping Rain Water**

**🔹 Common Mistakes 🚫**

- ❌ prefix[0] initialize bhoolna
- ❌ suffix last index se start na karna
- ❌ i-1 / i+1 boundary check miss karna

# 🔹 Summary (Exam ke liye yaad rakhna 🧠)
| Point     | Answer                       |
| --------- | ---------------------------- |
| Pattern   | Prefix + Suffix              |
| Direction | Left → Right & Right → Left  |
| Time      | O(n)                         |
| Use       | Left/right data fast chahiye |
| Avoid     | Nested loops                 |




