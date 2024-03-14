class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)return -1;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        grid[0][0] = 1;

        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0},{1,-1},{-1,1},{1,1},{-1,-1}};
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-->0)
            {
                int[] point = q.poll();
                if(point[0] == rows - 1 && point[1] == cols -1)
                return point[2];
                for(int[] dic : direction)
                {
                    int r = point[0] + dic[0];
                    int c = point[1] + dic[1];

                    if(r >= 0 && c >= 0 && r  < rows && c < cols && grid[r][c] == 0)
                    {
                        q.add(new int[]{r,c,point[2]+1});
                        grid[r][c] = 1;
                    }
                }
            }
        }
        return -1;
    }
}