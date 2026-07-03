class Solution {
    public int missingNumber(int[] nums) {
        // we will perform xor and find 
        int n = nums.length;
        int x = 1, res = 0;
        for(int i=0; i<n; i++) {
            res = res ^ (x ^ nums[i]);
            x++;
        }
        return res;
    }
}
