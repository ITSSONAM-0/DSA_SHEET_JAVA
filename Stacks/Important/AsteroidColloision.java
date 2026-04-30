package DSA_SHEET_JAVA.Stacks.Important;

import java.util.Stack;

public class AsteroidColloision {

    public int[] collosion(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int ast = arr[i];
            boolean dest = false;

            while (!st.isEmpty() && ast < 0 && st.peek() > 0) {
                if (Math.abs(st.peek()) < Math.abs(ast)) {
                    st.pop();
                    continue;
                } else if (Math.abs(st.peek()) == Math.abs(ast)) {
                    st.pop();
                    dest = true;
                    break;
                } else {
                    dest = true;
                    break;
                }
            }

            if (!dest) {
                st.push(ast);
            }

        }

        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;

    }

    public static void main(String[] args) {

    }

}