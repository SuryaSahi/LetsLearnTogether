class Solution {
    int m;
    int n;
    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int islands = NoOfIslands(grid);
        
        if(islands > 1 || islands == 0)return 0;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                grid[i][j] = 0;
                islands = NoOfIslands(grid);
                if(islands > 1 || islands == 0)return 1;
                
                grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    
    public int NoOfIslands(int[][] grid){
        int Count_islands = 0;
        
        boolean[][] isvis = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && !isvis[i][j]){
                    DFS(grid , i , j , isvis);
                    Count_islands++;
                }
            }
        }
        return Count_islands;
    }
    public void DFS(int[][] grid , int i , int j , boolean[][] isvis){
        if (i >= m || i < 0 || j >= n || j < 0 || isvis[i][j] || grid[i][j] == 0) return;
        
        isvis[i][j] = true;
        DFS(grid , i+1 , j , isvis);
        DFS(grid , i-1 , j , isvis);
        DFS(grid , i , j+1 , isvis);
        DFS(grid , i , j-1 , isvis);
    }
}