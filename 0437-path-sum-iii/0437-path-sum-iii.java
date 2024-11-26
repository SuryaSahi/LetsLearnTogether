class Solution1 {
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

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // Approach 2: Prefix sum with a HashMap to track running sums
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // Arbitrary value to handle cases where the root itself forms the target sum
        return solve(root, 0L, (long) targetSum, map);
    }

    public int solve(TreeNode root, long runningSum, long targetSum, HashMap<Long, Integer> map) {
        if (root == null) return 0;

        runningSum += root.val;
        int count = map.getOrDefault(runningSum - targetSum, 0);

        map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);

        count += solve(root.left, runningSum, targetSum, map) + solve(root.right, runningSum, targetSum, map);

        map.put(runningSum, map.get(runningSum) - 1); // Remove the current node
        return count;
    }
}
