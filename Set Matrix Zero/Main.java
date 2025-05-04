

public class Main {
    public static void setZeroes(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length,col0=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    if(j!=0) matrix[0][j]=0;
                    else col0=1;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<m;j++) matrix[0][j]=0;
        }
        if(col0==1){
            for(int i=0;i<n;i++) matrix[i][0]=0;
        }
        
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        setZeroes(matrix);

        System.out.println("The Final matrix is: ");
        for (int[] row : matrix) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
