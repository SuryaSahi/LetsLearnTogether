class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        
        dist = [[float('inf')] * n for _ in range(n)]
        
        for i in range(n):
            dist[i][i] = 0
            
        for edge in edges:
            x , y , wt = edge
            dist[x][y] = wt
            dist[y][x] = wt
            
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if dist[i][k] == [float('inf')] or dist[k][j] == [float('inf')]:
                        continue
                    dist[i][j] = min(dist[i][j] , dist[i][k] + dist[k][j])
                    
        cityCnt = n
        City = -1
        
        for i in range(n):
            cnt = sum(1 for j in range(n) if dist[i][j] <= distanceThreshold)
            
            if cnt <= cityCnt:
                cityCnt = cnt
                City = i
        
        return City           
        