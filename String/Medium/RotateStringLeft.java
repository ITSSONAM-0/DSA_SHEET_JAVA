public class RotateStringLeft {


    static boolean check(String s1,String s2){

        if(s1.length() != s2.length()){
            return false;
        }

        for(int i=0;i<s1.length();i++){
            String rotate = s1.substring(i) + s1.substring(0, i);

            if(rotate.equals(s2)){
                return true;
            }
        }




        return false;
    }




    public static void main(String[] args) {
        
    }
}
