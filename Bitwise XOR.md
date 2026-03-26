# 🧠 XOR kya hota hai?

**👉 Rule simple hai:**

| A | B | A ^ B |
| - | - | ----- |
| 0 | 0 | 0     |
| 1 | 1 | 0     |
| 0 | 1 | 1     |
| 1 | 0 | 1     |

**- 👉 Same → 0
- 👉 Different → 1**

# 🔥 XOR ke Golden Properties
- ⭐ 1. a ^ a = 0

- 👉 Same number cancel ho jata hai

# ⭐ 3. XOR is commutative & associative
**
👉 Order matter nahi karta**

```
a ^ b ^ c = a ^ c ^ b

```

# 🎯 XOR ka core idea (samajh lo bas 🔥)
**
👉 XOR = "duplicate hatao, unique bachao"**
# 🔷 1. Single Number (MOST IMPORTANT)
**📌 Problem:**

Array me sab numbers 2 baar hain, sirf ek unique hai

**💡 Approach:**
```java
int ans = 0;
for(int num : arr){
    ans ^= num;
}
```
**👉 Example:**
[2, 3, 2, 4, 3]

**👉 Process:**
```
2 ^ 2 = 0
3 ^ 3 = 0
→ answer = 4
```
# 🔷 2. Missing Number
**📌 Problem:**

0 se n tak numbers hain, ek missing hai

**💡 Approach:**
```java
int xor = 0;

for(int i = 0; i <= n; i++) xor ^= i;
for(int num : arr) xor ^= num;

return xor;
```

**👉 Same logic: duplicate cancel**

# 🔷 3. Two Unique Numbers ⭐ IMPORTANT
**📌 Problem:**

Array me sab duplicate hain except 2 numbers

**💡 Logic:**
- Sabka XOR lo → x ^ y
- Rightmost set bit find karo
- Do groups me divide karo
- Alag-alag XOR
**📌 Code:**
```
  int xor = 0;
for(int num : arr){
    xor ^= num;
}

int diff = xor & (-xor);

int x = 0, y = 0;

for(int num : arr){
    if((num & diff) == 0) x ^= num;
    else y ^= num;
}
```
# 🔷 4. Subarray XOR = K ⭐🔥
**📌 Problem:**

Kitne subarrays ka XOR = K

**💡 Idea:**

Prefix XOR + HashMap
```java
Map<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int xor = 0, count = 0;

for(int num : arr){
    xor ^= num;

    if(map.containsKey(xor ^ k)){
        count += map.get(xor ^ k);
    }

    map.put(xor, map.getOrDefault(xor, 0) + 1);
}
```
# 🔷 5. Swap Without Temp
```java
a = a ^ b;
b = a ^ b;
a = a ^ b;
```
# 🔷 6. XOR from 1 to N (Pattern)

**👉 Result pattern:**
| n % 4 | Result |
| ----- | ------ |
| 0     | n      |
| 1     | 1      |
| 2     | n+1    |
| 3     | 0      |

# 🧠 Kab XOR use karna hai? (IMPORTANT)

**👉 Question me ye signals dikhe:**

**🚨 Keywords:**
- "unique element"
- "duplicate"
- "missing number"
- "pairs"
- "even number of times"

**👉 Matlab = XOR laga do 💥**

# 🔥 Kyu XOR best hai?
| Reason         | Benefit    |
| -------------- | ---------- |
| No extra space | O(1)       |
| Fast           | O(n)       |
| Elegant logic  | clean code |


# 🎯 Pattern Recognition Cheat Sheet
| Problem Type   | XOR Trick    |
| -------------- | ------------ |
| Single unique  | `ans ^= num` |
| Missing number | double XOR   |
| Two unique     | partition    |
| Subarray XOR   | prefix XOR   |
| Swap           | XOR swap     |


# 🔷 1. Missing Number
**📌 Problem:**

Array me numbers 0 → n tak hone chahiye, ek missing hai

- 🧠 XOR Logic:
- 👉 Same numbers cancel ho jate hain
- 👉 (0^1^2^...^n) ^ (array elements) = missing number

**✅ Code (Java)**
```java
public int missingNumber(int[] nums) {
    int n = nums.length;
    int xor = 0;

    for(int i = 0; i <= n; i++) xor ^= i;
    for(int num : nums) xor ^= num;

    return xor;
}
```
**💡 Example:**

nums = [3,0,1]
```
Full XOR = 0^1^2^3
Array XOR = 3^0^1

Remaining = 2 ✅
```
# 🔷 2. Single Number
**📌 Problem:**

Har element 2 baar hai except 1

**🧠 Logic:**

- 👉 a ^ a = 0
- 👉 duplicates cancel

**✅ Code:**
```java
public int singleNumber(int[] nums) {
    int ans = 0;
    for(int num : nums){
        ans ^= num;
    }
    return ans;
}
```
**💡 Example:**

[2,2,1] → 1

# 🔷 3. Single Number II ⭐
**📌 Problem:**

Har element 3 baar hai except 1

**🧠 XOR se direct nahi hoga ❌**

**👉 Yaha bit counting use hota hai**

**💡 Logic:**
- Har bit position count karo
- % 3 karo
- jo bacha = answer

```java
public int singleNumber(int[] nums) {
    int result = 0;

    for(int i = 0; i < 32; i++){
        int sum = 0;

        for(int num : nums){
            if(((num >> i) & 1) == 1){
                sum++;
            }
        }

        if(sum % 3 != 0){
            result |= (1 << i);
        }
    }

    return result;
}
```
**💡 Example:**

[2,2,2,3] → 3

# 🔷 4. Single Number III ⭐🔥
**📌 Problem**:

Sab elements 2 baar hain except 2 numbers

# 🧠 Logic (IMPORTANT):
- Sabka XOR → x ^ y
- Rightmost set bit nikalo
- 2 groups me divide
- Alag XOR
**✅ Code:**
```java
public int[] singleNumber(int[] nums) {
    int xor = 0;

    for(int num : nums){
        xor ^= num;
    }

    int diff = xor & (-xor);

    int x = 0, y = 0;

    for(int num : nums){
        if((num & diff) == 0) x ^= num;
        else y ^= num;
    }

    return new int[]{x, y};
}
```

**💡 Example:**
[1,2,1,3,2,5] → [3,5]

# 🔷 5. Find Original Array from Prefix XOR
**📌 Problem:**

Prefix XOR array diya hai, original array find karo

**🧠 Formula:**

- 👉 arr[0] = pref[0]
- 👉 arr[i] = pref[i] ^ pref[i-1]

**✅ Code:**
```java
public int[] findArray(int[] pref) {
    int n = pref.length;
    int[] arr = new int[n];

    arr[0] = pref[0];

    for(int i = 1; i < n; i++){
        arr[i] = pref[i] ^ pref[i - 1];
    }

    return arr;
}
```
**💡 Example:**


pref = [5,2,0,3,1]

```
arr[0] = 5
arr[1] = 2 ^ 5 = 7
arr[2] = 0 ^ 2 = 2
...
```
# 🔷 6. XOR Queries of a Subarray ⭐🔥
**📌 Problem:**

Multiple queries → subarray XOR find karo

**🧠 Pattern:**

- 👉 Prefix XOR use karo

- 👉 xor(l → r) = pref[r] ^ pref[l-1]

**✅ Code:**
```java
public int[] xorQueries(int[] arr, int[][] queries) {
    int n = arr.length;
    int[] pref = new int[n];

    pref[0] = arr[0];

    for(int i = 1; i < n; i++){
        pref[i] = pref[i - 1] ^ arr[i];
    }

    int[] res = new int[queries.length];

    for(int i = 0; i < queries.length; i++){
        int l = queries[i][0];
        int r = queries[i][1];

        if(l == 0) res[i] = pref[r];
        else res[i] = pref[r] ^ pref[l - 1];
    }

    return res;
}
```
**💡 Example:**

arr = [1,3,4,8]
Query (1,2) → 3 ^ 4 = 7
