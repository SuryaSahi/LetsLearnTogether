// class Solution {
//     public int getMaximumGold(int[][] grid) {
//         int ans = Integer.MIN_VALUE;
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] != 0) {
//                     int temp = helper(grid, i, j, grid[i][j]);
//                     ans = Math.max(ans, temp);
//                 }
//             }
//         }
//         return ans;
//     }

//     public int helper(int[][] grid, int x, int y, int gold) {
        
//         if (x < 0 || x == grid.length || y < 0 || y == grid[0].length
//                 || grid[x][y] == 0) {
//             return 0;
//         }
        
//         int currgold = grid[x][y];
//         int maxgold = gold + currgold;

//         int[] dx = {1, 0, -1, 0};
//         int[] dy = {0, 1, 0, -1};
//         for (int i = 0; i < 4; i++) {
//             int newx = x + dx[i];
//             int newy = y + dy[i];
//             if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] != 0)
//                 maxgold = Math.max(maxgold, helper(grid, newx, newy, gold + currgold));
//         }
//         grid[x][y] = currgold; // Restore the original value for backtracking
//         return maxgold;
//     }
// }

class Solution {

    int[] dir = new int[] { 0, 1, 0, -1, 0 };

    // Backtracking
    private int solveBacktracking(int[][] grid, int row, int col) {
        // BASE CASE
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length
                || grid[row][col] == 0) {
            return 0;
        }

        // Approaching the BackTracking.....
        int initialGridValue = grid[row][col];
        // marked visited
        grid[row][col] = 0;

        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = Math.max(res,solveBacktracking(grid, dir[i] + row, dir[i + 1] + col));
        }

        // unmarkinbg visited array
        grid[row][col] = initialGridValue;
        return res + initialGridValue;
    }
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxGold = Math.max(maxGold, solveBacktracking(grid, i, j));
            }
        }
        return maxGold;
    }
}