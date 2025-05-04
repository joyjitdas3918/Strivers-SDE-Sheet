
public class Main {
    public int maxSubArray(int[] nums) {
        int ans=-1000000001,sum=0;
        for(int x: nums){
            ans=Math.max(ans,x);
        }
        if(ans<0) return ans;
        for(int x:nums){
            sum+=x;
            if(sum<0) sum=0;
            ans=Math.max(ans,sum);
        }
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // Example input
        int result = obj.maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
    }    
}

