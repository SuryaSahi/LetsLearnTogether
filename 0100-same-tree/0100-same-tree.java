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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();
        
        que1.add(p);
        que1.add(q);
        
        while(!que1.isEmpty() && !que2.isEmpty()){
            TreeNode temp1 = que1.poll();
            TreeNode temp2 = que2.poll();
            
            if(temp1 == null && temp2 == null)continue;
            if(temp1 == null || temp2 == null)return false;
            if(temp1.val != temp2.val)return false;
            
            que1.add(temp1.left);
            que2.add(temp2.left);
            que1.add(temp1.right);
            que2.add(temp2.right);
        }
        
        return que1.isEmpty() && que2.isEmpty();
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();
        
        que1.add(p);
        que2.add(q);
        
        while (!que1.isEmpty() && !que2.isEmpty()) {
            TreeNode temp1 = que1.poll();
            TreeNode temp2 = que2.poll();
            
            if (temp1 == null && temp2 == null) continue;
            if (temp1 == null || temp2 == null) return false;
            if (temp1.val != temp2.val) return false;
            
            que1.add(temp1.left);
            que2.add(temp2.left);
            que1.add(temp1.right);
            que2.add(temp2.right);
        }
        
        //check if both queues are empty
        return que1.isEmpty() && que2.isEmpty();
    }
}
