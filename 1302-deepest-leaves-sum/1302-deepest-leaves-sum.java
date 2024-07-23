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
    public int height(TreeNode root ){
        if(root.left == null && root.right == null)return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int h = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null)q.add(temp.left);
                if(temp.right != null)q.add(temp.right);
            }
            h++;
        }
        return h;
        
    }
    public int helper(TreeNode root , int h , int level ){
        if(root == null)return 0;
        if(root.left == null && root.right == null && level == h){
            return root.val;
        }
        return helper(root.left , h , level + 1) + helper(root.right , h , level + 1);
    }
    public int deepestLeavesSum(TreeNode root) {
        //first we will calculate the height/depth of the tree then with the depth knows we will calculate the nodes in that level now we will add the nodes of the deepest level to the sum
        if(root == null)return 0;
        if(root.left == null && root.right == null)return root.val;
        int h = 0;
        h = height(root) - 1;
        return helper(root , h , 0 );
    }
}