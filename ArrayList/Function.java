import java.util.ArrayList;

public class Function {
    public static ArrayList<Integer> createList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = createList();
        System.out.println(myList); // Output: [10, 20, 30]
    }
}
