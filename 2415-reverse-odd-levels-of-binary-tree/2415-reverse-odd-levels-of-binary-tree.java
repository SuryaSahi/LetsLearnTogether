class Solution1 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Collect nodes at this level
                nodes.add(current);

                // Add children for the next level
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // Reverse the node values for odd levels
            if (level % 2 == 1) {
                int left = 0, right = nodes.size() - 1;
                while (left < right) {
                    int temp = nodes.get(left).val;
                    nodes.get(left).val = nodes.get(right).val;
                    nodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++; // Move to the next level
        }

        return root;
    }
}

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        // Create a new tree with reversed odd levels
        return buildNewTree(root, root, 0);
    }

    private TreeNode buildNewTree(TreeNode original, TreeNode mirror, int level) {
        if (original == null || mirror == null) return null;

        // Create a new node for the new tree
        TreeNode newNode = new TreeNode(level % 2 == 0 ? original.val : mirror.val);

        // Recursively build left and right subtrees
        newNode.left = buildNewTree(original.left, mirror.right, level + 1);
        newNode.right = buildNewTree(original.right, mirror.left, level + 1);

        return newNode;
    }
}

