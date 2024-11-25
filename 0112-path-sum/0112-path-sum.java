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
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean ans = solve(root , 0 , targetSum);
        return ans;
    }
    
    public boolean solve(TreeNode root , int sum , int targetSum){
        if(root == null)return false;
        
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum)return true;
            return false;
        }
        
        boolean left = solve(root.left , sum , targetSum);
        boolean right = solve(root.right , sum , targetSum);
        
        return left || right;
    }
}