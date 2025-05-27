import java.util.*;
public class Main {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        Arrays.sort(A);
        Arrays.sort(B);
        int i=N-1,j=N-1;
        pq.offer(new int[]{A[i]+B[j],i,j});
        Set<String> used = new HashSet<>();
        used.add("0,0");
        List<Integer> ans=new ArrayList<>();
        while(K>0){
            K--;
            int[] top = pq.poll();
            int sum = top[0];
            i = top[1];
            j = top[2];
            ans.add(sum);
            if (i - 1 >=0 && !used.contains((i - 1) + "," + j)) {
                pq.offer(new int[]{A[i - 1] + B[j], i - 1, j});
                used.add((i - 1) + "," + j);
            }
            if (j - 1 >=0 && !used.contains(i + "," + (j - 1))) {
                pq.offer(new int[]{A[i] + B[j - 1], i, j - 1});
                used.add(i + "," + (j - 1));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        List<Integer> result = maxCombinations(N, K, A, B);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
