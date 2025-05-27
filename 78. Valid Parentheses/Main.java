import java.util.*;
public class Main {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') st.push(ch);
            else if(ch=='{') st.push(ch);
            else if(ch=='[') st.push(ch);
            else if(ch==')' && !st.isEmpty() && st.peek()=='(') st.pop();
            else if(ch=='}' && !st.isEmpty() && st.peek()=='{') st.pop();
            else if(ch==']' && !st.isEmpty() && st.peek()=='[') st.pop();
            else return false;
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Main obj = new Main();
        System.out.println(obj.isValid(s));
    }
}
