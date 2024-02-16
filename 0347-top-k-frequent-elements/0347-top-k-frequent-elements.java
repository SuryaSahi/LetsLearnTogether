class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(int i : map.keySet())
        {
            q.add(i);
        }
        int[] result = new int[k];
        for(int i = 0; i<k; i++)
        {
            result[i] = q.poll();
        }
        return result;
    }
}