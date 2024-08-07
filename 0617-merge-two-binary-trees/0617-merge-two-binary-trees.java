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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)return null;
        if(root1 == null )return root2;
        if(root2 == null )return root1;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root1);
        q.add(root2);
        while(!q.isEmpty()){
            TreeNode  a = q.remove();
            TreeNode  b = q.remove();
            
            
            if(a != null && b != null){
                a.val = a.val + b.val;
                if(a.left == null){
                    a.left = b.left;
                    
                }
                else {
                    q.add(a.left);
                    q.add(b.left);
                }
                
                if(a.right == null){
                    a.right = b.right;
                }
                else {
                    q.add(a.right);
                    q.add(b.right);
                }
            }
        }
        return root1;
    }
}