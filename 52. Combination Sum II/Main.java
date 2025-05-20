import java.util.*;
public class Main {
    public void fun(int i,int n, int[] arr, int target, ArrayList<Integer> list, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0) return;
        if(i==n) return;
        int ni=i+1;
        while(ni<n && arr[ni]==arr[ni-1]) ni++;
        
        fun(ni,n, arr, target, list, ans);
        list.add(arr[i]);
        fun(i+1,n, arr, target-arr[i], list, ans);
        list.remove(list.size() - 1);

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        fun(0,candidates.length, candidates, target, new ArrayList<Integer>(), ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Main obj = new Main();
        List<List<Integer>> result = obj.combinationSum2(arr, target);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
