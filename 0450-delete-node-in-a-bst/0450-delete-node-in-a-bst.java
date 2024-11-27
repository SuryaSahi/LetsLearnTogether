class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) return helper(root);

        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > key) {
                if (temp.left != null && temp.left.val == key) {
                    temp.left = helper(temp.left);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right != null && temp.right.val == key) {
                    temp.right = helper(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = lastRightFind(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    public TreeNode lastRightFind(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
