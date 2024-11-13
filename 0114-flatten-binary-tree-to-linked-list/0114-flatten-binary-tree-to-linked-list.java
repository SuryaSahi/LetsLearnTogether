/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1 {
    public void flatten(TreeNode root) {
        //Morris Traversal
        TreeNode curr = root;
        TreeNode prev = null;
        
        while(curr != null){
            if(curr.left != null){
            prev = curr.left;
            while(prev.right != null){
                prev = prev.right;
            }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            
            curr = curr.right;
        }
    }
}

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        
        if(root == null)return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
        return;
    }
}
