import java.util.*;
public class Main {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int j=0,n=nums.length;
        int ans[]=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && i-k==dq.peek()) dq.poll();
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) dq.pollLast();
            dq.offer(i);
            if(i>=k-1) ans[j++]=nums[dq.peek()];
        }
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = obj.maxSlidingWindow(nums, k);
        System.out.println("Maximums in Sliding Window: " + Arrays.toString(result));
    }
}
