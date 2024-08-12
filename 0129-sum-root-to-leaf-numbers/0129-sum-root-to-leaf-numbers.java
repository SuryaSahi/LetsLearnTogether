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
    public int sumNumbers(TreeNode root) {
        //stack to traverse + store the value of sum of previous nodes 
       if(root == null)return 0;
        Stack<Pair<TreeNode , Integer>> st = new Stack<>();
        st.add(new Pair<>(root , 0));
        int result_sum = 0;
        while(!st.isEmpty()){
            Pair<TreeNode , Integer> node = st.pop();
            TreeNode temp = node.getKey();
            int sum = node.getValue();
            if(temp.left != null){
                st.add(new Pair<>(temp.left , sum * 10 + temp.val));
            }
            if(temp.right != null){
                st.add(new Pair<>(temp.right , sum * 10 + temp.val));
            }
            if(temp.left == null && temp.right == null)result_sum += sum * 10 +  temp.val;
        }
        return result_sum;
    }
}

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root){
        //using pre-order traversal
        helper(root , "");
        return sum;
    }
    
    public void helper(TreeNode root , String str){
        if(root == null)return;
        
        str += root.val;
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(str);
        }
        helper(root.left , str);
        helper(root.right , str);
        
    }
}