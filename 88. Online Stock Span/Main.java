import java.util.*;
class Main{
    Stack<int[]> stack = new Stack<>();
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];//so that even removing impact remains
        stack.push(new int[]{price, res});
        return res;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Stock span for price 100: " + obj.next(100)); // Output: 1
        System.out.println("Stock span for price 80: " + obj.next(80));   // Output: 1
        System.out.println("Stock span for price 60: " + obj.next(60));   // Output: 1
        System.out.println("Stock span for price 70: " + obj.next(70));   // Output: 2
        System.out.println("Stock span for price 60: " + obj.next(60));   // Output: 1
        System.out.println("Stock span for price 75: " + obj.next(75));   // Output: 4
        System.out.println("Stock span for price 85: " + obj.next(85));   // Output: 6
    }
}