import java.util.HashMap;

class Solution {
    public boolean isMatch(String s, String p) {
        HashMap<String, Boolean> cache = new HashMap<>(); // Cache for memoization
        return backtrack_memo(s, p, 0, 0, cache); 
    }

    // backtracking with memoization
    public boolean backtrack_memo(String s, String p, int i, int j, HashMap<String, Boolean> cache) {
        String key = i + "," + j; // Unique key for the current indices (i, j)

        // Return cached result if it exists
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // Base cases
        if (j >= p.length()) {
            return i >= s.length(); // If pattern is exhausted, check if string is also exhausted
        }

        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // Handle '*' in the pattern
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            
            boolean result = (backtrack_memo(s, p, i, j + 2, cache) || (match && backtrack_memo(s, p, i + 1, j, cache)));
            cache.put(key, result);
            return result; // Return result to prevent further execution
        } else if (match) {
            // If current characters match, move to the next characters in both strings
            boolean result = backtrack_memo(s, p, i + 1, j + 1, cache);
            cache.put(key, result);
            return result; // Return result to prevent further execution
        }

        cache.put(key, false); // No match found
        return false; // Return false when no match is found
    }
}
