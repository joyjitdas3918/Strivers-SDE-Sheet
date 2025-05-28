import java.util.*;
public class Main {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int ans=heights[0],n=heights.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                ans = Math.max(ans, width * height);
            }
            st.push(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + obj.largestRectangleArea(heights));
    }
}
