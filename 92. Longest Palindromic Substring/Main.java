import java.util.*;
public class Main {
    public String longestPalindrome(String s) {
        int ans=1,x=0,y=0,n=s.length();
        for(int i=0;i<n;i++){
            int l=i-1,r=i+1;
            int sz=1;
            while(l>=0 && r<n){
                if(s.charAt(l)==s.charAt(r)){
                    sz+=2;
                    l--;
                    r++;
                }
                else break;
            }
            if(sz>ans){
                x=l+1;
                y=r-1;
                ans=sz;
            }
            sz=2;
            l=i;
            r=i+1;
            if(!(l>=0 && r<n)) continue;
            if(s.charAt(l)!=s.charAt(r)){
                continue;
            }
            l--;
            r++;
            while(l>=0 && r<n){
                if(s.charAt(l)==s.charAt(r)){
                    sz+=2;
                    l--;
                    r++;
                }
                else break;
            }
            if(sz>ans){
                x=l+1;
                y=r-1;
                ans=sz;
            }

        }
        return s.substring(x,y+1);
    }
    public static void main(String[] args) {
        Main obj = new Main();
        String s = "babad";
        System.out.println("Longest palindromic substring: '" + obj.longestPalindrome(s) + "'"); // Output: "bab" or "aba"
    }
}
