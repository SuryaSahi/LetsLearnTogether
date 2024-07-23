class Solution {
    public int[] sortArray(int[] arr) {
        // Arrays.sort(nums);
        // return nums;
        
        //using heap sort - Time : O(nlogn) , Space : O(1)
        int n = arr.length;
        for(int i = n / 2 - 1; i>=0; i--){
            heapify(arr,n,i);
        }
        
        for(int i = n - 1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr,i,0);
        }
        return arr;
    }
    
    public void heapify(int []arr , int n , int i){
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        
        if(left < n && arr[left] > arr[largest])largest = left;
        if(right < n && arr[right] > arr[largest])largest = right;
        
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            
            //recursively calling heap sort
            heapify(arr , n , largest);
        }
    }
}