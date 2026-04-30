package DSA_SHEET_JAVA.Stacks.Implementations;

import java.util.LinkedList;
import java.util.Queue;

public class StacksusingQueues {
    private Queue<Integer> q;

    // Constructor
    public StacksusingQueues() {
        q = new LinkedList<>();
    }

    // Push operation
    public void push(int x) {
        q.add(x);
        int size = q.size();

        // Rotate queue to make last added element the front
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
    }

    // Pop operation
    public int pop() {
        if (q.isEmpty()) {
            return -1; // Stack underflow
        }
        return q.poll();
    }

    // Peek operation
    public int top() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }

    // Size of the stack
    public int size() {
        return q.size();
    }

    // Main method for testing
    public static void main(String[] args) {
        StacksusingQueues stack = new StacksusingQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top()); // 30
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Top element: " + stack.top()); // 20
        System.out.println("Popped: " + stack.pop()); // 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // false
        System.out.println("Popped: " + stack.pop()); // 10
        System.out.println("Is stack empty? " + stack.isEmpty()); // true
    }
}
