import java.util.*;
public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void preorder(TreeNode node, List<Integer> ans){
        if(node==null) return;
        ans.add(node.val);
        preorder(node.left, ans);
        preorder(node.right, ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Main solution = new Main();
        List<Integer> result = solution.preorderTraversal(root);
        System.out.println(result); // Output: [1, 2, 3]
    }
}
