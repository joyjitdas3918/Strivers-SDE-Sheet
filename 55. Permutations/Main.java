import java.util.*;
public class Main {
    public boolean possible(List<Integer> list){
        int n=list.size();
        for(int i=1;i<n;i++){
            if(list.get(i)>list.get(i-1)) return true;
        }
        return false;
    }
    public List<Integer> next(List<Integer> list){
        int n=list.size();
        int pos=-1;
        for(int i=n-2;i>=0;i--){
            if(list.get(i+1)>list.get(i)){
                pos=i;
                break;
            }
        }
        for(int i=n-1;i>pos;i--){
            if(list.get(i)>list.get(pos)){
                Collections.swap(list,i,pos);
                break;
            }
        }
        int start=pos+1,end=n-1;
        while(start<end){
            Collections.swap(list,start,end);
            start++;
            end--;
        }
        return list;
    }
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        for(int ele: nums) list.add(ele);
        ans.add(new ArrayList<>(list));
        while(possible(list)){
            list=next(list);
            ans.add(new ArrayList<>(list));
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
        List<List<Integer>> result = obj.permute(arr);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }    
}
