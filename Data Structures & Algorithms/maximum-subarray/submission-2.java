class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0], maxSum = nums[0];
        for(int i=1; i<n; i++) {
            //if adding current number is making sum < nums[i] na, what is the point in taking it forward , we will make sum to current element 
            if(nums[i] + sum < nums[i]) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
