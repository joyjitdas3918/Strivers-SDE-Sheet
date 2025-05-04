
public class Main {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //transpose
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        //reverse
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=t;
            }
        }
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }; // Example input
        obj.rotate(matrix);
        System.out.println("Rotated matrix:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
