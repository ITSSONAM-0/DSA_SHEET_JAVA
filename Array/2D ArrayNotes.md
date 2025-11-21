# 2D Arrays — Theory, Interview Notes & Java Code

> A compact but comprehensive guide for interviews: introduction, real-life examples, memory representation, creation, common operations and careful step-by-step Java code with explanations.

---

## 1. Introduction to 2D arrays

A **2D array** is an array of arrays — it models data in a grid (rows × columns). In Java, a 2D array is declared as `int[][] matrix;`. Each element is accessed by two indices: `matrix[i][j]` (row `i`, column `j`).

**Why useful?** Many problems map naturally to 2D arrays: matrices, images, chess boards, tables, dynamic programming tables, graphs (adjacency matrix), game boards, spreadsheets.

## 2. Real-life examples

* **Image pixels**: `height × width` grid where each cell stores color/intensity.
* **Chess board**: 8×8 grid storing pieces.
* **Spreadsheet**: rows and columns holding numbers/text.
* **Seating chart**: rows × columns of seats.
* **Elevation map**: grid of altitudes used by pathfinding algorithms.

## 3. Representation of 2D arrays in Java

Java implements 2D arrays as **array-of-references**: `int[][] a = new int[3][4];` creates an array of 3 references (rows), each pointing to a `int[4]` array (columns). Rows can have different lengths (jagged arrays): `int[][] jagged = { {1,2}, {3,4,5} };`.

**Visualization (logical):**

```
matrix (reference) -> row0[] -> [0,1,2,3]
                     row1[] -> [0,1,2,3]
                     row2[] -> [0,1,2,3]
```

**Memory note:** Elements of inner arrays are contiguous within each row, but rows themselves might not be contiguous relative to each other.

## 4. Creation of 2D arrays (Java)

### Static (literal) initialization

```java
int[][] a = { {1,2,3}, {4,5,6}, {7,8,9} };
```

### Fixed-size creation

```java
int[][] a = new int[3][4]; // 3 rows, 4 columns; default values 0
```

### Jagged (rows different length)

```java
int[][] jag = new int[3][]; // create rows
jag[0] = new int[2];
jag[1] = new int[4];
jag[2] = new int[1];
```

### Fill values

Use loops or `Arrays.fill` per row.

## 5. Common operations (with time complexity)

* Access `matrix[i][j]`: `O(1)`.
* Iterate full matrix: `O(R*C)` where R=#rows, C=#cols.
* Row-major traversal vs column-major traversal (cache locality): in Java, iterate rows first then columns for better locality.

---

## 6. Typical interview problems — explanations, Java code, and step-by-step commentary

Each problem below includes:

* problem statement
* Java solution (clean function/class)
* step-by-step explanation
* time & space complexity

### Problem A — Print matrix in spiral order (Spiral Matrix)

**Statement:** Given an `m × n` matrix, return the elements in spiral order (clockwise), starting from top-left.

**Approach:** Maintain four boundaries: `top`, `bottom`, `left`, `right`. Move in four directions (left→right, top→bottom, right→left, bottom→top) and shrink boundaries.

**Code (Java)**

```java
import java.util.*;

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int top = 0, left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1) left -> right along top row
            for (int j = left; j <= right; j++) res.add(matrix[top][j]);
            top++;

            // 2) top -> bottom along right column
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                // 3) right -> left along bottom row
                for (int j = right; j >= left; j--) res.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                // 4) bottom -> top along left column
                for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
    }

    // small test
    public static void main(String[] args) {
        int[][] a = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(spiralOrder(a));
    }
}
```

**Step-by-step explanation:**

1. Initialize boundaries: `top=0, bottom=rows-1, left=0, right=cols-1`.
2. While boundaries are valid (`top<=bottom && left<=right`) perform four sweeps:

   * Sweep the top row from `left` to `right`. Then `top++` because that row is consumed.
   * Sweep the right column from `top` to `bottom`. Then `right--`.
   * If `top<=bottom`, sweep the bottom row from `right` down to `left`. Then `bottom--`.
   * If `left<=right`, sweep the left column from `bottom` up to `top`. Then `left++`.
3. Continue until boundaries cross.

**Complexity:** Time `O(R*C)` visiting each element once. Space `O(1)` extra (excluding output list).

### Problem B — Diagonal Sum (sum of primary and secondary diagonals)

**Statement:** Given a square matrix `n×n`, compute the sum of the primary diagonal (`i==j`) and secondary diagonal (`i + j == n - 1`). If the center element belongs to both diagonals (odd n), count it once.

**Approach:** Loop `i` from `0` to `n-1`, add `matrix[i][i]` (primary) and `matrix[i][n-1-i]` (secondary). If they are same index (center), add only once.

**Code (Java)**

```java
public class DiagonalSum {
    public static int diagonalSum(int[][] a) {
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i][i]; // primary
            if (i != n - 1 - i) sum += a[i][n - 1 - i]; // secondary if different
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] m = { {1,2,3}, {4,5,6}, {7,8,9} };
        System.out.println(diagonalSum(m)); // 25
    }
}
```

**Step-by-step explanation:**

* For `i=0`: add `a[0][0]` and `a[0][2]`.
* For `i=1`: add `a[1][1]` (center). Since `1 == n-1-1`, only add once.
* Continue; complexity `O(n^2)?` No — loop is `O(n)` because only `n` iterations. Space `O(1)`.

**Complexity:** Time `O(n)`, Space `O(1)`.

### Problem C — Search in a row-wise & column-wise sorted matrix (Staircase Search)

**Statement:** Given a matrix where rows are sorted left→right and columns are sorted top→bottom, search for a target value and return its position or `(-1,-1)` if not found.

**Approach (staircase search):** Start at top-right cell `(0, cols-1)`. If value == target → found. If value > target → move left. If value < target → move down. This works because of the sorted properties.

**Code (Java)**

```java
public class SearchSortedMatrix {
    // returns {row, col} or {-1, -1}
    public static int[] search(int[][] a, int target) {
        int m = a.length;
        if (m == 0) return new int[]{-1,-1};
        int n = a[0].length;
        int r = 0, c = n - 1; // start top-right
        while (r < m && c >= 0) {
            if (a[r][c] == target) return new int[]{r, c};
            else if (a[r][c] > target) c--; // eliminate this column
            else r++; // eliminate this row
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] m = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10,13,14,17}
        };
        int target = 9;
        int[] pos = search(m, target);
        System.out.println(Arrays.toString(pos)); // [2,2]
    }
}
```

**Step-by-step explanation:**

1. Start at `(r,c) = (0, n-1)` (top-right). This element is the largest in its row and smallest in its column among the remaining submatrix.
2. If `a[r][c] == target`, done.
3. If `a[r][c] > target`, then all elements in column `c` below could be larger or equal, but *in this row* everything left could be smaller — we can safely `c--` to reduce possible candidates.
4. If `a[r][c] < target`, then all elements in row `r` to the left are smaller so move `r++`.
5. Repeat while indices valid.

**Complexity:** Time `O(m + n)`, Space `O(1)`.

### Problem D — Binary search within a sorted row (helper for other strategies)

**Statement:** Given a sorted array (row), binary search for target and return index or -1.

**Code (Java)**

```java
public static int binarySearch(int[] row, int target) {
    int l = 0, r = row.length - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (row[mid] == target) return mid;
        else if (row[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return -1;
}
```

**Use-case:** If the matrix is sorted row-wise but not column-wise, first identify the candidate row (maybe via binary search on first/last elements) then binary-search inside the row. Complexity depends on method used.

### Problem E — Search in a fully sorted matrix treated as 1D (optional pattern)

**Statement:** If a matrix has all elements in row-major order sorted (i.e., flattening keeps sorted order), you can map index `k` to `(k / cols, k % cols)` and do 1D binary search.

**Code (Java)**

```java
public static int[] searchFlattened(int[][] a, int target) {
    int m = a.length, n = a[0].length;
    int l = 0, r = m * n - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        int val = a[mid / n][mid % n];
        if (val == target) return new int[]{mid / n, mid % n};
        else if (val < target) l = mid + 1;
        else r = mid - 1;
    }
    return new int[]{-1,-1};
}
```

**Complexity:** Time `O(log(m*n)) = O(log m + log n)`, Space `O(1)`.

---

## 7. Helpful small utilities & printing

**Printing matrix**

```java
public static void printMatrix(int[][] a) {
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++)
            System.out.print(a[i][j] + " ");
        System.out.println();
    }
}
```

**Transpose** (common interview small function)

```java
public static int[][] transpose(int[][] a) {
    int r = a.length, c = a[0].length;
    int[][] t = new int[c][r];
    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            t[j][i] = a[i][j];
    return t;
}
```

---

## 8. Memory layout reminder (for interview questions asking about memory)

* Java 2D arrays are references to row arrays: `int[][] a` is a single object (the outer array) containing references to inner `int[]` row arrays.
* Each `int[]` row is a separate object with contiguous memory for its elements (within the row).
* For `new int[R][C]`, JVM typically allocates the outer array and then R inner `int[]` arrays.

## 9. Common pitfalls & interview tips

* Watch out for **index-out-of-bounds** when implementing spiral or boundary-based traversals — always update boundaries at the right time and check loop conditions.
* For **jagged arrays**, don't assume `a[0].length` is valid for all rows.
* When calculating mid index in binary search use `mid = l + (r - l) / 2` to avoid overflow (classic tip).
* Verify whether the matrix is *fully sorted (flattened)* or *row and column-sorted* — they allow different optimal solutions.
* Always state time/space complexity and edge cases (empty matrix, 1×1 matrix, single row/column).

## 10. Quick interview-style checklist to say out loud

* Problem constraints (R, C up to what?)
* Expected time/space.
* Whether matrix is square, jagged, or fully sorted.
* Edge cases: empty, single row/column, odd/even sizes.
* Explain choice of algorithm and prove correctness (why staircase search eliminates rows/cols, why spiral boundaries shrink correctly).

---

### Appendix: Full working sample file (combining functions)

```java
import java.util.*;

public class MatrixInterviewUtils {
    // includes spiralOrder, diagonalSum, staircase search, flattened search

    public static List<Integer> spiralOrder(int[][] matrix) { /* implementation omitted for brevity */ return null; }
    public static int diagonalSum(int[][] a) { /* ... */ return 0; }
    public static int[] staircaseSearch(int[][] a, int target) { /* ... */ return new int[]{-1,-1}; }
    public static int[] flattenedSearch(int[][] a, int target) { /* ... */ return new int[]{-1,-1}; }

    public static void main(String[] args) {
        // add tests and demonstration when using the utility class
    }
}
```

(If you'd like, I can expand the Appendix to include a fully runnable single-file Java program that implements every method in full.)

---

