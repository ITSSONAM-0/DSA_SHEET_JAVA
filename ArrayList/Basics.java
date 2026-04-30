import java.util.*;

public class Basics {
    public static void main(String[] args) {

        //ArrayList declartion
       ArrayList<Integer> list = new ArrayList<>();
       ArrayList<String> list2 = new ArrayList<>();
       ArrayList<Float> list3 = new ArrayList<>();
       ArrayList<Boolean> list4 = new ArrayList<>();

       //adding elements in arraylist
       list.add(10); //index = 0
       list.add(20); //index = 1
       list.add(30); //index = 2
       list.add(40); //index = 3
       list.add(50); //index = 4
       list.add(60); //index = 5
       System.out.println(list);

       //accessing the elements in ArrayList

       System.out.println(list.get(0));
       System.out.println(list.get(1));
       System.out.println(list.get(2));
       System.out.println(list.get(3));
       System.out.println(list.get(4));
       System.out.println(list.get(5));

       //Modifying the elements in the ArrayList
       list.set(0,100);
       list.set(5,600);
       System.out.println(list);

       // deleting an element from the ArratList
        list.remove(0);
        System.out.println(list);

        //size of the Arraylist
        int size = list.size();
        System.out.println(size);

        //loops
        for(int i = 0 ; i < list.size();i++){
            System.out.println(list.get(i)+ " ");
        }

        //sorting
        Collections.sort(list);
        System.out.println(list);

        //contains function
        System.out.println(list.contains(30)); // Output: true or false

        // Converting ArrayList to Array
        Integer[] arr = list.toArray(new Integer[0]);

        //Converting Array to ArrayList
        String[] arrr = { "A", "B", "C" };
        List<String> listt = new ArrayList<>(Arrays.asList(arrr));

    }
}
