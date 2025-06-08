import java.util.*;
public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void inorder(TreeNode node, List<Integer> ans){
        if(node==null) return;
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        // Example usage
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        List<Integer> result = obj.inorderTraversal(root);
        System.out.println(result); // Output: [1, 3, 2]
    }
}
