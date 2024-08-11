class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for(int i = 0; i<nums.size(); i++){
            int t = Integer.bitCount(i);
            if(t == k)ans += nums.get(i);
        }
        return ans;
    }
}