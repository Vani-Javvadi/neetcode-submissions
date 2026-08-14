class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0], maxSum = nums[0];
        for(int i=1; i<n; i++) {
            //if adding current number is making sum negative na , same negative should not carry forward as it will reduce the sum , we have to maximize it , so we will make it 0         
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
