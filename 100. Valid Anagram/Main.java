import java.util.*;
class Main {
    public boolean isAnagram(String s, String t) {
        int freq[]=new int[26];
        int l=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            l++;
        }
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)-'a']--;
            if(freq[t.charAt(i)-'a']<0) return false;
            l--;
        }
        return l==0;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.isAnagram("anagram", "nagaram")); // true
        System.out.println(obj.isAnagram("rat", "car")); // false
    }
}