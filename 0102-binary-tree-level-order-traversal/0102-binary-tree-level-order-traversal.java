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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)return ans;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null)q.add(temp.left);
                if(temp.right != null)q.add(temp.right);
                res.add(temp.val);
            }
            ans.add(new ArrayList<>(res));
        }
        return ans;
    }
}

class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
        return list;
        q.add(root);
        while(! q.isEmpty())
        {
          List<Integer> sub = new ArrayList<>();
          int len = q.size();
          for(int i = 0; i<len; i++)
          {
            if(q.peek().left != null)
            q.add(q.peek().left);
            if(q.peek().right != null)
            q.add(q.peek().right);
            sub.add(q.remove().val);
          }
          list.add(sub);
        }
        return list;
    }
}