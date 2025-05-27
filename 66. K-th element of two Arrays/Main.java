import java.util.*;
public class Main {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int m=a.length,n=b.length;
        if(m>n) return kthElement(b,a,k);
        int l=Math.max(0,k-n),r=Math.min(m,k);
        while(l<=r){
            int m1=(l+r)/2;
            int m2=k-m1;
            
            int l1=(m1>0)?a[m1-1]:Integer.MIN_VALUE;
            int l2=(m2>0)?b[m2-1]:Integer.MIN_VALUE;
            int r1=(m1<m)?a[m1]:Integer.MAX_VALUE;
            int r2=(m2<n)?b[m2]:Integer.MAX_VALUE;
            if(l1<=r2 && l2<=r1) return Math.max(l1,l2);
            if(l1>r2) r=m1-1;
            else l=m1+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Main obj = new Main();
        System.out.println(obj.kthElement(a, b, k));
    }
}
