import java.util.*;
public class Main {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public Main() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    public static void main(String[] args) {
        Main queue = new Main();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // 1
        System.out.println(queue.pop()); // 1
        System.out.println(queue.empty()); // false
        System.out.println(queue.pop()); // 2
        System.out.println(queue.empty()); // true
    }
}
