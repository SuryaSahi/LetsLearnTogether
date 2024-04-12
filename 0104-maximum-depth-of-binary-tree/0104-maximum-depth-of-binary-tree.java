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
    public int maxDepth(TreeNode root) {
         if(root == null)return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int height = 0;

        q.add(root);
        while( !q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();

                if(temp.left != null)q.add(temp.left);
                if(temp.right != null)q.add(temp.right);
            }
            height++;
        }
        return height;
    }
}