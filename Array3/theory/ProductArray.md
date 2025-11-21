## 1. Problem Summary
Har index **i** ke liye `answer[i]` nikalna hai — jisme `answer[i]` ho **array ke saare elements ka product**, magar `nums[i]` ko chhod kar.

## 2. Constraints
- Division **allowed nahi** hai  
- Time complexity **O(n)** honi chahiye  
- Extra space **O(1)** (sirf output array)

## 3. High Level Idea
Har index ke product ko do parts me tod do:

1. **Left product** → index se pehle ke saare numbers ka product  
2. **Right product** → index ke baad ke saare numbers ka product  

Final formula:

```
answer[i] = left[i] * right[i]
```

## 4. Space Optimization Trick
- Left wale products ko seedha `answer[]` me save karte hain.  
- Right wale products ko ek running variable `right` me calculate karte hue multiply karte hain.  
- Extra arrays ki zarurat nahi padti.

---

## 5. Step-by-Step Algorithm

```
1. Let n = nums.length
2. Create int[] answer = new int[n]

3. // Step 1: Fill left products
   answer[0] = 1
   for i from 1 to n-1:
       answer[i] = answer[i-1] * nums[i-1]

4. // Step 2: Multiply with right products
   int right = 1
   for i from n-1 down to 0:
       answer[i] = answer[i] * right
       right = right * nums[i]

5. Return answer
```

---

## 6. Example Walkthrough

Given:

```
nums = [1, 2, 3, 4]
```

### Left pass result:
```
answer = [1, 1, 2, 6]
```

### Right pass updates:
```
i = 3 → answer[3] = 6  * 1  = 6     right = 1 * 4 = 4
i = 2 → answer[2] = 2  * 4  = 8     right = 4 * 3 = 12
i = 1 → answer[1] = 1  * 12 = 12    right = 12 * 2 = 24
i = 0 → answer[0] = 1  * 24 = 24    right = 24 * 1 = 24
```

### Final Output:
```
[24, 12, 8, 6]
```

---

## 7. Complexity
- **Time:** O(n)  
- **Space:** O(1)

---

## 8. Copy-Ready Short Summary

```
answer[0] = 1
for i=1..n-1:
    answer[i] = answer[i-1] * nums[i-1]

right = 1
for i=n-1..0:
    answer[i] *= right
    right *= nums[i]

return answer
```
