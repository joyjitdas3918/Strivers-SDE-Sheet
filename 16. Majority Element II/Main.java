import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public List<Integer> majorityElement(int[] nums) {
        int ans1=-1000000001,ans2=-1000000001,c1=0,c2=0;
        for(int i=0;i<nums.length;i++){
            if(c2==0 && nums[i]!=ans1){
                ans2=nums[i];
                c2=1;
            }
            else if(c1==0 && nums[i]!=ans2){
                ans1=nums[i];
                c1=1;
            }
            else if(ans1==nums[i]) c1++;
            else if(ans2==nums[i]) c2++;
            else{
                c1--;
                c2--;
            }
        }
        ArrayList<Integer> arr=new ArrayList<>();
        c1=0;
        c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ans1) c1++;
            if(nums[i]==ans2) c2++;
        }
        if(c1>(nums.length/3)) arr.add(ans1);
        if(c2>(nums.length/3)) arr.add(ans2);
        
        return arr;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {3, 2, 3};
        List<Integer> result = main.majorityElement(nums);
        System.out.println(result); // Output: [3]
    }
}
