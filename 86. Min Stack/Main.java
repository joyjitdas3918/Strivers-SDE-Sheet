import java.util.*;
public class Main {
    Stack<int[]> st;
    public Main() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()) st.push(new int[]{val,val});
        else st.push(new int[]{val,Math.min(st.peek()[1],val)});
    }
    
    public void pop() {
        if(!st.isEmpty()) st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
    public static void main(String[] args) {
        Main obj = new Main();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println("Minimum: " + obj.getMin()); // Returns -3
        obj.pop();
        System.out.println("Top: " + obj.top()); // Returns 0
        System.out.println("Minimum: " + obj.getMin()); // Returns -2
    }
}
