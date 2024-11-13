class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        
        // Define the starting and ending indices for inorder and postorder arrays
        int inStart = 0;
        int inEnd = n - 1;
        
        int postStart = 0;
        int postEnd = n - 1;

        // Start the recursive tree construction
        return solve(inorder, postorder, inStart, inEnd, postStart, postEnd);
    }
    
    public TreeNode solve(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        // Base case: if no elements to process in inorder array
        if (inStart > inEnd) return null;
        
        // The root value is the last element in the current postorder range
        int rootval = postorder[postEnd];
        
        // Find the root in the inorder array to separate left and right subtrees
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (rootval == inorder[i]) break;
        }
        
        // Calculate the size of the left and right subtrees based on inorder split
        int leftside = i - inStart;
        int rightside = inEnd - i;

        // Create the root node with the root value
        TreeNode root = new TreeNode(rootval);
        
        // Recursively build the left subtree
        root.left = solve(inorder, postorder, inStart, i - 1, postStart, postStart + leftside - 1);
        
        // Recursively build the right subtree
        root.right = solve(inorder, postorder, i + 1, inEnd, postEnd - rightside, postEnd - 1);
        
        return root;
    }
}
