import java.util.*;
public class Main {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int j=0;j<Math.pow(2,n);j++){
            List<Integer> list = new ArrayList<>();
            int temp=j;
            for(int i=0;i<n;i++){
                if(temp%2==1) list.add(nums[i]);
                temp/=2;
            }
            if(!map.containsKey(list))ans.add(list);
            map.put(list,1);
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
        List<List<Integer>> result = obj.subsetsWithDup(arr);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
