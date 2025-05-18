import java.util.*;
public class Main {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num: nums) set.add(num);
        int ans=0;
        for(int ele: set){
            if(!set.contains(ele-1)){
                int cnt=1;
                while(set.contains(ele+1)){
                    cnt++;
                    ele++;
                }
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = main.longestConsecutive(nums);
        System.out.println("Longest consecutive sequence length: " + result); // Output: 4
    }
}
