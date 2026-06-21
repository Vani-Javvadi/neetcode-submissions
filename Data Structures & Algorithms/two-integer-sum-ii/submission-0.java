class Solution {
    public int[] twoSum(int[] nums, int target) {
        // BF - O(N^2) - using 2 loops we will find 
        // if we sort we can find the other element - target - nums[i] using BS 
        // Better - n*longN - using BS 
        // Optimal - O(n) - 2 pointer after sorting 

        int n = nums.length;
        int[] result = new int[2];
        // Arrays.sort(numbers); - alraeady sorted 
        int p1 = 0, p2 = n-1;
        while(p1 < p2) {
            if(nums[p1] + nums[p2] == target) {
                result[0] = p1+1;
                result[1] = p2+1;
                return result;
            } else if( nums[p1] + nums[p2] < target ) {
                p1++;
            } else {
                p2--;
            }
        }
        return result;
    }
}
