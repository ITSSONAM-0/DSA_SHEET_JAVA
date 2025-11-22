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

# 1) Print pyramid without trailing spaces
Goal: Print a centered pyramid but avoid any extra spaces at the end of each printed line.
Idea / Logic
- Build each row into a StringBuilder: add left spaces, then stars separated by single spaces,-   but only put a space between stars (not after last star).
- Print the built string once per row — avoids trailing spaces.

Code
```java
public class PyramidNoTrailingSpaces {
    public static void printPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            // left padding
            for (int s = 1; s <= n - i; s++) row.append(" ");
            // stars with spaces BETWEEN them only
            for (int j = 1; j <= i; j++) {
                row.append("*");
                if (j != i) row.append(" "); // avoid trailing space after last star
            }
            System.out.println(row.toString());
        }
    }

    public static void main(String[] args) {
        printPyramid(5);
    }
}
```
# Stepwise
1. For row i, left spaces = n - i.
2. Append i stars; after each star except last add a single space.
3. Print the full StringBuilder.

# Dry-run (n=3)
Rows: " *", " * *", "* * *" — no trailing spaces.
Complexity: O(n^2) time, O(n) extra per row for builder.


#  2) Print patterns using recursion instead of loops
I'll show recursion for a half pyramid and Floyd’s triangle (two styles).

# 2A. Half pyramid (recursive)
Idea: Recursively print rows. For each row i, recursively print stars using a helper.

Code:
```java
public class RecursionHalfPyramid {
    // prints stars for current row using recursion
    static void printStars(int count) {
        if (count == 0) return;
        printStars(count - 1);
        System.out.print("* ");
    }

    // recursively print rows 1..n
    static void printRows(int i, int n) {
        if (i > n) return;
        printStars(i);
        System.out.println();
        printRows(i + 1, n);
    }

    public static void main(String[] args) {
        printRows(1, 5);
    }
}
```
# stepwise
1. printRows(i,n) base: i>n stop.
2. printStars(i) prints i stars by recursion.
3. After printing row, recursive call for i+1.

Complexity: O(n^2) calls and prints; recursion depth = O(n).

# 2B. Floyd’s triangle (recursive)
Idea: Keep a counter and row index; recurse on columns.

Code;
```java
public class RecursionFloyd {
    static int counter = 1;

    static void printRow(int i, int j) {
        if (j > i) return;
        System.out.print(counter++ + " ");
        printRow(i, j + 1);
    }

    static void printFloyd(int i, int n) {
        if (i > n) return;
        printRow(i, 1);
        System.out.println();
        printFloyd(i + 1, n);
    }

    public static void main(String[] args) {
        printFloyd(1, 4);
    }
}
```
Complexity: O(n^2), recursion depth O(n).

# 3) Print pattern rotated 90°
We’ll rotate the half pyramid 90 degrees clockwise and anticlockwise examples.

# 3A. Half pyramid rotated 90° clockwise

Target (n=4)
```markdown
* * * *
* * *
* *
*
```
This is actually inverted half pyramid — but rotation often means columns become rows. For 90° clockwise of a left aligned half pyramid:

# Code (clockwise of left half pyramid)

```java
public class Rotate90Clockwise {
    public static void rotateClockwise(int n) {
        // For a left half pyramid of height n the 90-degree clockwise results in n rows but stars count = n-i+1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rotateClockwise(5);
    }
}
```
# 3B. Half pyramid rotated 90° anticlockwise
Target (n=4)
```java
*
* *
* * *
* * * *
```
(That's just the normal left-aligned half pyramid — anticlockwise depends on original orientation.)

# General method to rotate arbitrary grid pattern:
- Build 2D char matrix grid[row][col] for original pattern (rows R, cols C).
- To rotate 90° clockwise: print grid[R-1 - r][c] in loops over c (0..C-1) and r (0..R-1) appropriately, or create new rot[c][R-1-r] = grid[r][c].

Complexity: Building matrix O(RC), rotating O(RC).

# 4) Given a pattern — deduce formula for stars/spaces for row i
Approach (stepwise):
1. Count rows R. Decide whether index i ranges 0..R-1 or 1..R.
2. For each row, count stars S(i) and spaces Sp(i) visually or by small i examples.

3. Find mathematical expressions: linear (i, n-i), double (2*i-1) or piecewise (mirror halves).
4. Check symmetries (upper/lower halves) or boundaries (first/last rows).

Examples
 - Centered pyramid: stars = 2*i - 1, left spaces = n - i.
 - Butterfly upper part: left stars = i, middle spaces = 2*(n-i), right stars = i.
 - Hollow rectangle: stars when i == 1 || i == n || j==1 || j==m.

Tip: Always map constants to n and row i. If you see odd counts: 2*i-1. If mirrored: treat two halves separately.

# 5) Edge case handling — n=0 and huge n

Guidelines
- If n <= 0: print nothing or print a message "No rows to print".
- For huge n: output itself becomes huge (Ω(n^2) characters). Instead:
     - Validate n and limit it (e.g., if (n > 1000) throw/limit).
     - Use StringBuilder and print row-by-row rather than many System.out.print calls.
     - For memory efficiency, print row and discard StringBuilder.
  - Defensive code example below.

Example snippet;
```java
if (n <= 0) {
    System.out.println("No rows to print.");
    return;
}
if (n > 2000) { // guard to avoid accidental huge outputs
    System.out.println("n too large; reduce n");
    return;
}
```
# 6) Pascal’s triangle
Idea / Logic

- Row r (0-indexed) has r+1 numbers: binomial coefficients C(r, k).
- Use iterative formula: next = prev * (r - k) / (k + 1) to avoid factorials (safe and O(r) per row).

Code:
```java
import java.util.*;

public class PascalsTriangle {
    // Print first n rows (n >= 1)
    public static void printPascals(int n) {
        if (n <= 0) {
            System.out.println("No rows");
            return;
        }
        for (int r = 0; r < n; r++) {
            // left padding for centered look (optional)
            for (int s = 0; s < n - r - 1; s++) System.out.print(" ");
            long val = 1;
            for (int k = 0; k <= r; k++) {
                System.out.print(val + " ");
                // update val = C(r, k+1) from C(r,k)
                val = val * (r - k) / (k + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPascals(6);
    }
}
```
# Stepwise
1. For row r, start val=1 (C(r,0)).
2. Print val. Then update: val = val * (r - k) / (k + 1) (integer division is exact).
3. Continue until k=r.

Complexity: O(n^2) time, O(1) extra space per row.

Edge: Use long for larger rows; big rows may overflow — use BigInteger if needed.

# 7) Mirrored number pyramid
Target (n=5)
```markdown
    1
   2 2
  3 3 3
 4 4 4 4
5 5 5 5 5
```
(Left padded so it’s right-aligned)
# Logic
- Row i prints i copies of number i with left spaces n - i.

Code:
```java
public class MirroredNumberPyramid {
    public static void printMirrored(int n) {
        for (int i = 1; i <= n; i++) {
            // left spaces
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            // numbers with a space between, avoid trailing if needed
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
                if (j != i) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMirrored(5);
    }
}
```
Complexity: O(n^2).

# 8) Hollow diamond of numbers

Target (n = 5) (diamond height 2n-1, outer numbers as row identifier)
Example (n=5 simplified numeric hollow diamond centered):
```markdown
    1
   2 2
  3   3
 4     4
5       5
 4     4
  3   3
   2 2
    1
```
 # Logic
- Upper part i=1..n:
    - left spaces = n - i
    - if i == 1 print 1
    - else print i, then inner spaces 2*(i-1)-1, then i

- Lower part mirror.

Code
```java
public class HollowNumberDiamond {
    public static void printHollowDiamond(int n) {
        // upper
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            if (i == 1) {
                System.out.println("1");
            } else {
                System.out.print(i);
                for (int s = 1; s <= 2 * (i - 1) - 1; s++) System.out.print(" ");
                System.out.println(i);
            }
        }
        // lower
        for (int i = n - 1; i >= 1; i--) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            if (i == 1) {
                System.out.println("1");
            } else {
                System.out.print(i);
                for (int s = 1; s <= 2 * (i - 1) - 1; s++) System.out.print(" ");
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        printHollowDiamond(5);
    }
}
```
# Stepwise
1. Handle i==1 separately because inner spaces formula gives negative or zero.
2. For others, outer spaces then i, inner spaces, i.

Complexity: O(n^2).

# 9) Zig-zag pattern for given n

Typical zig-zag pattern (on 3 rows commonly used in practice) — for n columns:
Example n=9 (rows fixed = 3):
```markdown
*   *   * 
 * * * *  
  *   *   
```
This is a common coding pattern.

# Logic
- For row r (0..2) and column c (1..n), print * when (r + c) % 4 == 0 or (r == 1 && c % 2 == 0)   depending on your zig logic. Standard pattern:
    - Row 0: print * when c % 4 == 1
    - Row 1: print * when c % 2 == 0
    - Row 2: print * when c % 4 == 3

Code (standard 3-row zig zag)
```java
public class ZigZagPattern {
    public static void printZigZag(int n) {
        int rows = 3;
        for (int r = 0; r < rows; r++) {
            for (int c = 1; c <= n; c++) {
                if ((r == 0 && c % 4 == 1) ||
                    (r == 1 && c % 2 == 0) ||
                    (r == 2 && c % 4 == 3))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printZigZag(15);
    }
}
```
# Stepwise
- Check column pattern rules for each row; print * or space.

Complexity: O(n).

Variation: Zig-zag with variable height uses similar modular formulas.

# 10) Given output — reverse engineering approach (and example)
Approach
1. Count rows R.
2. For each row index i list counts of stars/spaces/numbers.
3. Try to express counts as function of i and n.
4. Build loops according to segments discovered.
5.Test with small n to verify.

Example problem (reverse engineer): Given
```markdown
    1
   121
  12321
 1234321
123454321
```
Goal: produce code.
Reverse engineering
- Rows n=5. For row i (1..n):
   - left spaces: n - i
   - increasing numbers from 1 to i
   - then decreasing numbers from i-1 down to 1

Solution code
```java
public class PalindromicNumberPyramid {
    public static void printPalindromic(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            // ascending
            for (int x = 1; x <= i; x++) System.out.print(x);
            // descending
            for (int x = i - 1; x >= 1; x--) System.out.print(x);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPalindromic(5);
    }
}
```
# Stepwise
1. Identify segments: spaces, ascending, descending.
2. Translate each to a loop.

---

# Quick notes on style & efficiency
- For heavy printing prefer StringBuilder per row then System.out.println(sb).
- For patterns where numbers can overflow (Pascal), use BigInteger.
- Always handle n <= 0 gracefully.
- For interview: explain formula, dry-run for small n, show time/space complexity, mention       edge cases.
