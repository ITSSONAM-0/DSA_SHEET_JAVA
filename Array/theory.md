# Merge Sorted Arrays 1

# ⭐ Problem Kya Hai? 
nums1 aur nums2 dono sorted arrays hain.
- nums1 mein last mein extra 0 diye hote hain jisme hum nums2 ko merge karenge.
- Hume dono arrays ko sort ke sath merge karna hai → nums1 ke andar hi.

# Example:-
```ini
nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]
m = 3 (nums1 ke original elements ka count)
n = 3 (nums2 ke elements ka count)
```
# Final output hoga:
```csharp
[1,2,2,3,5,6]
```
# ⭐ Easy Explanation — Step by Step
# 1. Pointer banaye gaye

```java
int i = m - 1;   // nums1 ka last valid element → index 2 (value 3)
int j = n - 1;   // nums2 ka last element → index 2 (value 6)
int k = m + n - 1; // nums1 ka last index → 5
```
# 2. Compare hamesha peeche se
Hum peeche se compare karenge kyunki nums1 ke end me space khali hai.
- Compare nums1[i] aur nums2[j]
- Jo bada hoga wo nums1[k] me store hoga
Example:
- Compare: 3 vs 6 → 6 bada hai → nums1[5] = 6
- j--, k--
# 3. Repeat until ek array khatam na ho jaye
Har step me largest element end me put karte jaate hain:
| Compare | Bigger | nums1 me store | nums1 updated |
| ------- | ------ | -------------- | ------------- |
| 3 vs 6  | 6      | index 5        | [1,2,3,0,0,6] |
| 3 vs 5  | 5      | index 4        | [1,2,3,0,5,6] |
| 3 vs 2  | 3      | index 3        | [1,2,3,3,5,6] |

i--, j--, k-- accordingly.

# 4. nums1 finish ho jaye to?
Agar nums2 ke elements bache hain to unhe copy kar do:
```java
while (j >= 0) {
    nums1[k] = nums2[j];
    j--;
    k--;
}
```
# ⭐ Final Output
```csharp
[1, 2, 2, 3, 5, 6]
```
# ⭐ Summary (Ultra Easy)
- Teen pointers use karo:
i → nums1 ke last valid element
j → nums2 ke last element
k → nums1 ke last empty position
- Jo number bada ho → nums1[k] me daal do
- Move pointers back
- End me agar nums2 bacha ho → usko copy kar do

# code
```java
import java.util.*;

public class Merges {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // pointer for nums1
        int j = n - 1; // pointer for nums2
        int k = m + n - 1; // pointer for placement in nums1

        // Merge from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has elements left
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
```

