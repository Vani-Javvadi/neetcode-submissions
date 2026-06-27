class Solution {
    public int search(int[] nums, int target) {
        // find low , mid , high 
        // check if target is between low -> mid or mid -> high 
        // accordingly decrease the search space 

        int n = nums.length;
        int low = 0, high = n-1;
        int mid = 0 ; 
        while(low < high) {
            mid = (low+high)/2;
            if(nums[mid] == target) {
                return mid;
            } 
            // check if low -> mid is sorted 
            if(nums[low] <= nums[mid]) {
                // check if it lies between low -> mid or not 
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid;
                }  else {
                    low = mid+1;
                }
            } 
            // mid to high sorted
            else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid;
                }  else {
                    high = mid-1;
                }
            }
        }
        if(nums[low] == target) {
            return low;
        } 
        return -1;
    }
}
