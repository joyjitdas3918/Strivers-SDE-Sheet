import java.util.*;
public class Main {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++) ans[i]=-1;
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]) ans[st.pop()]=nums[i%n];
            if(i<n) st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Main obj = new Main();
        int[] result = obj.nextGreaterElements(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
