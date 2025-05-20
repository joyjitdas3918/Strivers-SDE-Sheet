import java.util.*;
public class Main {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        int jobs[][]=new int[n][2];
        for(int i=0;i<n;i++){
            jobs[i][1]=profit[i];
            jobs[i][0]=deadline[i];
        }
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] job : jobs) {
            if (job[0] > pq.size()) {
                pq.add(job[1]);
            } 
            else if (!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.add(job[1]);
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>(Arrays.asList(0, 0));
        while (!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] deadline = {1, 1, 1, 2, 2};
        int[] profit = {10, 20, 30, 40, 50};
        ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
        System.out.println("Number of jobs done: " + result.get(0));
        System.out.println("Total profit: " + result.get(1));
    }
}
