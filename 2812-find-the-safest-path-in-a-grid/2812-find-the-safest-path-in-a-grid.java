class Solution1 {
    class tuple{
        int first , second , dist;
        public tuple(int first , int second , int dist){
            this.first = first;
            this.second = second;
            this.dist = dist;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        if(grid.get(0).get(0) == 1 || grid.get(grid.size() - 1 ).get(grid.size() - 1) == 1)return 0;
        int[][] distance = getdist(grid);
        return safestpath(distance);
    }
    private int safestpath(int[][] grid){
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)-> -Integer.compare(a.dist , b.dist));
        int[][] distance = new int[grid.length][grid.length];
        for(int[] i : distance)Arrays.fill(i,Integer.MIN_VALUE);
        pq.add(new tuple(0,0,distance[0][0]));
        
        while(!pq.isEmpty()){
            tuple  t = pq.remove();
            int i = t.first , j = t.second , dist = t.dist;
            if(i-1 >= 0 && distance[i-1][j] < Math.min(grid[i-1][j] , dist)){
                distance[i-1][j] = Math.min(grid[i-1][j] , dist);
                pq.add(new tuple(i-1,j,distance[i-1][j]));
            }
            if(j-1 >= 0 && distance[i][j-1] < Math.min(grid[i][j-1] , dist)){
                distance[i][j-1] = Math.min(grid[i][j-1] , dist);
                pq.add(new tuple(i,j-1,distance[i][j-1]));
            }
            if(i+1 < grid.length && distance[i+1][j] < Math.min(grid[i+1][j] , dist)){
                distance[i+1][j] = Math.min(grid[i+1][j] , dist);
                pq.add(new tuple(i+1,j,distance[i+1][j]));
            }
            if(j+1 < grid.length && distance[i][j+1] < Math.min(grid[i][j+1] , dist)){
                distance[i][j+1] = Math.min(grid[i][j+1] , dist);
                pq.add(new tuple(i,j+1,distance[i][j+1]));
            }
        }
        return distance[grid.length - 1][grid.length - 1];
    }
    
    
    //get the distance of each grid positon to the nearest 1 or thief
    private int[][] getdist(List<List<Integer>> grid){
        int[][] distance = new int[grid.size()][grid.size()];
        for(int[] i : distance){
            Arrays.fill(i,-1);
        }
        Queue<tuple> q = new LinkedList<>();
         for(int i = 0; i<grid.size(); i++){
            for(int j = 0; j<grid.size(); j++){
                if(grid.get(i).get(j) == 1)q.add(new tuple(i,j,0));
            }
        }
        
        while(!q.isEmpty()){
            tuple t = q.remove();
            int i = t.first;
            int j = t.second;
            int dist = t.dist;
            
            if(i-1>= 0 && distance[i - 1][j] == -1 && grid.get(i-1).get(j) == 0){
                distance[i-1][j] = dist + 1;
                q.add(new tuple(i-1 , j , dist + 1));
            }
            if(j-1>= 0 && distance[i][j-1] == -1 && grid.get(i).get(j-1) == 0){
                distance[i][j-1] = dist + 1;
                q.add(new tuple(i , j-1 , dist + 1));
            }
            if(i+1 < grid.size() && distance[i + 1][j] == -1 && grid.get(i+1).get(j) == 0){
                distance[i+1][j] = dist + 1;
                q.add(new tuple(i+1 , j , dist + 1));
            }
            if(j+1 < grid.size() && distance[i][j+1] == -1 && grid.get(i).get(j+1) == 0){
                distance[i][j+1] = dist + 1;
                q.add(new tuple(i , j+1 , dist + 1));
            }
        }
        return distance;
    }
}


class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int row = grid.size();
        int col = grid.get(0).size();

        if (grid.get(0).get(0) == 1 || grid.get(row - 1).get(col - 1) == 1) {
            return 0;
        }

        int[][] safeness = new int[row][col];
        for (int[] rowArr : safeness) {
            Arrays.fill(rowArr, -1);
        }

        Deque<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid.get(r).get(c) == 1) {
                    safeness[r][c] = 0;
                    q.offer(new int[]{0, r, c});
                }
            }
        }

        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int dis = current[0], r = current[1], c = current[2];
            for (int[] dir : direction) {
                int nr = r + dir[0], nc = c + dir[1];
                if (0 <= nr && nr < row && 0 <= nc && nc < col && safeness[nr][nc] == -1) {
                    safeness[nr][nc] = dis + 1;
                    q.offer(new int[]{dis + 1, nr, nc});
                }
            }
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        heap.offer(new int[]{safeness[0][0], 0, 0});
        Set<String> seen = new HashSet<>();
        seen.add(0 + "," + 0);

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int dis = current[0], r = current[1], c = current[2];
            if (r == row - 1 && c == col - 1) {
                return dis;
            }

            for (int[] dir : direction) {
                int nr = r + dir[0], nc = c + dir[1];
                if (0 <= nr && nr < row && 0 <= nc && nc < col && !seen.contains(nr + "," + nc)) {
                    int safe = Math.min(dis, safeness[nr][nc]);
                    heap.offer(new int[]{safe, nr, nc});
                    seen.add(nr + "," + nc);
                }
            }
        }

        return -1;
    }
}