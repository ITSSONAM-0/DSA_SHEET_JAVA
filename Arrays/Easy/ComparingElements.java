public class ComparingElements {
    static boolean compare(int arr[]){
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,10,60,70,80,90,100};
        boolean ans = compare(arr);
        if(ans){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
