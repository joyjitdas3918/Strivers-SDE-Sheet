public class Main {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int l=0,r=m-1,i=-1,j=-1;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(matrix[mid][0]==target) return true;
            if(matrix[mid][0]<=target){
                i=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        if(i==-1) return false;
        l=0;
        r=n-1;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(matrix[i][mid]==target) return true;
            if(matrix[i][mid]<=target)  l=mid+1;
            else r=mid-1;
        }
        return false;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 3;
        boolean result = main.searchMatrix(matrix, target);
        System.out.println(result); // Output: true
    }
}
