
class Solution {
    public String[] findRelativeRanks(int[] score) {
        // Create a copy of the original scores array
        int[] sortedScores = Arrays.copyOf(score, score.length);
        // Sort the copied array in descending order
        Arrays.sort(sortedScores);
        
        // Create a HashMap to store the rank of each score
        HashMap<Integer, String> rankMap = new HashMap<>();
        for (int i = 0; i < sortedScores.length; i++) {
            int rank = sortedScores.length - i;
            if (rank == 1)
                rankMap.put(sortedScores[i], "Gold Medal");
            else if (rank == 2)
                rankMap.put(sortedScores[i], "Silver Medal");
            else if (rank == 3)
                rankMap.put(sortedScores[i], "Bronze Medal");
            else
                rankMap.put(sortedScores[i], String.valueOf(rank));
        }
        
        // Create an array to store the result
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = rankMap.get(score[i]);
        }
        
        return result;
    }
}
