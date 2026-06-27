class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        // check if lowm-> mid-> high are sorted , if so then return low min 
        // else if low < mid and low > high means means element does exist in low->mid , so move low = mid+1 
        // else mid -> high are sorted means and mid <= high means , move mid to high 

        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low+high) / 2;
            if(nums[low] <= nums[mid] && nums[mid] <= nums[high]) {
                // low -> high sorted , return low which is min element 
                return nums[low];
            } 
            // low -> mid sorted and low > high , mean min element does not exist in low -> mid 
            else if(nums[low] <= nums[mid] && nums[low] > nums[high]) {
                low = mid+1;
            } 
            // mid -> high if sorted means we can move high to mid , because it it min element in mid->high , we can eliminate mid+1 to high searcg space 
            else {
                high = mid;
            }
        }
        return -1;

    }
}
