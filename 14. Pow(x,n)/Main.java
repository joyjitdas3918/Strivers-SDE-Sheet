public class Main {
    public double myPow(double x, int n) {
        long nn=n;
        if(n<0) nn*=-1L;
        double ans=1.0;
        while(nn>0){
            if(nn%2==0){
                x=x*x;
                nn/=2;
            }
            else{
                ans*=x;
                nn--;
            }
        }
        if(n<0) ans=(1.0/ans);
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        double x = 2.0;
        int n = 10;
        double result = main.myPow(x, n);
        System.out.println(result); // Output: 1024.0
    }
}
