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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
    moves = 0;
    dfs(root);
    return moves;
    }
    public int dfs(TreeNode node)
    {
        if(node == null)return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        moves +=Math.abs(L) + Math.abs(R);
        return node.val + L + R -1;
    }
}