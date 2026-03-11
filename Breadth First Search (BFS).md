# 1️⃣ BFS kya hota hai (Very Simple Idea)

BFS ka matlab hota hai:

👉 Level by Level traversal

**Jaise:**
```
      A
     / \
    B   C
   / \   \
  D   E   F
```
**BFS order:**
```
A → B → C → D → E →
```
**Yani pehle same level ke nodes visit hote hain.**

**Isliye BFS me Queue use hoti hai.**
```
Queue = FIFO (First In First Out)
```

# 2️⃣ BFS ka Basic Logic

**Steps:**

- 1️⃣ Start node ko Queue me daalo
- 2️⃣ Usko Visited mark karo
- 3️⃣ Queue se node nikalo
- 4️⃣ Uske neighbors check karo
- 5️⃣ Jo visit nahi hua → queue me daalo

**Repeat until queue empty.**

# 3️⃣ BFS Basic Java Template

**Ye template 90% BFS questions me use hota hai.**
```java
import java.util.*;

class Solution {

    public void bfs(int start, List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            for(int neighbor : graph.get(node)) {

                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }

            }
        }
    }
}
```
**4️⃣ Dry Run Example**

**Graph:**
```
0 → 1,2
1 → 3
2 → 4
```
Start = 0

**Step 1**
```
Queue = [0]
Visited = [true,false,false,false,false]
```
**Step 2**

- Remove 0
- Neighbors → 1,2

```
Queue = [1,2]
Visited = [true,true,true,false,false]
```
**Step 3**
- Remove 1
- Neighbor → 3
```
Queue = [2,3]
Visited = [true,true,true,true,false]
```
**Step 4**
- Remove 2
- Neighbor → 4

```
Queue = [3,4]
Visited = [true,true,true,true,true]
```
**Final BFS order**
```
0 → 1 → 2 → 3 → 4
```
# 5️⃣ Grid BFS Template (Most Important 🔥)


DSA me zyada questions grid BFS par hote hain.

**Example:**
  - Number of Islands
  - Flood Fill
  - Rotting Oranges
  - Shortest Path in Binary Matrix

**Template**

```java
Queue<int[]> q = new LinkedList<>();

q.add(new int[]{row, col});

while(!q.isEmpty()){

    int[] cell = q.poll();
    int r = cell[0];
    int c = cell[1];

    int[][] dir = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    for(int[] d : dir){

        int nr = r + d[0];
        int nc = c + d[1];

        if(nr>=0 && nc>=0 && nr<n && nc<m){
            q.add(new int[]{nr,nc});
        }
    }
}
```
# 6️⃣ Question dekh ke kaise pata chale BFS use karna hai

Agar question me ye words ho:

- 🔹 Shortest Path (unweighted graph)
- 🔹 Minimum steps
- 🔹 Level wise traversal
- 🔹 Spread / Infection / Rotting
- 🔹 Nearest distance

**➡️ 99% BFS**
Example:
| Problem           | Pattern   |
| ----------------- | --------- |
| Rotting Oranges   | BFS       |
| Word Ladder       | BFS       |
| Shortest Path     | BFS       |
| Flood Fill        | BFS       |
| Number of Islands | BFS / DFS |


# 7️⃣ BFS ka Golden Template (Interview)

**Ye yaad kar lo.**
```java
Queue<Integer> q = new LinkedList<>();
boolean[] visited = new boolean[n];

q.add(start);
visited[start] = true;

while(!q.isEmpty()){

    int node = q.poll();

    for(int nei : graph[node]){

        if(!visited[nei]){
            visited[nei] = true;
            q.add(nei);
        }

    }
}
```
# 8️⃣ BFS ka Real Life Example

Corona Spread 🦠

**Day 0**
```
A infected
```
**Day1**
```
A → B,C
```
**Day2**
```
B,C → D,E
```
# 9️⃣ Most Important BFS Questions

**Practice order:**

- 1️⃣ Rotting Oranges
- 2️⃣ Number of Islands
- 3️⃣ Flood Fill
- 4️⃣ 01 Matrix
- 5️⃣ Word Ladder

Agar ye aa gaye → BFS master.

# 🔥 BFS Super Trick (Sabse Important)

BFS me 3 cheeze hamesha hoti hain:
```
Queue
Visited
Directions / Neighbors
```
**Template:**
```java
Queue<Node> q = new LinkedList<>();
visited[start] = true;
q.add(start);

while(!q.isEmpty()){

    Node curr = q.poll();

    for(Node neighbor : neighbors){

        if(!visited[neighbor]){
            visited[neighbor] = true;
            q.add(neighbor);
        }

    }
}
```
# 🚀 7 Important BFS Patterns
1️⃣ Simple Graph Traversal

**Use when:**
- Graph diya ho
- traversal karna ho

**Example**
```
0 → 1,2
1 → 3
2 → 4
```
**code**
```java
Queue<Integer> q = new LinkedList<>();
boolean[] visited = new boolean[n];

q.add(0);
visited[0] = true;

while(!q.isEmpty()){

    int node = q.poll();

    for(int nei : graph[node]){

        if(!visited[nei]){
            visited[nei] = true;
            q.add(nei);
        }

    }
}
```
# 2️⃣ Grid BFS (Most asked in interviews)

Use when:
- Matrix / grid ho
- 4 direction movement ho

**Directions:**
```
up
down
left
right
```
**Template**
```java
int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
Queue<int[]> q = new LinkedList<>();

q.add(new int[]{r,c});

while(!q.isEmpty()){

    int[] cell = q.poll();

    for(int[] d : dir){

        int nr = cell[0] + d[0];
        int nc = cell[1] + d[1];

        if(nr>=0 && nc>=0 && nr<n && nc<m){
            q.add(new int[]{nr,nc});
        }

    }
}
```
**Example problems**
- Number of Islands
- Flood Fill
- Rotting Oranges


# 3️⃣ Multi Source BFS

Use when multiple starting points ho.

**Example**

🔥 Rotting Oranges

**Saare rotten oranges start me queue me daal dete hain.**
```
Queue = all rotten oranges
```
Then BFS run
# 4️⃣ Shortest Path BFS

**Use when**
```
minimum steps
shortest distance
minimum moves
```
**Example**
- Word Ladder
- Binary Matrix Shortest Path


**Distance track karte hain.**
```java
q.add(new int[]{node, distance});
```
# 5️⃣ Level BFS (Tree BFS)

Used in trees.

**Example**
- Level Order Traversal

**Code trick:**
```java
int size = q.size();

for(int i=0;i<size;i++){
    int node = q.poll();
}
```
**Isse level by level traversal hota hai.**

# 6️⃣ BFS + State

**Use when extra condition ho.**

**Example**
- Word Ladder
- Knight moves

**Queue me store karte hain**
```
(node , steps)
```
# 7️⃣ BFS for Distance Matrix

**Example**

🔥 01 Matrix

Har cell ka nearest 0 distance find karna.

**Solution**
```
All zero cells → queue me daalo
```
Then BFS spread.
# 🧠 Interview Trick (Very Important)

**Agar question me ye words ho:**
| Word            | Pattern |
| --------------- | ------- |
| Minimum steps   | BFS     |
| Shortest path   | BFS     |
| Spread          | BFS     |
| Level traversal | BFS     |
| Distance        | BFS     |

# ⭐ Example Question (Rotting Oranges)

**Grid**
```
2 1 1
1 1 0
0 1 1
```
step1
```
Queue = all 2
```
**Step 2**

- BFS spread to 1's

**Step 3**

- Time++ each level.
- 
# 🧠 BFS Memory Trick

Remember this formula:
```
BFS = Queue + Visited + Neighbors
```



