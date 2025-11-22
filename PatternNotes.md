# Complete Java Pattern Notes 



---

## Table of Contents

1. Pattern Theory (Introduction)
2. How to approach any pattern — Stepwise method
3. Star Square (Solid Square)
4. Half Pyramid (Nested Loops Start Pattern)
5. Inverted Star Pattern (Inverted Half Pyramid)
6. Rotated/Inverted Rotated Half Pyramid
7. Character Pattern (Alphabet Triangle)
8. Hollow Rectangle
9. Inverted Half Pyramid with Numbers
10. Floyd's Triangle
11. 0-1 Triangle Pattern
12. Butterfly Pattern
13. Solid Rhombus
14. Hollow Rhombus
15. Diamond Pattern
16. Common Interview Questions & Variations
17. Practice Problems & Exercises
18. Appendix: Quick Reference — Loops and Complexity

---

# 1. Pattern Theory (Short Recap)

**What is pattern printing?**
Pattern printing is using loops (usually nested loops) to build visual shapes on console output. The building blocks are: stars (`*`), numbers, characters, spaces, and newline (`System.out.println()`).

**Why it's asked in interviews:**

* Tests mastery over loops and flow control
* Tests ability to break problems into row/column logic
* Tests dry-run and debugging skills

**Common approach:**

* Outer loop -> iterates rows
* Inner loop(s) -> control how many characters/spaces get printed in each row

---

# 2. How to approach any pattern — Stepwise method

1. **Identify rows** — how many lines will print? Usually `n` or derived from `n`.
2. **For each row, determine content** — how many stars, spaces, numbers. Express each as formula of row index `i` (and sometimes column `j`).
3. **Break row content into *segments*** — typically: left spaces, left symbols, middle spaces, right symbols.
4. **Implement loops for each segment** — one inner loop per segment.
5. **Dry run** with small `n` (3 or 4) and track `i` and `j` values.
6. **Edge cases** — `n = 0`, `n = 1`, odd/even counts for symmetric patterns.
7. **Time complexity** — usually O(n^2) because nested loops.

Use the template:

```java
for (int i = 1; i <= rows; i++) {
    // segment 1
    for (int s = 1; s <= seg1Count(i); s++) System.out.print(" ");

    // segment 2
    for (int j = 1; j <= seg2Count(i); j++) System.out.print("*");

    // more segments as needed

    System.out.println();
}
```

---

# 3. Star Square (Solid Square)

**Pattern (n = 4):**

```
* * * *
* * * *
* * * *
* * * *
```

**Logic / Steps:**

1. Number of rows = `n`.
2. For each row print `n` stars separated by space.

**Code (Java):**

```java
public class SolidSquare {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

**Dry run (n=2):**

* i=1 -> j runs 1..2 prints `* * ` -> newline
* i=2 -> same

**Complexity:** O(n^2) time, O(1) space.

**Interview tip:** If asked to remove trailing space, check printing logic and print `"*"` plus a conditional space.

---

# 4. Half Pyramid (Nested Loops Start Pattern)

**Pattern (n=4):**

```
*
* *
* * *
* * * *
```

**Logic / Steps:**

1. Rows = n.
2. For row `i`, print `i` stars.

**Code (Java):**

```java
public class HalfPyramid {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

**Stepwise explanation:**

* i=1 -> inner runs j=1 -> prints `* `
* i=2 -> inner runs j=1..2 -> prints `* * `

**Variations:** left aligned, right aligned (add spaces before stars).

---

# 5. Inverted Star Pattern (Inverted Half Pyramid)

**Pattern (n=5):**

```
* * * * *
* * * *
* * *
* *
*
```

**Logic:** For row `i` from 0..n-1 print `n-i` stars.

**Code:**

```java
public class InvertedHalfPyramid {
    public static void main(String[] args) {
        int n = 5;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

**Dry run:** i=5 -> prints 5 stars; i=4 -> prints 4 stars ...

---

# 6. Rotated / Inverted Rotated Half Pyramid (Right-aligned Half Pyramid)

**Pattern (n=5):**

```
        *
      * *
    * * *
  * * * *
* * * * *
```

**Logic / Steps:**

1. For each row i (1..n):

   * print `n-i` spaces (each space as `"  "` when using `* ` to align)
   * print `i` stars

**Code:**

```java
public class RotatedHalfPyramid {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print("  ");
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }
}
```

**Note:** Use consistent unit for a space so alignment is correct when printing `* ` (star + space).

---

# 7. Character Pattern (Alphabet Triangle)

**Pattern (n=4):**

```
A
A B
A B C
A B C D
```

**Logic:** For row `i`, print first `i` uppercase letters starting from 'A'.

**Code:**

```java
public class AlphabetTriangle {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((char)('A' + j) + " ");
            }
            System.out.println();
        }
    }
}
```

**Dry run (i=3):** prints `A B C `

---

# 8. Hollow Rectangle Pattern

**Pattern (r=4, c=6):**

```
******
*    *
*    *
******
```

**Logic:** Print `*` on boundary positions (first/last row or first/last column), otherwise print space.

**Code:**

```java
public class HollowRectangle {
    public static void main(String[] args) {
        int r = 4, c = 6;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i == 1 || i == r || j == 1 || j == c)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
```

**Stepwise:** Check boundary conditions for each cell.

---

# 9. Inverted Half Pyramid with Numbers

**Pattern (n=5):**

```
12345
1234
123
12
1
```

**Logic:** Row count equals `n`. For row i from n down to 1, print numbers 1..i.

**Code:**

```java
public class InvertedHalfPyramidNumbers {
    public static void main(String[] args) {
        int n = 5;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
```

**Dry run (n=3):** prints `123`, `12`, `1`.

---

# 10. Floyd's Triangle

**Pattern (n=4):**

```
1
2 3
4 5 6
7 8 9 10
```

**Logic:** Maintain a counter `num` that increases across the whole triangle. For row i, print i numbers continuing the counter.

**Code:**

```java
public class FloydsTriangle {
    public static void main(String[] args) {
        int n = 4;
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
```

**Tip:** Good to ask time/space complexity: O(n^2) time.

---

# 11. 0-1 Triangle Pattern

**Pattern (n=4):**

```
1
0 1
1 0 1
0 1 0 1
```

**Logic:** Value depends on `(i + j)` parity. If `(i + j) % 2 == 0` -> print `1` else `0`.

**Code:**

```java
public class ZeroOneTriangle {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
```

**Explanation:** Row 1, col1 -> (1+1)=2 even -> 1. Row2 col1 -> 3 odd -> 0.

---

# 12. Butterfly Pattern

**Pattern (n=4):**

```
*      *
**    **
***  ***
********
***  ***
**    **
*      *
```

**Logic / Steps:**

* The butterfly has `2*n` rows (upper n, lower n).
* For row i (1..n):

  * print i stars, then print `2*(n-i)` spaces, then print i stars.
* For lower part mirror with i from n down to 1.

**Code:**

```java
public class ButterflyPattern {
    public static void main(String[] args) {
        int n = 4;
        // upper
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            for (int s = 1; s <= 2 * (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
        // lower
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            for (int s = 1; s <= 2 * (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }
}
```

**Dry run (n=2):**

* upper i=1 -> `*  *` (1 star, 2 spaces, 1 star)
* upper i=2 -> `****`
* lower i=2 -> `****`
* lower i=1 -> `*  *`

**Variation:** Add spaces between stars if you want `* ` formatting.

---

# 13. Solid Rhombus

**Pattern (n=5):**

```
    *****
   *****
  *****
 *****
*****
```

**Logic:** For each row i (1..n): print `n-i` leading spaces then print n stars.

**Code:**

```java
public class SolidRhombus {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= n; j++) System.out.print("*");
            System.out.println();
        }
    }
}
```

---

# 14. Hollow Rhombus

**Pattern (n=5):**

```
    *****
   *   *
  *   *
 *   *
*****
```

**Logic:** Leading spaces = `n-i`. Then `n` columns but print `*` at border columns or rows.

**Code:**

```java
public class HollowRhombus {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");

            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
```

---

# 15. Diamond Pattern

**Pattern (n=5):**

```
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
```

**Logic / Steps:**

* Upper half (i=1..n): leading spaces `n-i`, then print `2*i-1` stars.
* Lower half (i=n-1..1): leading spaces `n-i`, then `2*i-1` stars.

**Code:**

```java
public class DiamondPattern {
    public static void main(String[] args) {
        int n = 5;
        // upper
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        // lower
        for (int i = n - 1; i >= 1; i--) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }
}
```

---

# 16. Common Interview Questions & Variations

1. **Print pyramid without trailing spaces** — remove extra spaces at line end.
2. **Print patterns using recursion instead of loops.**
3. **Print pattern rotated 90 degrees.**
4. **Given a pattern, deduce the formula for stars/spaces for row `i`.**
5. **Edge case handling** — n=0 or huge `n`.

**Sample interview questions:**

* Explain how you'd print the hollow diamond. (Answer: combine logic of hollow rectangle borders with diamond geometry.)
* How to print the pattern using `StringBuilder` for performance? (Concatenate row into string, then print once per row.)
* How to reduce time if `n` is large? (You cannot asymptotically beat O(n^2) since output size is O(n^2), but you can reduce constant factors: use `StringBuilder`, avoid printing inside inner loops.)

---

# 17. Practice Problems & Exercises

1. Print Pascal's triangle.
2. Print mirrored number pyramid.
3. Print a hollow diamond of numbers.
4. Print zig-zag pattern for given `n`.
5. Given output, write code to produce it (reverse engineering).

---

# 18. Appendix: Quick Reference

* **Outer loop** controls rows.
* **Inner loop(s)** control columns, spaces, or symbols.
* **Time Complexity**: Most patterns O(n^2).
* **Space Complexity**: O(1) (except when building strings first).

---

