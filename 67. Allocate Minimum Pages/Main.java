import java.util.*;
public class Main {
    public static int findPages(int[] arr, int k) {
        // code here
        int l=0,r=1000000001,ans=1000000001,n=arr.length;
        for(int i=0;i<n;i++) l=Math.max(l,arr[i]);
        if(n<k) return -1;
        while(l<=r){
            int mid=(r-l)/2+l;
            int sum=0,part=1;
            for(int i=0;i<n;i++){
                sum+=arr[i];
                if(sum>mid){
                    sum=arr[i];
                    part++;
                }
            }
            if(part<=k){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findPages(arr, k));
    }
}
