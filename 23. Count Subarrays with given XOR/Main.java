import java.util.*;
public class Main {
    public long subarrayXor(int arr[], int k) {
        // code here
        int n=arr.length;
        int ans=0;
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=1;i<n;i++) arr[i]^=arr[i-1];
        for(int i=0;i<n;i++){
            int target=arr[i]^k;
            if(target==0) ans++;
            if(map.containsKey(target)) ans+=map.get(target);
            if(!map.containsKey(arr[i])) map.put(arr[i],1);
            else map.put(arr[i],map.get(arr[i])+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(main.subarrayXor(arr, k)); // Example usage
    }
}
