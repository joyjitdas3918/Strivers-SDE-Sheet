import java.util.*;
public class Main {
    public static void fun(String res, String s, HashSet<String> words, List<String> ans){
        if(s.length()==0){
            ans.add(res);
            return;
        }
        for(int i=1;i<=s.length();i++){
            String s1=s.substring(0,i);
            if(words.contains(s1)){
                if(res.length()!=0) fun(res+" "+s1,s.substring(i),words,ans);
                else fun(s1,s.substring(i),words,ans);
            }
        }
    }
    static String[] wordBreak(String[] dict, String s) {
        // code here
        HashSet<String> words=new HashSet<>(Arrays.asList(dict));
        List<String> ans=new ArrayList<>();
        fun("",s,words,ans);
        return ans.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String[] dict = {"i", "like", "sam", "sung", "samsung", "mobile", "ice"};
        String[] result = wordBreak(dict, "ilikesamsung");
        for (String str : result) {
            System.out.println(str);
        }
    } 
}
