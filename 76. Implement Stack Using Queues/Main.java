import java.util.*;
public class Main {
    private Queue<Integer> q;

    public Main() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
    public static void main(String[] args) {
        Main stack = new Main();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.empty()); // false
        System.out.println(stack.pop()); // 1
        System.out.println(stack.empty()); // true
    }
}
