public class Main {
    public int removeDuplicates(int[] nums) {
        int cnt=1,j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[j++]=nums[i];
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        // Example usage
        int[] nums = {1, 1, 2, 2, 3};
        Main main = new Main();
        int result = main.removeDuplicates(nums);
        
        // Print the result
        System.out.println("Number of unique elements: " + result);
        System.out.print("Modified array: ");
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }   
}
