class Solution {
    long total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        //Approach 1 : Traverse the entire tree taking each node as a root node and then traversing each path from that node
        // time O(n^2)
        if(root == null)return 0;
        
        helper(root , 0 , (long)targetSum);
        pathSum(root.left , targetSum);
        pathSum(root.right , targetSum);
        
        return (int)total;
    }
    
    public void helper(TreeNode root, long sum , long targetSum){
        if(root == null)return;
        
        sum += root.val;
        if(sum == targetSum)total++;
        
        helper(root.left , sum , targetSum);
        helper(root.right , sum , targetSum);
    }
}
