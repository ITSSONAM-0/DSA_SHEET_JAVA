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


# 1️⃣ Find the Middle Index in Array
👉 “Middle index jaha left sum == right sum”

**🔍 Logic**
- Har index i par:
    - Left sum = elements before i
    - Right sum = elements after i
    - Jis index par dono equal → wahi answer

**❌ Brute Force**
- Har index ke liye left & right loop
- Time: O(n²) 😐

**✅ Prefix–Suffix Idea**
- Total sum nikal lo
- Ek variable leftSum
- Right sum = totalSum - leftSum - nums[i]

**🧠 Pattern**
- ✔ Prefix Sum
- ✔ Left = Prefix
- ✔ Right = Total − Prefix − current

**✨ Code Idea**
```
int total = 0;
for(int x : nums) total += x;

int left = 0;
for(int i = 0; i < nums.length; i++){
    int right = total - left - nums[i];
    if(left == right) return i;
    left += nums[i];
}
return -1;
```

**👉 Problem**

Index i jaha left sum == right sum

**✅ Java Code**
```java
class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
```
**⏱ Time: O(n)
📦 Space: O(1)
**


# 2️⃣ Product of Array Except Self
👉 “Har index ka product, khud ke bina”

**🔍 Logic**

For index i:
```
answer[i] = product of left elements × product of right elements
```
**❌ Brute Force**
- Har index par pura array multiply
- Time: O(n²) ❌
**
✅ Prefix–Suffix Solution**
- prefixProd[i] → left ka product
- suffixProd[i] → right ka product

**🧠 Pattern**
- ✔ Prefix Product
- ✔ Suffix Product
- ✔ Excluding current index
**✨ Code Idea**
```
int n = nums.length;
int[] res = new int[n];

res[0] = 1;
for(int i = 1; i < n; i++)
    res[i] = res[i - 1] * nums[i - 1];

int right = 1;
for(int i = n - 1; i >= 0; i--){
    res[i] = res[i] * right;
    right *= nums[i];
}
```

  
**
📌 Prefix + Suffix Product**
**👉 Problem**

Har index ka product, khud ke element ke bina

**✅ Java Code**
```
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // prefix product
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // suffix product
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
```
**⏱ Time: O(n)
📦 Space: O(1) (output array exclude)**

# 3️⃣ Maximum Product Subarray
👉 “Continuous subarray ka max product”

**🔍 Problem yaha tricky kyun?**
- Negative × Negative = Positive
- Zero product ko reset kar deta hai

**❌ Simple prefix fail ho sakta hai**

Isliye yaha Prefix + Suffix scan use hota hai

**✅ Smart Trick**
- Left se product calculate
- Right se product calculate
- Max lo dono ka

**🧠 Pattern**
- ✔ Prefix traversal
- ✔ Suffix traversal
- ✔ Zero handling

**✨ Code Idea**

```
int max = Integer.MIN_VALUE;
int prod = 1;

for(int i = 0; i < nums.length; i++){
    prod *= nums[i];
    max = Math.max(max, prod);
    if(prod == 0) prod = 1;
}

prod = 1;
for(int i = nums.length - 1; i >= 0; i--){
    prod *= nums[i];
    max = Math.max(max, prod);
    if(prod == 0) prod = 1;
}
```
**👉 Problem**

Continuous subarray ka maximum product

**✅ Java Code**
```
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;

        // Left to right
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            max = Math.max(max, product);
            if (product == 0) product = 1;
        }

        // Right to left
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(max, product);
            if (product == 0) product = 1;
        }

        return max;
    }
}
```
**⏱ Time: O(n)
📦 Space: O(1)**


# 4️⃣ Number of Ways to Split Array

👉 “Kitne ways hain jaha left sum ≥ right sum”

**🔍 Logic**
- Array ko kisi index par split karna
- Condition:

```
leftSum >= rightSum
```
**✅ Prefix Use**
- Total sum nikal lo
- Left sum incrementally badhao
- Right = total − left
**
🧠 Pattern**
- ✔ Prefix Sum
- ✔ Running leftSum
- ✔ Count splits

**✨ Code Idea**
  
```
int total = 0;
for(int x : nums) total += x;

int left = 0, count = 0;
for(int i = 0; i < nums.length - 1; i++){
    left += nums[i];
    int right = total - left;
    if(left >= right) count++;
}
```
**Prefix Sum**

👉 Problem

**Kitne split points jaha
leftSum ≥ rightSum**

**✅ Java Code**

```
class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        long leftSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;
    }
}
```
**⏱ Time: O(n)
📦 Space: O(1)**

# 5️⃣ Range Sum Query 2D
👉 “Matrix ke kisi rectangle ka sum fast nikalna”

**❌ Brute Force**
- Har query ke liye pura rectangle loop
- Time: O(n²) per query 😵

**✅ Prefix Sum Matrix (DP style)**
- Ek 2D prefix matrix banao
- Har cell mein:
```
sum of rectangle (0,0) → (i,j)
```
**🧠 Formula**
```
sum(r1,c1 → r2,c2) =
prefix[r2][c2]
- prefix[r1-1][c2]
- prefix[r2][c1-1]
+ prefix[r1-1][c1-1]
```
**✨ Code Idea**
```
prefix[i][j] =
matrix[i][j]
+ prefix[i-1][j]
+ prefix[i][j-1]
- prefix[i-1][j-1];
```
**📌 2D Prefix Sum (DP)**

**👉 Problem**

Matrix ke kisi rectangle ka sum fast nikalna

**✅ Java Code**
```
class NumMatrix {
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = matrix[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
             - prefix[row1][col2 + 1]
             - prefix[row2 + 1][col1]
             + prefix[row1][col1];
    }
}
```
**⏱ Preprocess: O(m × n)
⏱ Query: O(1)**

# 🧠 Interview Tip
** Agar question bole:**
 - left / right
 - excluding current
 - range sum
 - multiple queries
**
👉 Turant socho PREFIX / SUFFIX 💡**
