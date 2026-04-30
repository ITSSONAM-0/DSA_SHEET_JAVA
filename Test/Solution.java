import java.util.Arrays;

class Solution {
    public static boolean checkEqual(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        for(int i=0;i<a.length;i++){
           
                if(a[i]!=b[i]){
                    return false;
                }
            
        }
        return true;
    }
    public static void main(String[] args) {
        int a[] = new int[] {1, 2, 5, 4, 0};
        int b[] = new int [] {2, 4, 5, 0, 1};
        Boolean ans = checkEqual(a, b);
        System.out.println(ans);
    }
}