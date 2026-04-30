package String.Basics;

import java.util.*;

public class Basic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // System.out.println("Your Name :"+ name);


        //concatenation
        String firstname = "tony";
        String lastname = "stark";
        String fullname = firstname +" " + lastname;
        System.out.println(fullname);

        //length of the string

        String word = "hello" ;
        int ans = word.length();
        System.out.println(ans);

        //Accessing each charcter in the string

        String paragraph = "hello how are you";
        for(int i=0;i<paragraph.length();i++){
            System.out.println(paragraph.charAt(i));
        }

        //compare to operator 
        //name1 > name2 = +ve value
        //name1 == name2 = 0
        //name1 < name2 = -ve value

        String name1 = "Super";
        String name2 = "Bowl";
        int ans1 = name1.compareTo(name2);
        System.out.println(ans1);

        //Substring

        String sentence = "Hello How are you";
        String ans3 = sentence.substring(5);
        System.out.println(ans3);
        String ans4 = sentence.substring(5, 17);
        System.out.println(ans4);


        //ParseInt

        String number = "123";
        int num = Integer.parseInt(number);
        System.out.println(num);

        //Integer to String

        int score = 600;
        String answer = Integer.toString(score);
        System.out.println(answer);

    }
}
