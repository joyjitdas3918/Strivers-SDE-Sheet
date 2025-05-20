import java.util.*;
public class Main {
    public void fun(int[] arr, int i, int n, ArrayList<Integer> ans, int sum){
        if(i==n){
            ans.add(sum);
            return;
        }
        fun(arr,i+1,n,ans,sum);
        fun(arr,i+1,n,ans,sum+arr[i]);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        fun(arr,0,n,ans,0);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Main obj = new Main();
        ArrayList<Integer> result = obj.subsetSums(arr);
        Collections.sort(result);
        for (int sum : result) {
            System.out.print(sum + " ");
        }
    }
}
