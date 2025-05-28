import java.util.*;

class Main {
    // Function to find the next smaller element for each element in the array
    static List<Integer> findNextSmallerElement(List<Integer> arr) {
        int n = arr.size();

        // Stores the next smaller elements, initialized with -1
        List<Integer> nextSmaller = new ArrayList<>(Collections.nCopies(n, -1));

        // Monotonic stack to keep track of indices
        Stack<Integer> stk = new Stack<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            
            // Maintain a decreasing order in the stack
            while (!stk.isEmpty() && arr.get(i) < arr.get(stk.peek())) {
                nextSmaller.set(stk.pop(), arr.get(i)); // Assign the next smaller element
            }

            // Push the current index onto the stack
            stk.push(i);
        }

        return nextSmaller;
    }

    // Driver function
    public static void main(String[] args) {
        // Input list
        List<Integer> arr = Arrays.asList(4, 8, 2, 1, 6, 10, 5);

        // Function call to find next smaller elements
        List<Integer> result = findNextSmallerElement(arr);

        // Print the original list
        System.out.println("Original List: " + arr);

        // Print the next smaller elements
        System.out.println("Next Smaller Elements: " + result);
    }
}