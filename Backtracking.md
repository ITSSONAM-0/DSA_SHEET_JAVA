# 🔥 1. Backtracking kya hota hai?
**
👉 Simple definition:**

**"Try → Check → Undo → Try next"**

**Matlab:
**
- Ek choice lo
- Check karo valid hai ya nahi
- Agar valid hai → aage badho
- Agar galat ho gaya → wapas aao (backtrack) aur dusri choice try karo

# 🧠 Real Life Example

**Socho tum maze me ho 🧩**
- Ek path choose kiya
- Dead end mila ❌
- Wapas aaye (backtrack)
- Dusra path try kiya ✅

**👉 Yehi backtracking hai**

# 🔑 2. Kab use hota hai?

**Backtracking tab use hota hai jab:**

**✔️ All possible answers chahiye**

- Permutations
- Subsets
- Combinations

**✔️ Constraints ho**
- Sudoku
- N-Queens
- Rat in Maze

**✔️ Decision tree explore karna ho**

- Yes / No type choices
- Include / Exclude

# 🧩 3. Backtracking ka Template (MOST IMPORTANT)
**👉 Har problem me ye structure use hota hai:**
```java
void backtrack(parameters) {

    // 1. Base case
    if (condition) {
        result.add(copy);
        return;
    }

    // 2. Choices loop
    for (choices) {

        // 3. Choose
        add choice

        // 4. Explore
        backtrack(next state)

        // 5. Undo (Backtrack)
        remove choice
    }
}
```
# 🪜 4. Step-by-step Flow
1. Choice lo
2. Recursion call karo
3. Wapas aao
4. Choice hatao

**👉 Isko bolte hain: Recursion + Undo**

# 💥 5. Example 1: Subsets

Input: [1,2]
**

Output:**
```
[], [1], [2], [1,2]
```
**code**
```java
void backtrack(int[] nums, int start, List<Integer> temp) {
    result.add(new ArrayList<>(temp));

    for (int i = start; i < nums.length; i++) {
        temp.add(nums[i]);                // choose
        backtrack(nums, i + 1, temp);    // explore
        temp.remove(temp.size() - 1);    // undo
    }
}
```
# 💥 6. Example 2: Permutations

Input: [1,2,3]

**👉 Order matter karta hai**
```java
void backtrack(List<Integer> temp) {
    if (temp.size() == nums.length) {
        result.add(new ArrayList<>(temp));
        return;
    }

    for (int num : nums) {
        if (temp.contains(num)) continue;

        temp.add(num);           // choose
        backtrack(temp);         // explore
        temp.remove(temp.size()-1); // undo
    }
}
```
# 💥 7. Example 3: N-Queens (Concept)

**👉 Queen ko aise place karo ki koi attack na kare
**
- Row by row try karo
- Valid hai → aage badho
- Invalid → backtrack

# ⚡ 8. Backtracking vs Recursion

| Recursion                    | Backtracking                |
| ---------------------------- | --------------------------- |
| Bas call karta hai           | Call + Undo karta hai       |
| All paths explore nahi karta | Smartly explore karta hai   |
| No constraint handling       | Constraint handle karta hai |

# 🎯 9. Kaise pehchane ki Backtracking use karna hai?

**Agar question me ye words ho:
**
- "All possible"
- "Generate"
- "Find all combinations"
- "Arrange"
- "Valid configuration"

**👉 💥 = Backtracking use karo
**
# 🧠 10. Important Problems List

# 🚀 11. Shortcut Trick (Interview)

**👉 Always think:**
```
Tree bana raha hu?
Har level = ek decision?
Yes → Backtracking
```
# 🔥 Final Summary

👉 Backtracking =
"Recursion + Choice + Undo"

**👉 Golden Formula:**
```
Choose → Explore → Undo
```

# 🔥 1. Subsets (Power Set)
**🧠 Idea:**

- Har element ke liye 2 choice:
👉 include / exclude

- Start index use hota hai (duplicate avoid)

**✅ Pattern:**
```
Take → Explore → Remove
```
code
```java
void backtrack(int[] nums, int start, List<Integer> temp) {
    result.add(new ArrayList<>(temp));

    for (int i = start; i < nums.length; i++) {
        temp.add(nums[i]);
        backtrack(nums, i + 1, temp);
        temp.remove(temp.size() - 1);
    }
}
```

# 🔥 2. Permutations
**🧠 Idea:**
- Order matters
- Har element ek baar hi use hoga

**✅ Pattern:**
```
Pick any unused number
```

```java
void backtrack(List<Integer> temp) {
    if (temp.size() == nums.length) {
        result.add(new ArrayList<>(temp));
        return;
    }

    for (int num : nums) {
        if (temp.contains(num)) continue;

        temp.add(num);
        backtrack(temp);
        temp.remove(temp.size() - 1);
    }
}
```
# 🔥 3. Combination Sum
**🧠 Idea:**

- Same element multiple baar use ho sakta hai
- Target achieve karna hai

**✅ Pattern:**
```
Stay on same index (reuse allowed)
```
code 
```java
void backtrack(int[] nums, int target, int start, List<Integer> temp) {
    if (target == 0) {
        result.add(new ArrayList<>(temp));
        return;
    }

    for (int i = start; i < nums.length; i++) {
        if (nums[i] > target) continue;

        temp.add(nums[i]);
        backtrack(nums, target - nums[i], i, temp); // same index
        temp.remove(temp.size() - 1);
    }
}
```
**👉 🔥 Trick:**
- i pass karo → reuse allowed
- i+1 → reuse not allowed

# 🔥 4. N-Queens
**🧠 Idea:**
- Har row me 1 queen
- Check:
   - column
   - diagonal

**✅ Pattern:**
```
Row by row placement
```
```java
boolean isSafe(int row, int col, char[][] board) {
    for (int i = 0; i < row; i++)
        if (board[i][col] == 'Q') return false;

    for (int i = row-1, j = col-1; i>=0 && j>=0; i--, j--)
        if (board[i][j] == 'Q') return false;

    for (int i = row-1, j = col+1; i>=0 && j<board.length; i--, j++)
        if (board[i][j] == 'Q') return false;

    return true;
}
```
# 🔥 5. Sudoku Solver
**🧠 Idea:**
- Empty cell fill karo (1–9)
- Valid check:
  - row
  - column
  - box

**💻 Code (core):**
```java
boolean solve(char[][] board) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {

            if (board[i][j] == '.') {
                for (char c = '1'; c <= '9'; c++) {

                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;

                        if (solve(board)) return true;

                        board[i][j] = '.'; // undo
                    }
                }
                return false;
            }
        }
    }
    return true;
}
```

# 🔥 6. Rat in a Maze
**🧠 Idea:**

- 4 directions:
  👉 Up, Down, Left, Right

- Blocked cells avoid

**💻 Code:**
```java
void solve(int i, int j, int[][] maze) {
    if (i == n-1 && j == n-1) {
        printPath();
        return;
    }

    if (isSafe(i, j)) {
        visited[i][j] = true;

        solve(i+1, j, maze);
        solve(i, j+1, maze);
        solve(i-1, j, maze);
        solve(i, j-1, maze);

        visited[i][j] = false; // undo
    }
}
```
# 🔥 7. Word Search
**🧠 Idea:**

- Grid me word search karna
- Adjacent cells use

**💻 Code:**
```java
boolean dfs(char[][] board, int i, int j, String word, int index) {
    if (index == word.length()) return true;

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
        || board[i][j] != word.charAt(index)) return false;

    char temp = board[i][j];
    board[i][j] = '#';

    boolean found = dfs(board, i+1, j, word, index+1) ||
                    dfs(board, i-1, j, word, index+1) ||
                    dfs(board, i, j+1, word, index+1) ||
                    dfs(board, i, j-1, word, index+1);

    board[i][j] = temp; // undo
    return found;
}
```
