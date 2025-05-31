import java.util.*;
public class Main {
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length;
        int i=0,j=n-1;
        int ans=-1;
        while(i<=j){
            if(i==j){
                ans=i;
                break;
            }
            if(mat[i][j]==1) i++;
            else j--;
        }
        if(ans==-1) return -1;
        for(int k=0;k<n;k++){
            if(ans!=k && mat[ans][k]==1){
                return -1;
            }
        }
        for(int k=0;k<n;k++){
            if(mat[k][ans]==0){
                return -1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[][] mat = {
            {1, 1, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        System.out.println("Celebrity index: " + obj.celebrity(mat)); // Output: 1
    }
}
