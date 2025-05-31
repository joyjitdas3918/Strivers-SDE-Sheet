import java.util.*;
public class Main {
    public int myAtoi(String s) {
        long ans=0;
        int ss=0,m=0,n1=0,p1=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='+'){
                if(m==0){
                    ss=0;
                    m=1;
                    continue;
                }
                else break;
            }
            else if(ch=='-'){
                if(m==0){
                    ss=1;
                    m=1;
                    continue;
                }
                else break;
            }
            else if(ch>='0' && ch<='9'){
                ans=ans*10L+(long)(ch-'0');
                m=1;
                if(ans>=2147483648L) n1=1;
                if(ans>=2147483647L) p1=1;
                
            }
            else if(ch==' '){
                if(m==1)
                break;
                
            }
            else break;
        }
        return (ss==1)?(n1==0)?(-1*(int)ans):-2147483648:(p1==0)?(int)ans:2147483647;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        String input = "   -42";
        int result = obj.myAtoi(input);
        System.out.println(result); // Output: -42
    }
}
