class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n= nums.length;

        //  Counting local inversions
        int li= 0;
            for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                li++;
            }
        }
        //  Counting the global inversions (Using merge sort)
        int gi= mergeSort(nums, 0, n-1);

        if(gi == li){
            return true;
        } 
        else{
            return false;
        }
    }

    public int mergeSort(int[] nums, int left, int right){
        if(left>= right){
            return 0;
        }
        int ans= 0;

        int middle= (left+right)/2;
        ans+= mergeSort(nums, left, middle);
        ans+= mergeSort(nums, middle+1, right);

        ans+= merge(nums, left, middle, right);

        return ans;
    }

    public int merge(int[] nums, int left, int middle, int right){
        int tempAns= 0;

        int[] temp1= Arrays.copyOfRange(nums, left, middle+1);
        int[] temp2= Arrays.copyOfRange(nums, middle+1, right+1);

        //  Merging the two arrays
        int n1= temp1.length;
        int n2= temp2.length;
        int p1= 0;
        int p2= 0;
        int originalPointer= left;

        while(p1<n1 && p2<n2){
            if(temp1[p1] <= temp2[p2]){
                nums[originalPointer] = temp1[p1];
                p1++;
                originalPointer++;
            }
            else{
                tempAns+= (n1-p1);
                nums[originalPointer]= temp2[p2];
                p2++;
                originalPointer++;
            }
        }

        while(p1<n1){
            nums[originalPointer]= temp1[p1];
            p1++;
            originalPointer++;
        }

        while(p2<n2){
            nums[originalPointer]= temp2[p2];
            p2++;
            originalPointer++;
        }

        return tempAns;
    }
}