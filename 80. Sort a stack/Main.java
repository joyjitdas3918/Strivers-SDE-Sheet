import java.util.*;
public class Main {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        int n=s.size();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) arr[i]=s.pop();
        Arrays.sort(arr);
        for(int x:arr) s.push(x);
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            s.push(sc.nextInt());
        }
        Main obj = new Main();
        Stack<Integer> sortedStack = obj.sort(s);
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
    }
}
