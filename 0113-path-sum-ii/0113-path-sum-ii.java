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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        helper(root,new ArrayList<>() , ans , 0 , targetSum);
        return ans;
    }
    
    public void helper(TreeNode root , List<Integer> res ,List<List<Integer>> ans , int sum , int target ){
        if(root == null)return;
        
        sum += root.val;
        res.add(root.val); // adding elements
        
        
        if(root.left == null && root.right == null && sum == target){
            ans.add(new ArrayList<>(res));
            // 
        }
        helper(root.left , res , ans , sum , target);
        helper(root.right , res , ans , sum , target);
        //backtracking my tree after each value is traversed once
        res.remove(res.size() - 1); //removing elements
    }
}

//Time Complexity - O(n^2)  , Space Complexity - O(1)