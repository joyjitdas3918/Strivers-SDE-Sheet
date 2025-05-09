public class Main {
    public int majorityElement(int[] nums) {
        int ans=nums[0],cnt=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==ans) cnt++;
            else cnt--;
            if(cnt<0){
                ans=nums[i];
                cnt=1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2,2,1,1,1,2,2};
        int majorityElement = main.majorityElement(nums);
        System.out.println(majorityElement); // Output: 2
    }
}
