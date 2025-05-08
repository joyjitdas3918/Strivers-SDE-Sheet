import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        int a=intervals[0][0], n=intervals.length;
        for(int i=0;i<intervals.length;i++){
            if(i==n-1 || intervals[i][1]<intervals[i+1][0]){
                List<Integer> arr=new ArrayList<>();
                arr.add(a);
                arr.add(intervals[i][1]);
                ans.add(arr);
                if(i+1<n) a=intervals[i+1][0];
            }
            else{
                intervals[i+1][1]=Math.max(intervals[i+1][1],intervals[i][1]);
            }
        }
        return ans.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        int[][] intervals = {{1,8},{2,6},{8,10},{15,18}};
        int[][] merged = main.merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
