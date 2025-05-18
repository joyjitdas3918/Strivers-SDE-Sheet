public class Main {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0,cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) cnt=0;
            else cnt++;
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        int[] nums = {1, 1, 0, 1, 1, 1};
        Main main = new Main();
        int result = main.findMaxConsecutiveOnes(nums);
        
        // Print the result
        System.out.println("Maximum consecutive ones: " + result);
    }
}
