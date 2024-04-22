class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0 , minCnt = 0 , cnt = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 2)que.add(new int[]{i,j});
                if(grid[i][j] != 0)fresh++;
                
            }
        }
        if(fresh == 0)return 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while(!que.isEmpty()){
            int size = que.size();
            cnt += size;
            for(int i = 0; i<size; i++){
                int[] point = que.poll();
                for(int j = 0; j<4; j++){
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0 || grid[x][y] == 2)continue;
                    grid[x][y] = 2;
                    que.offer(new int[]{x,y});
                }
            }
            
            if(que.size() != 0)minCnt++;
        }
        return fresh == cnt ? minCnt : -1;
    }
}