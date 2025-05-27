import java.util.*;
public class Main {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int r=0,l=100000001,n=stalls.length,ans=0;
        for(int i=1;i<n;i++){
            l=Math.min(l,stalls[i]-stalls[i-1]);
        }
        r=stalls[n-1]-stalls[0];
        while(l<=r){
            int mid=(r-l)/2+l;
            int cows=1;
            int ll=stalls[0];
            for(int i=1;i<n;i++){
                if(stalls[i]-ll>=mid){
                    cows++;
                    ll=stalls[i];
                }
            }
            if(cows>=k){
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stalls = new int[n];
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(aggressiveCows(stalls, k));
    }
}
