
public class Main {
    public void nextPermutation(int[] nums) {
        int n=nums.length,f=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                f=i;
                break;
            }
        }
        if(f!=-1){
            for(int i=n-1;i>=f+1;i--){
                if(nums[i]>nums[f]){
                    int t=nums[i];
                    nums[i]=nums[f];
                    nums[f]=t;
                    break;
                }
            }
            int j=n-1;
            for(int i=f+1;i<n;i++){
                if(i>=j) break;
                int t=nums[i];
                    nums[i]=nums[j];
                    nums[j]=t;
                    j--;
            }
        }
        else{
            for(int i=0;i<n/2;i++){
                int temp=nums[i];
                nums[i]=nums[n-1-i];
                nums[n-1-i]=temp;
            }
        }
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] nums = {1, 2, 3}; // Example input
        obj.nextPermutation(nums);
        System.out.print("Next permutation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
