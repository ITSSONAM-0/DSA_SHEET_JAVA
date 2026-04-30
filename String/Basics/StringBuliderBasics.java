package String.Basics;

public class StringBuliderBasics {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Tony");
       
        System.out.println(sb);
        //charAt at Index
        System.out.println(sb.charAt(0));

        //set char at Index 
        sb.setCharAt(0, 'P');
        System.out.println(sb);

        //insert char at index
        sb.insert(1,'S');
        System.out.println(sb);

        //delet char at index
        sb.delete(0, 1);
        System.out.println(sb);


        StringBuilder sb2 = new StringBuilder("h");
        sb2.append('e');
        sb2.append('l');
        sb2.append('l');
        sb2.append('l');
        sb2.append("l");
        sb2.append("o");
    }
}
