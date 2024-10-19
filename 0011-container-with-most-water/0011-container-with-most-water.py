class Solution:
    def maxArea(self, height: List[int]) -> int:
        i , j = 0 , len(height) - 1
        capacity = float('-inf')
        while i < j:
            num1 = height[i]
            num2 = height[j]
            min_height = min(num1 , num2)
            capacity = max(capacity , min_height * (j - i))
            if num1 > num2 : 
                j = j - 1
            else:
                i = i + 1
        return capacity       
            