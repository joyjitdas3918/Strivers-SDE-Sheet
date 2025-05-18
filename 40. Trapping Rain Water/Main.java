public class Main {
    public int trap(int[] height) {
        // int n=height.length;
        // int dp[]=new int[n];
        // for(int i=n-2;i>=0;i--){
        //     dp[i]=Math.max(dp[i+1],height[i+1]);
        // }
        // int m=0,ans=0;
        // for(int i=0;i<n;i++){
        //     int mm=Math.min(m,dp[i]);
        //     if(mm>height[i]) ans+=mm-height[i];
        //     m=Math.max(m,height[i]);
        // }
        // return ans;
        int l = 0;
        int r = height.length-1;
        int lMax = height[l];
        int rMax= height[r];
        int ans = 0;

        while(l<r){
            if(lMax < rMax){
                l++;
                lMax = Math.max(lMax, height[l]);
                ans += lMax - height[l];
            }

            else{
                r--;
                rMax = Math.max(rMax, height[r]);
                ans += rMax - height[r];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Main main = new Main();
        int result = main.trap(height);
        
        // Print the result
        System.out.println("Trapped rainwater: " + result);
    }
}
