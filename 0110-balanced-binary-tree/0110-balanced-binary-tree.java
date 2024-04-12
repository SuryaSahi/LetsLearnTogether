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
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;

        int left = depth(root.left);
        int right = depth(root.right);

        if(Math.abs(left - right) > 1)return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode temp = q.poll();
                if(temp.left != null)q.add(temp.left);
                if(temp.right != null)q.add(temp.right);
            }
            depth++;
        }
        return depth;
    }
}