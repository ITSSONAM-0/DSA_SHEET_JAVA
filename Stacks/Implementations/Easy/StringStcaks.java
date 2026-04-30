package DSA_SHEET_JAVA.Stacks.Implementations.Easy;

import java.util.Stack;

public class StringStcaks {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty())
                    return false;
                char ch = st.pop();
                if ((s.charAt(i) == ')' && ch == '(') || (s.charAt(i) == '}' && ch == '{')
                        || (s.charAt(i) == ']' && ch == '['))
                    continue;
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
