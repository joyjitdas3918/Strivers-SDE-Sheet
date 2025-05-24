import java.util.*;
public class Main{
    public int upb(int x, int i, int c, int[][]mat){
        int l=0,r=c-1,ans=c;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(mat[i][mid]>x){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    int median(int mat[][]) {
        // code here
        int m=mat.length;
        int n=mat[0].length;
        int l=1,r=2000;
        while(l<=r)
        {
            int mid=(r-l)/2+l;
            int lesseq=0;
            for(int i=0;i<m;i++) lesseq+=upb(mid,i,n,mat); 
            if(lesseq<=(m*n)/2) l=mid+1;
            else r=mid-1;
        }
        return l;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[][] mat = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        System.out.println(obj.median(mat)); // Output: 5
    }
}