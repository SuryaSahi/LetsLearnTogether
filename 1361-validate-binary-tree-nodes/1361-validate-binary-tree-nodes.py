class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        child_parent = {}
        adj = [[] for _ in range(n)]
        
        for i in range(0,n):
            leftC = leftChild[i];
            rightC = rightChild[i];
            node = i
            
            if leftC != -1:
                adj[node].append(leftC);
                if leftC in child_parent:
                    return False
                child_parent[leftC] = node
            if rightC != -1:
                adj[node].append(rightC);
                if rightC in child_parent:
                    return False
                child_parent[rightC] = node     
                    
         #checking for roots
        root = -1
        for i in range(0,n):
            if i not in child_parent:
                if root != -1:
                    return False
                root = i
         
        if root == -1:
            return False
        
        #BFS to check if no of nodes are visited atleast once to check if there are no disjoint values
        vis = [False] * n
        count = 1
        que = deque([root])
        
        while que:
            node = que.popleft()
            for child in adj[node]:
                if vis[child]:
                    return false
                
                if vis[child] is False:
                    vis[child] = True
                    count += 1
                    que.append(child)
        
        return count == n            
        
        
        
        
        
        
        
        
        
        