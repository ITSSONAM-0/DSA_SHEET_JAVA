package String.Basics;

import java.util.Scanner;

public class ArrayOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        String srr [] = new String[size];
        int length = 0;

        for(int i= 0; i < size;i++){
            srr[i] = sc.next();
            length += srr[i].length();
        }
        System.out.println(length);
    }
}
