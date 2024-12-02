class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int row, int col) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row, col});
        grid[row][col] = '2';  // Mark the starting cell as visited
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] temp = que.poll();
                for (int j = 0; j < 4; j++) {
                    int new_row = temp[0] + x[j];
                    int new_col = temp[1] + y[j];

                    // Ensure within bounds and that the cell is land ('1')
                    if (new_row >= 0 && new_row < grid.length && new_col >= 0 && new_col < grid[0].length
                            && grid[new_row][new_col] == '1') {
                        grid[new_row][new_col] = '2';  // Mark as visited
                        que.add(new int[]{new_row, new_col});
                    }
                }
            }
        }
    }
}
