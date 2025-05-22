import java.util.*;
public class Main {
    public void fun(int i, int j, int n, boolean[][] vis, String s, ArrayList<String> ans){
        if(i==n-1 && j==n-1){
            ans.add(s);
            return;
        }
        if(i==n || j==n) return;
        if(i+1<n && !vis[i+1][j]){
            vis[i+1][j]=true;
            fun(i+1,j,n,vis,s+"D",ans);
            vis[i+1][j]=false;
        }
        if(j-1>=0 && !vis[i][j-1]){
            vis[i][j-1]=true;
            fun(i,j-1,n,vis,s+"L",ans);
            vis[i][j-1]=false;
        }
        if(j+1<n && !vis[i][j+1]){
            vis[i][j+1]=true;
            fun(i,j+1,n,vis,s+"R",ans);
            vis[i][j+1]=false;
        }
        if(i-1>=0 && !vis[i-1][j]){
            vis[i-1][j]=true;
            fun(i-1,j,n,vis,s+"U",ans);
            vis[i-1][j]=false;
        }
        return;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n=maze.length;
        boolean vis[][]=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(maze[i][j]==0) vis[i][j]=true;
            }
        }
        vis[0][0]=true;
        ArrayList<String> ans=new ArrayList<>();
        fun(0,0,n,vis,"", ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        Main obj = new Main();
        ArrayList<String> result = obj.ratInMaze(maze);
        for (String path : result) {
            System.out.println(path);
        }
    }    
}
