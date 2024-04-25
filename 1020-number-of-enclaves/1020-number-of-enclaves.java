class Solution1 {
    public void dfs(int[][] grid , int[][] vis , int x , int y){
        vis[x][y] = 1;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        
        for(int i = 0; i < 4; i++){
            int nr = x + dx[i];
            int nc = y + dy[i];
            if(nc >= 0 && nr >= 0 && nc < grid.length && nr < grid[0].length && grid[nr][nc] == 1 && vis[nr][nc] == 0)
                dfs(grid , vis , nr , nc);
        }
    }
    
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        for(int i = 0; i<m; i++){
            if(grid[0][i] == 1 && vis[0][i] == 0)
                dfs(grid , vis , 0 , i);
            if(grid[0][n - 1] == 1 && vis[0][n - 1] == 0)
                dfs(grid , vis , i , n - 1);
        }
        for(int i = 0; i<n; i++){
            if(grid[i][0] == 1 && vis[i][0] == 0)
                dfs(grid , vis , i , 0);
            if(grid[i][m - 1] == 1 && vis[i][m - 1] == 0)
                dfs(grid , vis , i , m - 1);
        }
        
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1)cnt++;
            }
        }
        return cnt;
    }
}

class Solution {
    public int numEnclaves(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j< m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(grid[i][j] == 1)
                    {
                        q.add(new Pair(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        while(!q.isEmpty()){
            int nr = q.peek().first;
            int nc = q.peek().second;
            q.remove();
            
            for(int i = 0; i<4; i++){
                int newr = nr + dx[i];
                int newc = nc + dy[i];
                
                if(newr >= 0 && newc >= 0 && newr < n && newc < m && grid[newr][newc] ==  1 && vis[newr][newc] == 0){
                    q.add(new Pair(newr , newc));
                    vis[newr][newc] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1)cnt++;
            }
        }
        return cnt;
    }
}
class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}