
public class Main {
    public int maxProfit(int[] prices) {
        int ans=0,m=1000000001,n=prices.length;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,prices[i]-m);
            m=Math.min(prices[i],m);
        }
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] prices = {7, 1, 5, 3, 6, 4}; // Example input
        int result = obj.maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }
}
