# 📘 1. Array – Introduction
Definition
An array is a collection of similar data types stored in continuous (contiguous) memory locations.

# Key Points
- Fixed size → cannot grow or shrink
- Supports indexing → fast access (O(1))
- Stores elements of same type
- Used for storing data and performing operations like search, sort, etc.


# 📘 2. Array Creation (Declaration & Initialization)
Syntax
```java
int[] arr = new int[5];    // empty array of size 5
int[] nums = {10, 20, 30}; // directly initialized
```
# 📘 3. Array Input (Taking values from user)
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        // input
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
```
# inputArray(Scanner sc)
Code
```java
int n = sc.nextInt();
int[] arr = new int[n];
for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
return arr;
```
# Stepwise
1.sc.nextInt() reads an integer n from user input — the array size.
2.new int[n] allocates a contiguous block of memory for n integers; all initialized to 0.
3.for (i=0; i<n; i++) loops n times to fill each index.
4.arr[i] = sc.nextInt(); reads the next integer and stores it at position i.
5.return arr; returns the filled array to caller.
Why: separates input logic so other methods can call inputArray and get a filled array.

# 📘 4. Array Output (Printing values)
```java
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
```
# Stepwise
1.arr.length gives number of elements.
2.Loop through each index i, print arr[i] followed by a space — keeps elements on same line.
3.After loop, println() moves cursor to next line.

Why: simple readable output of array values.

# 📘 5. Update value in Array
```java
arr[2] = 100; // updates third element
```
# updateAt(int[] arr, int index, int value)

Code
```java
arr[index] = value;
```
# Stepwise
1.Use the bracket notation to access position index.
2.Assign value to that place — this modifies the original array in memory.
Important: No copy is made — arrays are reference types in Java. If index is out-of-bounds, Java throws ArrayIndexOutOfBoundsException.

# 📘 6. Array as Function Argument
Arrays are passed by reference
```java
public static void update(int[] arr) {
    arr[0] = 99;
}
```
```java
public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    update(nums);
    System.out.println(nums[0]); // prints 99
}
```
# makeFirst99(int[] arr) (array as function argument)
```java
if (arr.length > 0) arr[0] = 99;
```
# Stepwise
1.Check arr.length > 0 to avoid empty-array errors.
2.Set first element arr[0] to 99.
3.The calling function sees the updated array (because the function modified the same array object).

Why: demonstrates arrays are passed by reference (the reference is passed by value, but the underlying array can be changed).

# 📘 7. Linear Search
Concept
Check each element one-by-one → If found return index.
Time Complexity: O(n)
Code
```java
public static int linearSearch(int[] arr, int key) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == key) return i;
    }
    return -1;
}
```
# linearSearch(int[] arr, int key)
Code
```java
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == key) return i;
}
return -1;
```
# Stepwise
1.Start from index 0.
2.For each i, compare arr[i] with key.
3.If equal, return i immediately — first occurrence index.
4.If loop finishes without finding key, return -1 to indicate not found.

Complexity: O(n) time, O(1) space.

# 📘 8. Largest Element in Array
Logic
Keep a variable max, compare with each element.
Code
```java
public static int largest(int[] arr) {
    int max = Integer.MIN_VALUE;

    for (int num : arr) {
        if (num > max) max = num;
    }
    return max;
}
```
# largest(int[] arr)
code
```java
int max = Integer.MIN_VALUE;
for (int v : arr) if (v > max) max = v;
return max;
```
# Stepwise
1. Initialize max to smallest possible integer so any real element will be >= it.
2. For each element v in arr, check v > max.
3. If true, set max = v.
4. After checking all, return max.

Edge cases: If array empty, this returns Integer.MIN_VALUE. You may want to handle empty arrays separately in practice.

# 📘 9. Binary Search
Use only when array is Sorted
Logic
- Find mid
- If key == mid → found
- If key < mid → search left
- Else search right

Time Complexity: O(log n)
Code
```java
public static int binarySearch(int[] arr, int key) {
    int start = 0, end = arr.length - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] == key) return mid;
        else if (key < arr[mid]) end = mid - 1;
        else start = mid + 1;
    }
    return -1;
}
```
# binarySearch(int[] arr, int key)

Code
```java
int start = 0, end = arr.length - 1;
while (start <= end) {
    int mid = start + (end - start) / 2;
    if (arr[mid] == key) return mid;
    else if (key < arr[mid]) end = mid - 1;
    else start = mid + 1;
}
return -1;
```
# Stepwise
1. start and end define the current search window.
2. Loop while start <= end (window still valid).
3. Compute mid = start + (end - start)/2 to avoid integer overflow.
4. If arr[mid] == key → found, return mid.
5. If key < arr[mid] → discard right half, end = mid - 1.
6. Else start = mid + 1 → discard left half.
7.If loop exits without finding key, return -1.

Important: The array must be sorted before calling this.
Complexity: O(log n).

# 📘 10. Reverse an Array
Logic
Swap start and end elements.
Code
```java
public static void reverse(int[] arr) {
    int left = 0, right = arr.length - 1;

    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
}
```
# reverse(int[] arr)
Code
```java
int l = 0, r = arr.length - 1;
while (l < r) {
    int tmp = arr[l];
    arr[l] = arr[r];
    arr[r] = tmp;
    l++; r--;
}
```
# Stepwise
1. Start two pointers: l at beginning, r at end.
2. While l < r (they haven't crossed):
 - Save left value into tmp.
 - Put right value in left spot.
 - Put tmp (old left) into right spot.
 - Move l one step right, r one step left.
3.This swaps pairs until array reversed in-place.

Complexity: O(n) time, O(1) extra space.

📘 11. Print All Pairs of an Array
Example for arr = {1,2,3}

Pairs:
(1,2), (1,3), (2,3)

Code
```java
public static void printPairs(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i+1; j < arr.length; j++) {
            System.out.println("(" + arr[i] + ", " + arr[j] + ")");
        }
    }
}
```
# printPairs(int[] arr)
code
```java
for (int i = 0; i < arr.length; i++) {
    for (int j = i + 1; j < arr.length; j++) {
        System.out.println("(" + arr[i] + ", " + arr[j] + ")");
    }
}
```
# Stepwise
1. Outer loop i picks first element of pair.
2. Inner loop j starts from i+1 to avoid duplicate and self-pair.
3. Print the pair (arr[i], arr[j]).
4. This prints all unique unordered pairs.

Complexity: O(n^2) pairs printed.

# 📘 12. Print All Subarrays
Subarray
Continuous part of an array.

Code
```java
public static void printSubarrays(int[] arr) {
    for (int start = 0; start < arr.length; start++) {
        for (int end = start; end < arr.length; end++) {
            for (int k = start; k <= end; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }
}
```
# printSubarrays(int[] arr)
code
```java
for (int start = 0; start < arr.length; start++) {
    for (int end = start; end < arr.length; end++) {
        for (int k = start; k <= end; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}
```
# Stepwise
1. start chooses the beginning index of the subarray.
2. end chooses the ending index (must be >= start).
3. Inner k loop prints elements from start to end inclusive — that’s one subarray.
4. Loops enumerate all contiguous subarrays.

Count: n*(n+1)/2 subarrays. Complexity O(n^3) if printing each element nested like this.

# 📘 13. Maximum Subarray Sum (Kadane’s Algorithm)
Fastest method — O(n)
Concept
Keep adding elements → if sum becomes negative reset to 0.

Code
```java
public static int kadane(int[] arr) {
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;

    for (int num : arr) {
        currentSum += num;
        maxSum = Math.max(maxSum, currentSum);

        if (currentSum < 0) currentSum = 0;
    }
    return maxSum;
}
```
# kadane(int[] arr) (Maximum subarray sum)

Code
```java
int maxSum = Integer.MIN_VALUE;
int current = 0;
for (int v : arr) {
    current += v;
    if (current > maxSum) maxSum = current;
    if (current < 0) current = 0;
}
return maxSum;
```
# Stepwise
1.current accumulates running sum of a candidate subarray.
2.Add each element v to current.
3. If current exceeds maxSum, update maxSum.
4.If current becomes negative, reset current to 0 (no point in carrying a negative prefix).
5.At the end maxSum holds the maximum possible contiguous subarray sum.

Edge cases: Works even if all numbers negative because maxSum starts at Integer.MIN_VALUE. If all negative, maxSum becomes the largest (least negative) element.

Complexity: O(n), O(1) space.
# 📘 14. Trapping Rainwater Problem
Logic
For each bar:
Water = min(leftMax, rightMax) - height[i]

Code
```java
public static int trap(int[] height) {
    int n = height.length;
    if (n == 0) return 0;

    int[] left = new int[n];
    int[] right = new int[n];

    left[0] = height[0];
    for (int i = 1; i < n; i++) {
        left[i] = Math.max(left[i-1], height[i]);
    }

    right[n-1] = height[n-1];
    for (int i = n-2; i >= 0; i--) {
        right[i] = Math.max(right[i+1], height[i]);
    }

    int water = 0;
    for (int i = 0; i < n; i++) {
        water += Math.min(left[i], right[i]) - height[i];
    }

    return water;
}
```
# trap(int[] height) (Trapping Rain Water)

Code
```java
int n = height.length;
int[] left = new int[n];
int[] right = new int[n];

left[0] = height[0];
for (int i = 1; i < n; i++) left[i] = Math.max(left[i - 1], height[i]);

right[n - 1] = height[n - 1];
for (int i = n - 2; i >= 0; i--) right[i] = Math.max(right[i + 1], height[i]);

int water = 0;
for (int i = 0; i < n; i++) water += Math.min(left[i], right[i]) - height[i];
return water;
```
# Stepwise
1. left[i] stores the highest bar from start up to i (including i).
2. right[i] stores the highest bar from end down to i.
3. For each index i, water above i is min(left[i], right[i]) - height[i].
 - min(left[i], right[i]) is the highest water level that can be held at i.
 - Subtract the height to get trapped water.
4. Sum over all i to get total trapped water.

Complexity: O(n) time, O(n) space. There’s also a two-pointer O(1) space approach if needed.

# 📘 15. Best Time to Buy and Sell Stock (Buy → Low, Sell → High)
Concept
- Keep track of minimum price
- Calculate profit for each day
- Maintain max profit

Time Complexity: O(n)
Code
```java
public static int maxProfit(int[] prices) {
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int price : prices) {
        if (price < buyPrice) {
            buyPrice = price;
        } else {
            maxProfit = Math.max(maxProfit, price - buyPrice);
        }
    }
    return maxProfit;
}
```
# maxProfit(int[] prices) (Best time to buy & sell once)

Code
```java
int minPrice = Integer.MAX_VALUE;
int maxProfit = 0;
for (int p : prices) {
    if (p < minPrice) minPrice = p;
    else if (p - minPrice > maxProfit) maxProfit = p - minPrice;
}
return maxProfit;
```
# tepwise
1. minPrice tracks the lowest price observed so far (best day to buy).
2. For each price p:
  - If p is less than minPrice, update minPrice — better buy day.
  - Else compute profit p - minPrice. If this > maxProfit, update maxProfit.
3. After loop, maxProfit is the maximum achievable profit from one buy-sell pair.

Complexity: O(n) time, O(1) space.


# Quick tips & common pitfalls
- Always check for empty arrays (length 0) before accessing arr[0].
- binarySearch requires the array to be sorted first (Arrays.sort(arr)).
- When printing large arrays/subarrays/pairs, complexity quickly becomes large: watch out for     timeouts in online judges.
- For trapping rainwater, if memory matters use the two-pointer method to reduce space from       O(n) to O(1).
- For Kadane, initializing maxSum = Integer.MIN_VALUE handles all-negative arrays.

# Good lunk...
