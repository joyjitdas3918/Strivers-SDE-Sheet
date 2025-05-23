public class Main {
    public int nthRoot(int n, int m) {
        // code here
        int l=0,r=m;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(Math.pow(mid,n)==m) return mid;
            if(Math.pow(mid,n)<m) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int n = 3;
        int m = 27;
        int result = obj.nthRoot(n, m);
        System.out.println(result); // Output: 3
    } 
}
