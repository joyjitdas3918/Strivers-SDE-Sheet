public class Main {
    public int findDuplicate(int[] nums) {
        //can be done in O(n) with frequency array
        int n=nums.length;
        for(int i=0;i<=n;i++){
            while(nums[i]!=i+1){
                int temp=nums[i];
                int d=nums[i]-1;
                if(nums[i]==nums[d]) return nums[i];
                nums[i]=nums[d];
                nums[d]=temp;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {3,1,3,4,2};
        int duplicate = main.findDuplicate(nums);
        System.out.println(duplicate); // Output: 3
    }
}
