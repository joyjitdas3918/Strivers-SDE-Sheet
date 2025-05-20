import java.util.*;
public class Main {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<=n;i++) arr.add(i);
        int fac[]=new int[n];
        fac[0]=1;
        for(int i=1;i<n;i++) fac[i]=fac[i-1]*i;
        k--;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            int j=k/fac[n-i];
            sb.append(String.valueOf(arr.get(j)));
            arr.remove(j);
            k-=j*fac[n-i];
        }
        return String.valueOf(sb);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Main obj = new Main();
        String result = obj.getPermutation(n, k);
        System.out.println(result);
    }
}
