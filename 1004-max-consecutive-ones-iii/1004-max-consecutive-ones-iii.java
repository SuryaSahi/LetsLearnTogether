class Solution {
    public int longestOnes(int[] nums, int k) {
        //using 2 pointer sliding window
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j++] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[i++] == 0) {
                    k++;
                }
            }
        }
        return j - i;
    }
}
