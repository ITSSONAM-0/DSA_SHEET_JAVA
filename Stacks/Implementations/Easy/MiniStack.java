package DSA_SHEET_JAVA.Stacks.Implementations.Easy;

import java.util.Stack;

public class MiniStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> st = new Stack<>();

    public void push(int val) {
        if (val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }

    public void pop() {
        if (st.pop() == min) {
            min = st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}