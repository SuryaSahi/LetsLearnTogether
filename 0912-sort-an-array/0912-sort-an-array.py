class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        for i in range (n//2 -1,-1,-1):
            self.heapify(nums,n,i)
            
        for i in range(n-1,0,-1):
            temp = nums[i];
            nums[i] = nums[0]
            nums[0] = temp;
            
            self.heapify(nums , i , 0)
        return nums
    
    def heapify(self , nums : List[int] , n : int , i : int):
        largest = i
        left = i * 2 + 1
        right = i * 2 + 2
        
        if left < n and nums[left] > nums[largest]:
            largest = left
        if right < n and nums[right] > nums[largest]:
            largest = right
            
        if largest != i :
            nums[i] , nums[largest] = nums[largest] , nums[i]
            
            self.heapify(nums , n , largest)    
        
            
        