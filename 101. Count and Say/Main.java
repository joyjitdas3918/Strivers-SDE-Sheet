import java.util.*;
class Main{
    public String countAndSay(int n) {
        String s="1";
        while(n>1){
            n--;
            String t="";
            int c=1;
            for(int i=1;i<s.length();i++){
                if(s.charAt(i)!=s.charAt(i-1)){
                    t+=String.valueOf(c);
                    t+=s.charAt(i-1);
                    c=1;
                }
                else c++;
            }
            t+=String.valueOf(c);
            t+=s.charAt(s.length()-1);
            s=t;
        }
        return s;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.countAndSay(1)); // "1"
        System.out.println(obj.countAndSay(2)); // "11"
        System.out.println(obj.countAndSay(3)); // "21"
        System.out.println(obj.countAndSay(4)); // "1211"
        System.out.println(obj.countAndSay(5)); // "111221"
    }
}