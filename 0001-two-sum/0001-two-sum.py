class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans = [0,0];
        nummap = {}
        for i in range(0,len(nums)):
            if target - nums[i] in nummap:
                ans[0] = i
                ans[1] = nummap[target - nums[i]];
            else:
                nummap[nums[i]] = i
        return ans        