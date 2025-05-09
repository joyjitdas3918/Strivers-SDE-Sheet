public class Main {
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        long ans=1L;
        for(int i=m+n;i>Math.max(m,n);i--){
            ans=(ans*i)/(m+n-i+1);
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.uniquePaths(3, 7)); // Output: 28
        System.out.println(main.uniquePaths(3, 2)); // Output: 3
        System.out.println(main.uniquePaths(7, 3)); // Output: 28
        System.out.println(main.uniquePaths(3, 3)); // Output: 6
    }   
}
