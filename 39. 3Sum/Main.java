import java.util.*;
public class Main {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i-1>=0 && nums[i]==nums[i-1]) continue;
            int j=i+1,k=n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    k--;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0) j++;
                else k--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Main main = new Main();
        List<List<Integer>> result = main.threeSum(nums);
        
        // Print the result
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
