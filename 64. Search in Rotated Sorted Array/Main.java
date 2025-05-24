import java.util.*;
public class Main {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(nums[mid]==target) return mid;
            if(nums[mid]<nums[0]) r=mid-1;
            else l=mid+1;
        }
        int pivot=r;
        l=0;
        r=pivot;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target) r=mid-1;
            else l=mid+1;
        }
        l=pivot+1;
        r=n-1;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target) r=mid-1;
            else l=mid+1;
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
        int target = sc.nextInt();
        Main obj = new Main();
        System.out.println(obj.search(arr, target));
    }
}
