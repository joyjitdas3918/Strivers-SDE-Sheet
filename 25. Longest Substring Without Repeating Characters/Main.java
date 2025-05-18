import java.util.*;
public class Main {
    public int lengthOfLongestSubstring(String s) {
        int freq[]=new int[256];
        int l=0,r=0,n=s.length(),ans=0;
        while(r<n){
            freq[s.charAt(r)]++;
            while(freq[s.charAt(r)]>1){
                freq[s.charAt(l)]--;
                l++;
            }
            r++;
            ans=Math.max(ans,r-l);
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        String s = "abcabcbb";
        System.out.println(main.lengthOfLongestSubstring(s)); // Example usage
    }
}
