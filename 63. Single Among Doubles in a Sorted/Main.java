import java.util.*;
public class Main {
    int findOnce(int[] arr) {
        // Complete this function
        int n=arr.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(mid+1<n && arr[mid+1]==arr[mid]){
                if((n-mid)%2==0){
                    r=mid-1;
                    continue;
                }
                else{
                    l=mid+1;
                    continue;
                }
            }
            if(mid-1>=0 && arr[mid-1]==arr[mid]){
                if((n-mid)%2==1){
                    r=mid-1;
                    continue;
                }
                else{
                    l=mid+1;
                    continue;
                }
            }
            return arr[mid];
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Main obj = new Main();
        System.out.println(obj.findOnce(arr));
    }
}
