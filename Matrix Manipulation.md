# 1️⃣ Matrix kya hota hai?

Matrix basically 2D array hota hai.

**Example:**
```
1 2 3
4 5 6
7 8 9
```
Java me:
```java
int[][] matrix = {
    {1,2,3},
    {4,5,6},
    {7,8,9}
};
```
**Yaha**
- rows = 3
- columns = 3

**Access:**
```
matrix[row][col]

```
**Example:**
```
matrix[1][2] = 6
```
# 2️⃣ Matrix traversal (sabse basic pattern)

**Sabse pehla kaam hota hai matrix ko traverse karna.**
```java
for(int i=0;i<matrix.length;i++){
    for(int j=0;j<matrix[0].length;j++){
        System.out.print(matrix[i][j]);
    }
}
```
**Visual:**
```
1 → 2 → 3
↓
4 → 5 → 6
↓
7 → 8 → 9
```
**Time Complexity:**
```
O(rows × cols)
```
# 3️⃣ Direction Arrays (VERY IMPORTANT)

Matrix problems me 4 direction move karna common hota hai.



**Up, Down, Left, Right**
```
↑
← → 
↓
```
**Code trick:**
```
int[] dr = {-1,1,0,0};
int[] dc = {0,0,-1,1};
```
**Meaning:**
```
(-1,0) up
(1,0) down
(0,-1) left
(0,1) right
```
**Use:**
```java
for(int k=0;k<4;k++){
    int newRow = row + dr[k];
    int newCol = col + dc[k];
}
```
**Ye trick BFS / DFS / grid problems me bahut use hoti hai.**
# 4️⃣ Boundary check (important)

Matrix me move karte time out of bound na ho.
```java
if(newRow>=0 && newRow<n && newCol>=0 && newCol<m){
    // valid cell
}
```
Example:
```
3x3 matrix

0 ≤ row < 3
0 ≤ col < 3
```
# 5️⃣ Common Matrix Patterns
**1️⃣ Row traversal**
```
1 2 3
4 5 6
7 8 9
```
output
```

1 2 3 4 5 6 7 8 9
```
**2️⃣ Column traversal**
```
1 4 7
2 5 8
3 6 9
```
code
```java
for(int j=0;j<m;j++){
    for(int i=0;i<n;i++){
        System.out.print(matrix[i][j]);
    }
}
```
**3️⃣ Diagonal traversal**

Main diagonal:
```
1 2 3
4 5 6
7 8 9
```
output
```
1 5 9
```
code 
```java
for(int i=0;i<n;i++){
    System.out.print(matrix[i][i]);
}
```
**4️⃣ Reverse matrix**
```
1 2 3
4 5 6
7 8 9
```

than 
```
9 8 7
6 5 4
3 2 1

```
**5️⃣ Spiral traversal (very famous)**

Example:
```
1  2  3
4  5  6
7  8  9
```
output
```
1 2 3 6 9 8 7 4 5
```
Used in many interviews.
**6️⃣ Matrix Manipulation kyu use hota hai?**

Use hota hai jab problem me:
| Situation        | Example         |
| ---------------- | --------------- |
| Grid problem     | islands problem |
| Image processing | rotate image    |
| Path finding     | shortest path   |
| Game boards      | chess / sudoku  |
| BFS / DFS grid   | flood fill      |

**popular problems:**
- Number of Islands
- Rotate Image
- Spiral Matrix
- Flood Fill
- Word Search

**7️⃣ Important tricks (interview)**
**Trick 1 — transpose**
```
matrix[i][j] → matrix[j][i]
```
Used in Rotate Image problem.
**Trick 2 — in-place modification**

Space optimize karne ke liye same matrix modify karte hai.
**
Trick 3 — visited array**

Grid DFS/BFS me use hota hai.
```
boolean[][] visited
```
**8️⃣ Easy example question**

Matrix:
```
1 2 3
4 5 6
7 8 9
```
Find sum.

**Code:**
```java
int sum=0;

for(int i=0;i<matrix.length;i++){
    for(int j=0;j<matrix[0].length;j++){
        sum += matrix[i][j];
    }
}
```
**output:**
```
45
```
**9️⃣ Matrix problems ka mindset**

**Jab bhi matrix question aaye:**
- Step 1️⃣ rows and columns identify
- Step 2️⃣ traversal pattern choose
- Step 3️⃣ direction array if needed
- Step 4️⃣ boundary check
- Step 5️⃣ visited or modify matrix




# 1️⃣ Rotate Image
**Problem**

Matrix ko 90° clockwise rotate karna hai in-place.

**Example**
```
1 2 3
4 5 6
7 8 9
```
output
```
7 4 1
8 5 2
9 6 3
```
**Idea (Important Trick)**

- Rotation = Transpose + Reverse rows

**Step 1 — Transpose**

**Swap**
```

matrix[i][j] ↔ matrix[j][i]
```
example
```
1 4 7
2 5 8
3 6 9
```
**Step 2 — Reverse each row**
```
7 4 1
8 5 2
9 6 3
```
```java
public void rotate(int[][] matrix) {

    int n = matrix.length;

    // transpose
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    // reverse rows
    for(int i=0;i<n;i++){
        int left = 0;
        int right = n-1;

        while(left < right){
            int temp = matrix[i][left];
            matrix[i][left] = matrix[i][right];
            matrix[i][right] = temp;

            left++;
            right--;
        }
    }
}
```
**Complexity**
```
Time  : O(n²)
Space : O(1)
```


# 2️⃣ Spiral Matrix (LeetCode 54)
**Problem**

Matrix ko spiral order me traverse karo.

**Example**
```
1 2 3
4 5 6
7 8 9
```
ouput
```
1 2 3 6 9 8 7 4 5
```
**Idea**

4 boundaries maintain karo
```
top
bottom
left
right
```
Traversal order
```
left → right
top → bottom
right → left
bottom → top
```
```java
public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> res = new ArrayList<>();

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while(top <= bottom && left <= right){

        for(int i=left;i<=right;i++)
            res.add(matrix[top][i]);
        top++;

        for(int i=top;i<=bottom;i++)
            res.add(matrix[i][right]);
        right--;

        if(top <= bottom){
            for(int i=right;i>=left;i--)
                res.add(matrix[bottom][i]);
            bottom--;
        }

        if(left <= right){
            for(int i=bottom;i>=top;i--)
                res.add(matrix[i][left]);
            left++;
        }
    }

    return res;
}
```
**Complexity**
```
Time  : O(n*m)
Space : O(1)
```
# 3️⃣ Number of Islands
**Problem**

Grid me islands count karo.
```
1 = land
0 = water
```
Example
```
1 1 0 0
1 1 0 0
0 0 1 0
0 0 0 1
```
**Answer**
```
3 islands
```
**Idea**


**Use DFS / BFS**

Jab bhi 1 mile
```
count++
DFS karo
aur sab connected 1 ko 0 bana do
```
**Java Code (DFS)**
```java
public int numIslands(char[][] grid) {

    int count = 0;

    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){

            if(grid[i][j] == '1'){
                dfs(grid,i,j);
                count++;
            }
        }
    }

    return count;
}

void dfs(char[][] grid,int r,int c){

    if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0')
        return;

    grid[r][c]='0';

    dfs(grid,r+1,c);
    dfs(grid,r-1,c);
    dfs(grid,r,c+1);
    dfs(grid,r,c-1);
}
```
**Complexity**
```
Time : O(n*m)
Space : O(n*m)
```
 # 4️⃣ Flood Fill
** Problem
**
- Image editing jaisa concept.
- Start pixel se same color region fill karo.

**Example**
```
1 1 1
1 1 0
1 0 1
```
Start
```
(1, 1)
```
new color
```
2
```
output
```
2 2 2
2 2 0
2 0 1
```
**Idea**

**DFS / BFS**
- 1️⃣ original color store karo
- 2️⃣ same color wale neighbors change karo

java code 
```java
public int[][] floodFill(int[][] image, int sr, int sc, int color) {

    int oldColor = image[sr][sc];

    if(oldColor == color)
        return image;

    dfs(image,sr,sc,oldColor,color);

    return image;
}

void dfs(int[][] image,int r,int c,int old,int newColor){

    if(r<0 || c<0 || r>=image.length || c>=image[0].length)
        return;

    if(image[r][c] != old)
        return;

    image[r][c] = newColor;

    dfs(image,r+1,c,old,newColor);
    dfs(image,r-1,c,old,newColor);
    dfs(image,r,c+1,old,newColor);
    dfs(image,r,c-1,old,newColor);
}
```

# 5️⃣ Set Matrix Zeroes
**Problem**

Agar kisi cell me 0 ho to
```
poori row
poori column
0 ho jaye
```
example
```
1 1 1
1 0 1
1 1 1
```
output
```
1 0 1
0 0 0
1 0 1
```
**Idea**

**Step 1**

Store rows and columns.
```
row[]
col[]
```
**Step 2**

- Mark karo.

**Step 3**

- Matrix update karo.tep 1

java code 
```java
public void setZeroes(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    boolean[] row = new boolean[m];
    boolean[] col = new boolean[n];

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){

            if(matrix[i][j] == 0){
                row[i] = true;
                col[j] = true;
            }
        }
    }

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){

            if(row[i] || col[j])
                matrix[i][j] = 0;
        }
    }
}
```
# 6️⃣ Word Search
**Problem**

- Grid me word exist karta hai ya nahi.

**Example**
```
A B C E
S F C S
A D E E
```


**word**
```
ABCCED
```
Answer
```
true
```
**Idea**

Use Backtracking + DFS

**Steps**

- 1️⃣ character match karo
- 2️⃣ visited mark karo
- 3️⃣ neighbors explore karo
- 4️⃣ backtrack

**Java Code**
```java
public boolean exist(char[][] board, String word) {

    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){

            if(dfs(board,word,i,j,0))
                return true;
        }
    }

    return false;
}

boolean dfs(char[][] board,String word,int r,int c,int index){

    if(index == word.length())
        return true;

    if(r<0 || c<0 || r>=board.length || c>=board[0].length)
        return false;

    if(board[r][c] != word.charAt(index))
        return false;

    char temp = board[r][c];
    board[r][c] = '#';

    boolean found =
            dfs(board,word,r+1,c,index+1) ||
            dfs(board,word,r-1,c,index+1) ||
            dfs(board,word,r,c+1,index+1) ||
            dfs(board,word,r,c-1,index+1);

    board[r][c] = temp;

    return found;
}
```
# 🔥 Matrix Problem Pattern Summary
| Problem           | Pattern             |
| ----------------- | ------------------- |
| Rotate Image      | transpose + reverse |
| Spiral Matrix     | boundary traversal  |
| Number of Islands | DFS grid            |
| Flood Fill        | DFS color fill      |
| Set Matrix Zeroes | row column marking  |
| Word Search       | backtracking        |








