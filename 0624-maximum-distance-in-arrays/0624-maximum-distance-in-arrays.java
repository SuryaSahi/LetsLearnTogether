class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxTillNow = Integer.MIN_VALUE, minTillNow = Integer.MAX_VALUE;
        int maxDistTillNow = 0;
        for(var array : arrays){
            int len = array.size();
            int firstEle = array.get(0), lastEle = array.get(len - 1);
            if(maxTillNow == Integer.MIN_VALUE){
                maxTillNow = Math.max(maxTillNow, lastEle);
                minTillNow = Math.min(minTillNow, firstEle);
                continue;
            }
            int firstEleDist = Math.max(Math.abs(maxTillNow - firstEle), Math.abs(minTillNow - firstEle));
            int lastEleDist = Math.max(Math.abs(maxTillNow - lastEle), Math.abs(minTillNow - lastEle));
            int currDist = Math.max(firstEleDist, lastEleDist);
            maxDistTillNow = Math.max(currDist, maxDistTillNow);
            maxTillNow = Math.max(maxTillNow, lastEle);
            minTillNow = Math.min(minTillNow, firstEle);
        } 
        return maxDistTillNow;
    }
}