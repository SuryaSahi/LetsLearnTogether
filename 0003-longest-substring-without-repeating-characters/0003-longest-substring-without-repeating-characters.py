class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        ans = set()
        i = 0 
        j = 0
        size = 0 
        maxsize = 0
        while j < len(s):
            if s[j] not in ans:
                size += 1
                ans.add(s[j])
                j += 1
                maxsize = max(j - i, maxsize)
            else:
                size -= 1
                ans.remove(s[i])
                i += 1
        return maxsize        
                