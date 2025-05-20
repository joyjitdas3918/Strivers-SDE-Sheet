import java.util.*;
public class Main {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n=values.length;
        long arr[][]=new long[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=weights[i];
            arr[i][1]=values[i];
        }
        Arrays.sort(arr, (a,b)-> {
            if (a[0] == 0 && b[0] == 0) {
                return 0; 
            }
            if (b[0] == 0) {
                return -1; 
            }
            if (a[0] == 0) {
                return 1;
            }
            long valA = (long) a[1] * b[0];
            long valB = (long) b[1] * a[0];

            return Long.compare(valB, valA);
        });
        double ans=0.0;
        for(int i=0;i<n;i++){
            if(W<=arr[i][0]){
                ans+=(double)(arr[i][1]*W)/arr[i][0];
                break;
            }
            else{
                ans+=arr[i][1];
                W-=arr[i][0];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        double result = obj.fractionalKnapsack(values, weights, W);
        System.out.println("Maximum value in Knapsack = " + result);
    }
}
