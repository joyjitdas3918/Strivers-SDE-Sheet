import java.util.Arrays;
public class Main {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0,ans=0;
        for(int i=0;i<g.length;i++){
            while(j<s.length && g[i]>s[j]) j++;
            if(j>=s.length) break;
            ans++;
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int result = obj.findContentChildren(g, s);
        System.out.println("Number of content children: " + result);
    }
}
