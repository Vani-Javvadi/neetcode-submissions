class Solution {
    public int[] productExceptSelf(int[] nums) {
        // we will solve this by finding prefix product and then 
        // suffix product for each element

        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        // finding prefix product for each element 
        for(int i=1; i<n; i++) {
            // for current element the product will be previous element * prev element prod 
            output[i] = output[i-1] * nums[i-1];
        }

        // finding suffix product for each element from end 
        int suffix = 1;
        for(int i=n-1; i>=0; i--) {
            output[i] *= suffix;
            suffix *= nums[i];
        }
        return output;
    }
}  
