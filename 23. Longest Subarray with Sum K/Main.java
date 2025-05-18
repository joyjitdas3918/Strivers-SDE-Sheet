import java.util.*;
public class Main {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n=arr.length;
        int ans=0;
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=1;i<n;i++) arr[i]+=arr[i-1];
        for(int i=0;i<n;i++){
            int target=arr[i]-k;
            if(target==0) ans=Math.max(ans,i+1);
            if(map.containsKey(target)) ans=Math.max(ans,i-map.get(target));
            if(!map.containsKey(arr[i])) map.put(arr[i],i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(main.longestSubarray(arr, k));
    }
}
