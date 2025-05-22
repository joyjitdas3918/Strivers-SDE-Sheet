import java.util.*;
public class Main {
    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public void fun(int c, char[][] board, List<List<String>> ans, int[] lr, int[]d1, int[]d2){
        if (c == board.length) {
            ans.add(construct(board));
            return;
        }
        for (int r = 0; r < board.length; r++) {
            if (lr[r] == 0 && d1[r + c] == 0 && d2[board.length - 1 + c - r] == 0) {
                board[r][c] = 'Q';
                lr[r] = 1;
                d1[r + c] = 1;
                d2[board.length - 1 + c - r] = 1;
                fun(c + 1, board, ans, lr, d1, d2);
                board[r][c] = '.';
                lr[r] = 0;
                d1[r + c] = 0;
                d2[board.length - 1 + c - r] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        int lr[]=new int[n];
        int d1[]=new int[n*2];
        int d2[]=new int[n*2];
        char board[][]=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) board[i][j]='.';
        }
        fun(0,board,ans,lr,d1,d2);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main obj = new Main();
        List<List<String>> result = obj.solveNQueens(n);
        for (List<String> subset : result) {
            System.out.println(subset);
        }
    }
}