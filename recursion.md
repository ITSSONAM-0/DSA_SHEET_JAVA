# 🔹 What is Recursion?

Recursion means a function calls itself to solve a smaller version of the same problem.

👉 Simple idea:

“Big problem → break into smaller same problem → keep going until base case”

# 🔹 2 Most Important Parts

Every recursive solution MUST have:

1. Base Case (Stopping Condition)
When to stop recursion
Without this → infinite loop 💥
2. Recursive Call
Function calling itself on smaller input
# 🔹 Basic Example (Very Important)
Factorial
n!=n×(n−1)!
```java
int factorial(int n) {
    if (n == 0) return 1;  // base case
    return n * factorial(n - 1);  // recursive call
}
```

# 🔹 How Recursion Works (Call Stack)

Example: factorial(3)

```
factorial(3)
= 3 * factorial(2)
= 3 * 2 * factorial(1)
= 3 * 2 * 1 * factorial(0)
= 3 * 2 * 1 * 1
= 6
```
👉 Stack builds → then resolves backward

# 🔹 Golden Rule ⭐

“Trust the function”
If you assume recursion works for smaller input, your job becomes easier.
# 🔹 Quick Interview Tip 💡

If you see:

Tree
Subsets
Choices at every step

👉 Think: Recursion / Backtracking


# 1. Print numbers (1 to N)

**👉 Builds: understanding function flow**
```java
void print(int n) {
    if (n == 0) return;
    print(n - 1);
    System.out.println(n);
}
```
# 2. Print N to 1

**👉 Builds: order of execution**
```java
void printRev(int n) {
    if (n == 0) return;
    System.out.println(n);
    printRev(n - 1);
}
```
# 3. Sum of first N numbers

**👉 Builds: returning values**
```java

int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);
}
```

# 4. Factorial

**👉 Most asked basic recursion question**

**n!=n×(n−1)!,0!=1**

```java
int fact(int n) {
    if (n == 0) return 1;
    return n * fact(n - 1);
}
```

# 5. Fibonacci Number
**
👉 Important for understanding multiple recursive calls**

**F(n)=F(n−1)+F(n−2),F(0)=0,F(1)=1**

```java
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```
# 6. Power (xⁿ)

**👉 Very common in interviews**
```java
int power(int x, int n) {
    if (n == 0) return 1;
    return x * power(x, n - 1);
}
```
# 7. Reverse an array

**👉 Builds: two-pointer + recursion**
```java
void reverse(int[] arr, int l, int r) {
    if (l >= r) return;
    
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
    
    reverse(arr, l + 1, r - 1);
}
```
# 8. Check Palindrome (String)

**👉 Very frequently asked**
```java
boolean isPalindrome(String s, int l, int r) {
    if (l >= r) return true;
    if (s.charAt(l) != s.charAt(r)) return false;
    
    return isPalindrome(s, l + 1, r - 1);
}
```
# 9. Count digits
**
👉 Simple but checks base case thinking**
```java
int count(int n) {
    if (n == 0) return 0;
    return 1 + count(n / 10);
}

```
# 10. Binary Search (Recursive)

**👉 VERY important for companies**
```java
int binarySearch(int[] arr, int l, int r, int target) {
    if (l > r) return -1;

    int mid = (l + r) / 2;

    if (arr[mid] == target) return mid;
    else if (target < arr[mid])
        return binarySearch(arr, l, mid - 1, target);
    else
        return binarySearch(arr, mid + 1, r, target);
}
```


<------------------------------------------------------------------------------->
# Theory
**🔥 1. What is Recursion? (Basic but important)**

Expected Answer (short + clear):
Recursion is a technique where a function calls itself to solve a smaller instance of the same problem until a base condition is reached.

**👉 Deep follow-up they ask:**

- Why do we need base case?
- What happens if no base case?

**Answer:**
Without base case → infinite calls → stack overflow error.

**🔥 2. What is Base Case & Recursive Case?**

**Answer:**

- Base Case: condition where recursion stops
- Recursive Case: function calls itself with smaller input

👉 Interviewer checks:
Do you really understand stopping condition

# 🔥 3. How Recursion Works Internally? (VERY IMPORTANT)

👉 This is where most students fail.

**Expected Answer:**

- Recursion uses call stack
- Each function call is stored in stack memory
- When base case is reached, stack starts resolving (LIFO)

👉 Use this keyword:
👉 Call Stack (LIFO)

# 🔥 4. What is Stack Overflow?

Answer:
When too many recursive calls fill the stack memory, program crashes → called stack overflow.

👉 Follow-up:

- Why happens? → no base case / too deep recursion
# 🔥 5. Time & Space Complexity in Recursion

👉 Interviewers LOVE this

**Example: Fibonacci**

- Time Complexity: O(2ⁿ)
- Space Complexity: O(n) (call stack)

**👉 Key concept:**

- Count number of calls
- Depth = space
# 🔥 6. Recursion vs Iteration

**Answer:**

| Recursion       | Iteration      |
| --------------- | -------------- |
| Uses call stack | Uses loops     |
| Easy to write   | More efficient |
| More memory     | Less memory    |


**👉 Important line:**

Recursion is more readable but less memory efficient

# 🔥 7. Tail Recursion (Advanced Theory)

**👉 Asked in good interviews**

**Answer:**
When recursive call is the last operation in function.
```java
return func(n-1); // tail recursion
```

**👉 Benefit:**

- Can be optimized by compiler
- Less stack usage
**🔥 8. What is Backtracking?**

👉 MUST for advanced

**Answer:**
Backtracking is recursion where we try all possibilities and undo choices if they fail.

**👉 Keywords:**

- "Try → Explore → Undo"
**🔥 9. How to Identify Recursion Problem?**

👉 Very practical question

**Answer:**
If problem can be broken into:

- smaller same subproblems
- repeated structure
- tree-like decisions
**🔥 10. Why Recursion is Important in DSA?**

**Answer:**
Because it is used in:

- Trees (DFS)
- Graphs
- Backtracking
- Divide & Conquer
**🔥 11. Dry Run Question (Very Common)**

**👉 Interviewer gives:**
```
fun(3)
```
**And asks:**
👉 “Explain step by step execution”

**⚠️ You must explain:**

- Calls
- Stack build
- Stack unwind
**🎯 How to Impress Interviewer**

Use these keywords:

- Call stack
- Base condition
- Stack overflow
- Divide into smaller problem
- Backtracking (try & undo)



< -------------------------------------------------------------------------------------------->


**🎯 Q1: What is Recursion?**

👉 You can say something like this:

**Answer:**
Recursion is a programming technique where a function calls itself to solve a smaller version of the same problem. It continues until it reaches a base case, which stops the recursion.

**🔍 Explain with Example** 
Example: Factorial

**n!=n×(n−1)!,0!=1**
```java
int fact(int n) {
    if (n == 0) return 1;   // base case
    return n * fact(n - 1); // recursive call
}
```

**🧠 How to Explain (Step-by-Step)**

👉 Say this in interview:

- The function fact(n) calls itself with smaller input n-1
- This keeps happening until n == 0 (base case)
- After reaching base case, function starts returning values back
**🔄 Dry Run **

Example: fact(3)
```
fact(3)
= 3 * fact(2)
= 3 * 2 * fact(1)
= 3 * 2 * 1 * fact(0)
= 3 * 2 * 1 * 1
= 6
```
👉 Add this line (important):

Each call is stored in the call stack and resolved in reverse order.

**⭐ Final Line **

👉 End like this:

So recursion works by breaking a problem into smaller subproblems and solving them using the same function until a base condition is reached.


# 🎯 Q2: What happens if we don’t write a base case in recursion?
✅ Short Answer (you can say first)

If we don’t write a base case, the recursive function will keep calling itself infinitely, which leads to a stack overflow error and the program crashes.

**🔍 Now Explain in Detail (this is what impresses interviewer)**
**1. Continuous Function Calls (Infinite Recursion)**
- Recursion works by calling the same function again and again
- Without a base case → there is no stopping condition
- So function keeps calling itself forever

**👉 Important line:**

The recursion never terminates.

**2. Call Stack Keeps Growing**
- Every function call is stored in memory (call stack)
- Each call takes some space

**👉 Example flow:**
```
func(5)
→ func(4)
→ func(3)
→ func(2)
→ func(1)
→ func(0)
→ func(-1)
→ func(-2)
→ ...
```

👉 It never stops ❌

**3. Stack Memory Gets Full → Stack Overflow**
- Stack has limited size
- When too many calls are stored → memory gets exhausted

**👉 Result:**

Program crashes with StackOverflowError

💻 Example Code (Wrong)
```java
int fun(int n) {
    return n + fun(n - 1); // ❌ no base case
}
```

**👉 Problem:
**
- No stopping condition
- Infinite calls
**💻 Correct Version (With Base Case)**
```jaav
int fun(int n) {
    if (n == 0) return 0; // ✅ base case
    return n + fun(n - 1);

}
```
**🧠 Real Understanding (Say This Line 🔥)**

Base case acts like a stopping condition in recursion. Without it, recursion becomes an infinite loop and eventually crashes due to stack overflow.

# ⚡ Follow-up They May Ask
**❓ What is Stack Overflow?**

**👉 Answer:**
Stack overflow is a condition where the call stack exceeds its memory limit due to too many function calls.

**🎯 Final Interview Answer (Perfect Version)**

**👉 You can say:**

If we don’t define a base case in recursion, the function will keep calling itself indefinitely. This leads to infinite recursion, where each call is stored in the call stack. Since stack memory is limited, it eventually overflows, causing a stack overflow error and program crash.


# 🎯 Q3: How does recursion work internally? (Call Stack)
✅ Short Answer (start like this)

Recursion works using a call stack, where each function call is stored in memory. When the base case is reached, the stack starts resolving in reverse order (LIFO – Last In First Out).

****🔍 Now Deep Explanation (step-by-step)****
**1. What is Call Stack?**
- Call stack is a memory structure
- It stores:
      - function calls
      - local variables
      - execution state

**👉 Important line:**

Every recursive call gets its own space in the call stack.

**2. How Recursion Builds Stack (Going Down)**

**Let’s take example: fact(3)**
```java
int fact(int n) {
    if (n == 0) return 1;
    return n * fact(n - 1);
}
```
**Step-by-step:**
```
fact(3) → waits for fact(2)
fact(2) → waits for fact(1)
fact(1) → waits for fact(0)
fact(0) → returns 1 (base case)
```
**👉 At this stage:**

- Stack is FULL
- All calls are waiting
****3. Stack Starts Resolving (Coming Back)****

Now values return back:
```
fact(1) = 1 * 1 = 1
fact(2) = 2 * 1 = 2
fact(3) = 3 * 2 = 6
```
👉 Important concept:

Last function call resolves first

**🔁 LIFO Concept (VERY IMPORTANT)******

👉 Call stack follows:

- Last In First Out (LIFO)

Meaning:

- Last function added → first to complete
**📦 Visual Representation**
```
Stack build:
[ fact(3) ]
[ fact(2) ]
[ fact(1) ]
[ fact(0) ]

Stack unwind:
fact(0) → 1
fact(1) → 1
fact(2) → 2
fact(3) → 6
```
****💡 Key Points to Say in Interview****

**👉 Use these lines:**

- “Each recursive call is pushed into the call stack”
- “It waits until base case is reached”
- “Then stack unwinds in reverse order”
- “It follows LIFO”
**⚠️ Important Insight**

👉 Why recursion uses more memory?
**Because:**

- Each call takes stack space
- More calls = more memory
****🎯 Final Perfect Interview Answer****

**You can say:**

Recursion works internally using a call stack. Every time a function calls itself, a new stack frame is created and pushed into the stack. These calls continue until the base case is reached. After that, the stack starts resolving in reverse order, following the LIFO principle. Each function returns its result back to the previous call until the final result is obtained.


# 🎯 Q4: What is Time & Space Complexity in Recursion?
**✅ First say this (simple definition)**
- Time Complexity: how many total function calls are made
- Space Complexity: how much memory is used (mainly due to call stack)
  
****🔍 Example: Fibonacci (Most Asked)****

**F(n)=F(n−1)+F(n−2),F(0)=0,F(1)=1**
```java
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```
****🧠 1. Time Complexity (Deep Understanding)****
**👉 How to think:**

Count how many times function is called

**Call pattern:**
```
fib(5)
→ fib(4) + fib(3)
→ fib(3) + fib(2) + fib(2) + fib(1)
→ ...
```
👉 You can see:

- Calls are repeating
- Tree structure is forming 🌳
**📌 Final Answer:**

Time Complexity = O(2ⁿ)

**👉 Why?**

Each call splits into 2 calls
Exponential growth
**🧠 2. Space Complexity**

👉 Space depends on maximum depth of recursion stack

**Depth:**
```
fib(5) → fib(4) → fib(3) → fib(2) → fib(1)
```

👉 Maximum depth = n

**📌 Final Answer:**

Space Complexity = O(n)

**⚠️ Important Concept (Very Interview-Focused)**

- 👉 Even though many calls are made,
- 👉 stack depth is only n, not 2ⁿ

**🔥 Key Difference (Important)**
| Concept          | Meaning             |
| ---------------- | ------------------- |
| Time Complexity  | Total calls         |
| Space Complexity | Maximum stack depth |


**💡 Another Example (Factorial for Comparison)**
```java
int fact(int n) {
    if (n == 0) return 1;
    return n * fact(n - 1);
}
```
**👉 Time Complexity:**
Calls = n → O(n)
**👉 Space Complexity:**
Stack depth = n → O(n)
**🎯 Final Interview Answer (Perfect)**

You can say:

In recursion, time complexity is calculated by counting how many function calls are made, while space complexity depends on the maximum depth of the call stack.
For example, in Fibonacci recursion, each function makes two calls, leading to exponential time complexity O(2ⁿ). However, the maximum depth of the recursion tree is n, so space complexity is O(n).

**🚀 Pro Tip (Impress Interviewer)**
**
Say this line:**

Recursive problems often form a tree structure, and time complexity depends on the number of nodes in that tree.




# 🎯 Q5: Difference between Recursion and Iteration
**✅ Start with Simple Line (best opening)**

Recursion is when a function calls itself, while iteration uses loops like for and while to repeat a task.

**🔍 Deep Comparison (Interview Level)**
**🧠 1. Working Mechanism**
**🔹 Recursion**
- Function calls itself
- Uses call stack
- Breaks problem into smaller parts
**🔹 Iteration**
- Uses loops (for, while)
- No function calls
- Repeats steps until condition fails
****🧠 2. Memory Usage****
**🔹 Recursion**
- Uses extra memory (call stack)
- Each call stores data
**🔹 Iteration**
- Uses less memory
- No extra stack

**👉 Important line:**

Recursion is less memory efficient compared to iteration.
**
**🧠 3. Performance (Speed)****
**🔹 Recursion**
- Slower (due to function calls overhead)
**🔹 Iteration**
- Faster (no function call overhead)
****🧠 4. Code Simplicity****
**🔹 Recursion**
- Cleaner and shorter code
- Easier for problems like:
    - trees
    - backtracking
**🔹 Iteration**
- Sometimes complex to write
- But more efficient
**💻 Example (Factorial)**
**🔹 Recursion**
```java
int fact(int n) {
    if (n == 0) return 1;
    return n * fact(n - 1);
}
```
**🔹 Iteration**
```java
int fact(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}
```
**📊 Final Comparison Table**
| Feature  | Recursion             | Iteration        |
| -------- | --------------------- | ---------------- |
| Approach | Function calls itself | Uses loops       |
| Memory   | High (stack used)     | Low              |
| Speed    | Slower                | Faster           |
| Code     | Short & clean         | Longer sometimes |

**🎯 Final Interview Answer (Perfect)**

**You can say:**

Recursion is a technique where a function calls itself to solve smaller subproblems, while iteration uses loops to repeat execution. Recursion uses extra memory due to the call stack, making it less efficient compared to iteration. However, recursion makes code simpler and is very useful for problems like trees, graphs, and backtracking.

**💡 Pro Tip (Impress Interviewer)**

Add this line:

In many cases, recursion can be converted into iteration using a stack.


# 🎯 Q6: What is Tail Recursion and why is it important?
**✅ Simple Definition (start like this)**

Tail recursion is a type of recursion where the recursive call is the last operation in the function.

****🔍 Understand Properly****

**👉 In tail recursion:**

- No work is left after the recursive call
- Function directly returns the result of the recursive call
**💻 Example of Tail Recursion**
```java
int fact(int n, int result) {
    if (n == 0) return result;
    return fact(n - 1, n * result); // last operation
}
```

👉 Call like:
```
fact(5, 1);
```
**❌ Non-Tail Recursion (Important Comparison)**
```java
int fact(int n) {
    if (n == 0) return 1;
    return n * fact(n - 1); // work still left after call ❌
}

```

**👉 Here:**

- Multiplication happens after recursive call
- So it's NOT tail recursion
**🧠 Key Difference**
| Tail Recursion              | Non-Tail Recursion         |
| --------------------------- | -------------------------- |
| Last step is recursive call | Work remains after call    |
| Can be optimized            | Cannot be optimized easily |

****🔥 Why Tail Recursion is Important?****
**1. Memory Optimization**

👉 Tail recursion can be optimized into iteration by compiler

**👉 Means:**

- No extra stack frames
- Less memory usage
**2. Prevent Stack Overflow**

- 👉 Since stack doesn’t grow much
- 👉 Safer for deep recursion

**3. Faster Execution**

👉 Similar to loops performance

**⚠️ Important Reality (Interview Insight)**

👉 In Java:

- Tail recursion optimization is NOT guaranteed ❗
- But concept is still very important
**🎯 Final Interview Answer (Perfect)**

You can say:

Tail recursion is a type of recursion where the recursive call is the last operation in the function, meaning no work is left after the call. This allows the compiler to optimize the recursion into iteration, reducing memory usage and preventing stack overflow. However, in Java, tail recursion optimization is not guaranteed, but the concept is still important for writing efficient recursive solutions.

**💡 Pro Tip (Impress Interviewer)
**
Add this line:

Tail recursion is useful for converting recursive solutions into iterative ones.

# 🎯 Q7: What is Backtracking in Recursion?
**✅ Simple Definition (start like this)**

Backtracking is a recursive technique where we try all possible solutions, and if a choice doesn’t work, we undo it and try another option.

****🔍 Core Idea (very important)****

**👉 Think like this:**

- Choose an option
- Explore further
- If it fails → Undo (backtrack)

**👉 One-line memory trick:**

Choose → Explore → Undo

**🧠 Why do we need Backtracking?**

Because some problems:

- Have multiple possibilities
- Need all solutions or valid solutions

**👉 Examples:**

- Subsets
- Permutations
- N-Queens
- Sudoku
**💻 Simple Example: Generate Subsets**

- Input: [1, 2]
- Output: [], [1], [2], [1,2]

**Code (Important Pattern)**
```java
void subsets(int[] arr, int index, List<Integer> current) {
    if (index == arr.length) {
        System.out.println(current);
        return;
    }

    // include element
    current.add(arr[index]);
    subsets(arr, index + 1, current);

    // backtrack (undo)
    current.remove(current.size() - 1);

    // exclude element
    subsets(arr, index + 1, current);
}
```
**🔄 How Backtracking Works (Step Flow)**

For [1,2]:
```
Start → []
Include 1 → [1]
Include 2 → [1,2]
Backtrack → [1]
Exclude 2 → [1]
Backtrack → []
Include 2 → [2]
...
```
👉 Notice:

- We add element
- Then remove it (backtrack)
****🔥 Key Concept (Most Important)****

**👉 This line impresses interviewer:**

Backtracking modifies the current state, explores deeper, and then restores the state to try other possibilities.

**⚠️ Common Mistake**

❌ Forgetting to undo (remove element)
👉 Then wrong results come

****🎯 Final Interview Answer (Perfect)****

You can say:

Backtracking is a recursive approach used to explore all possible solutions by making choices and exploring them. If a choice does not lead to a valid solution, we undo that choice and try another path. It follows the pattern of choose, explore, and undo. It is commonly used in problems like subsets, permutations, and N-Queens.

**🚀 Pro Tip (Very Important)**

👉 If problem says:

- “Print all combinations”
- “Find all ways”
- “Generate all…”

**👉 Immediately think:**

Backtracking
