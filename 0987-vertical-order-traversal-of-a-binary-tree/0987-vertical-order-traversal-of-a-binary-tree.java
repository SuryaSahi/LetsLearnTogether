import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map to store nodes by their horizontal distance
        Map<Integer, List<HelpClass>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        // Perform the vertical traversal
        Helper(root, 0, 0, map);
        
        // Process the map to get the sorted values
        for (List<HelpClass> lst : map.values()) {
            Collections.sort(lst, (a, b) -> {
                if (a.level != b.level) return Integer.compare(a.level, b.level);
                return Integer.compare(a.value, b.value);
            });
            
            List<Integer> res = new ArrayList<>();
            for (HelpClass t : lst) {
                res.add(t.value);
            }
            
            ans.add(res);
        }
        
        return ans;
    }

    // Recursive helper function to populate the map
    public void Helper(TreeNode root, int hd, int level, Map<Integer, List<HelpClass>> map) {
        if (root == null) return;
        
        // Add the node to the map with its horizontal distance and level
        map.computeIfAbsent(hd, k -> new ArrayList<>()).add(new HelpClass(root.val, level));
        
        // Recur for left and right subtrees
        Helper(root.left, hd - 1, level + 1, map);
        Helper(root.right, hd + 1, level + 1, map);
    }
}

// Helper class to store node value and its level
class HelpClass {
    int value;
    int level;
    
    HelpClass(int value, int level) {
        this.value = value;
        this.level = level;
    }
}

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
