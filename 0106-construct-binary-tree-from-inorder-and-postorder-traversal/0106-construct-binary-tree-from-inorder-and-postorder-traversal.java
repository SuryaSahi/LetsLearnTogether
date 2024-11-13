
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        
        int inStart = 0;
        int inEnd = n - 1;
        
        int postStart = 0;
        int postEnd = n - 1;
        return solve(inorder , postorder , inStart , inEnd , postStart , postEnd);
    }
    
    public TreeNode solve(int[] inorder, int[] postorder , int inStart , int inEnd , int postStart , int postEnd){
        if(inStart > inEnd)return null;
        
        int rootval = postorder[postEnd]; //root element
        int i = inStart; //searching for root in inorder
        
        for(; i<=inEnd; i++){
            if(rootval == inorder[i])break;
        }
        
        int leftside = i - inStart;
        int rightside = inEnd - i;
        
        TreeNode root = new TreeNode(rootval);
        root.left = solve(inorder , postorder , inStart , i - 1, postStart, postStart + leftside - 1);
        root.right = solve(inorder , postorder , i+1 , inEnd , postEnd - rightside, postEnd - 1);
        
        return root;
    }
}