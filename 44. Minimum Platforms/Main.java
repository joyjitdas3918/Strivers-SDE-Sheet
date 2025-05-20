import java.util.Arrays;
public class Main {
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0,n=arr.length,ans=1,cnt=1;
        while(i<n && j<n){
            if (arr[i] <= dep[j]) { 
                cnt++; 
                i++; 
            } 
  
            else if (arr[i] > dep[j]) { 
                cnt--; 
                j++; 
            }
            
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {10, 12, 10, 11, 12};
        int dep[] = {11, 13, 12, 12, 13};
        System.out.println(findPlatform(arr, dep)); // Output: 3
    }
}
