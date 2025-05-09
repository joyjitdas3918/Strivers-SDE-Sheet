import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    ArrayList<Integer> findTwoElement(int nums[]) {
        // group into two parts as the first set bit in xor of both means first differentiating bit so based on that divide and then find which one is missing and which one is extra
        int a=0,b=0;
        int xor=0,n=nums.length;
        for(int i=0;i<n;i++){
            xor=(xor^(nums[i]^(i+1)));
        }
        int set=(xor&~(xor-1));
        for(int i=0;i<n;i++){
            if((nums[i]&set)==0) a=(a^nums[i]);
            else b=(b^nums[i]);
        }
        for(int i=1;i<=n;i++){
            if((i&set)==0) a=(a^i);
            else b=(b^i);
        }
        int ca=0;
        for(int i=0;i<n;i++){
            if(nums[i]==a) ca++;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(ca>1) ans.add(a);
        ans.add(b);
        if(ca<=1) ans.add(a);
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {3, 1, 3, 4, 2};
        ArrayList<Integer> result = main.findTwoElement(nums);
        System.out.println(result); // Output: [3, 5]
    }
}
