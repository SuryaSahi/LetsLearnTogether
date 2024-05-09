class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long hapsum = 0;
        int i = happiness.length - 1;
        int neg = 0;
        Arrays.sort(happiness);
        while(k > 0){
            k--;
            happiness[i] -= neg;
            if(happiness[i] < 0)hapsum += 0;
            else hapsum += happiness[i];
            i--;
            neg++;
        }
        return hapsum;
    }
}