package String.Easy;

public class StudentAttendance {
    public boolean checkRecord(String s) {
        int absent = 0;
        
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(c == 'A'){
                absent++;
            }
        }
        if(s.contains("LLL") || absent >= 2){
            return false;
        }

        return true;
    }
}
