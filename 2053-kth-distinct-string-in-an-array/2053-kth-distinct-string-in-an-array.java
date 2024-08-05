class Solution {
    public String kthDistinct(String[] arr, int k) {
        String[] temp = new String[k];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean jake = true;

            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i].equals(arr[j])) {
                    jake = false;
                    break;
                }
            }

            if (jake) {
                if (cnt < k) {
                    temp[cnt] = arr[i];
                }
                cnt++;
                if (cnt == k) break;
            }
        }

        // Ensure the k-th distinct element is within bounds
        if (cnt < k) {
            return ""; // Return an empty string if there are not enough distinct elements
        }

        return temp[k - 1];
    }
}
