import java.util.*;
public class Main {
    public void postorder(TreeNode node, List<Integer> ans){
        if(node==null) return;
        postorder(node.left, ans);
        postorder(node.right, ans);
        ans.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        postorder(root,ans);
        return ans;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        Main solution = new Main();
        List<Integer> result = solution.postorderTraversal(root);
        System.out.println(result); // Output: [2, 3, 1]
    }
}
