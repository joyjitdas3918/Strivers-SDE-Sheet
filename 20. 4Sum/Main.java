import java.util.*;
public class Main {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i-1>=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j-1>i && nums[j]==nums[j-1]) continue;
                int l=j+1,r=n-1;
                while(l<r){
                    if((long)nums[i]+(long)nums[j]+(long)nums[l]+(long)nums[r]==(long)target){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        l++;
                        while(l<=r && nums[l]==nums[l-1]) l++;
                        r--;
                        while(l<=r && nums[r]==nums[r+1]) r--;
                    }
                    else if((long)nums[i]+(long)nums[j]+(long)nums[l]+(long)nums[r]<(long)target) l++;
                    else r--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = main.fourSum(nums, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
