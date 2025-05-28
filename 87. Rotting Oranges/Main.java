import java.util.*;
public class Main {
    public int orangesRotting(int[][] grid) {
        int good=0,m=grid.length,n=grid[0].length, ans=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    grid[i][j]=0;
                }
                if(grid[i][j]==1) good++;
            }
        }
        while(!q.isEmpty() && good>0){
            ans++;
            int k=q.size();
            while(k-->0){
                int x[]=q.poll();
                int i=x[0];
                int j=x[1];
                if(i-1>=0 && grid[i-1][j]==1){
                    good--;
                    grid[i-1][j]=0;
                    q.offer(new int[]{i-1,j});
                }
                if(j-1>=0 && grid[i][j-1]==1){
                    good--;
                    grid[i][j-1]=0;
                    q.offer(new int[]{i,j-1});
                }
                if(i+1<m && grid[i+1][j]==1){
                    good--;
                    grid[i+1][j]=0;
                    q.offer(new int[]{i+1,j});
                }
                if(j+1<n && grid[i][j+1]==1){
                    good--;
                    grid[i][j+1]=0;
                    q.offer(new int[]{i,j+1});
                }
            }
        }
        return (good==0)?ans:-1;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 2}
        };
        System.out.println("Minutes until all oranges rot: " + obj.orangesRotting(grid)); // Output: 4
    }
}
