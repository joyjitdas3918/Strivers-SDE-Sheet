import java.util.*;
public class Main {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int x:nums) pq.add(x);
        while(k>1){
            k--;
            pq.remove();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Main obj = new Main();
        System.out.println(obj.findKthLargest(nums, k));
    }
}
