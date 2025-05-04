
public class Main {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int low=0,mid=0,high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
                nums[mid]=nums[low];
                nums[low]=0;
                low++;
                mid++;
            }
            else if(nums[mid]==2){
                nums[mid]=nums[high];
                nums[high]=2;
                high--;
            }
            else{
                mid++;
            }
        }
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] nums = {2, 0, 2, 1, 1, 0}; // Example input
        obj.sortColors(nums);
        System.out.print("Sorted colors: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }    
}
