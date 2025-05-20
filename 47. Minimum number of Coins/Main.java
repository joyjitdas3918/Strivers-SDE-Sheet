import java.util.*;
public class Main {
    static List<Integer> minPartition(int N) {
        // code here
        int arr[]={ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int n=arr.length;
        List<Integer> ans=new ArrayList<>();
        int j=n-1;
        while(N>0){
            while(N>=arr[j]){
                ans.add(arr[j]);
                N-=arr[j];
            }
            j--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int N = 93;
        List<Integer> result = minPartition(N);
        System.out.println("Minimum number of coins: " + result.size());
        System.out.println("Coins used: " + result);
    }
}
