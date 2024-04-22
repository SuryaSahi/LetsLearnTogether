class Solution2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Getting TLE if not checking visited or not;
        Queue<int[]> que = new LinkedList<>();
        int row = image.length;
        int col = image[0].length;
        
        int ogcolor = image[sr][sc];
        image[sr][sc] = color;
        que.add(new int[]{sr , sc});
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i<size; i++){
                int[] point = que.poll();
                for(int j = 0; j<4; j++){
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x < 0 || y < 0 || x >= row || y >= col || image[x][y] != ogcolor)continue;
                    
                    image[x][y] = color;
                    que.offer(new int[]{x,y});
                }
            }
            if(que.size() == 0)return image;
        }
        return image;
    }
}
class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int rows = image.length;
    int cols = image[0].length;
    if (sr < 0 || sr >= rows || sc < 0 || sc >= cols || image[sr][sc] == color) {
      return image; // Early exit if starting pixel is already filled or out of bounds
    }

    int originalColor = image[sr][sc];
    image[sr][sc] = color;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rows][cols]; // Keep track of visited pixels

    queue.offer(new int[]{sr, sc});
    visited[sr][sc] = true;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    while (!queue.isEmpty()) {
      int[] point = queue.poll();
      for (int i = 0; i < 4; i++) {
        int x = point[0] + dx[i];
        int y = point[1] + dy[i];

        if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && image[x][y] == originalColor) {
          image[x][y] = color;
          queue.offer(new int[]{x, y});
          visited[x][y] = true;
        }
      }
    }

    return image;
  }
}
