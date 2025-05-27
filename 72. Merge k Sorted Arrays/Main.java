import java.util.*;
public class Main {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<arr.length;i++) pq.add(new int[]{arr[i][0],i,0});
        while(!pq.isEmpty()){
            int top[]=pq.remove();
            ans.add(top[0]);
            if(top[2]+1<arr[top[1]].length) pq.add(new int[]{arr[top[1]][top[2]+1],top[1],top[2]+1});
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[][] arr = new int[K][];
        for (int i = 0; i < K; i++) {
            int n = sc.nextInt();
            arr[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> result = mergeKArrays(arr, K);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
