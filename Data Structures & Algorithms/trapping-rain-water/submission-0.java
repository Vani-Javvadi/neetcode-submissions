class Solution {
    public int trap(int[] height) {
        // pge, nge we will store in array for each elevation 
        // so heigh of water it can trap is min(pge, nge) - elevation height
        // example in below example - 
        // height = [0,2,0,3,1,0,1,3,2,1]
        // 0 at index 3 can store 2 units of water 
        // TC - O(2N) - for pge and nge  + O(N) to calculate units of water 

        // we will use left max and right max , to tract the heights the way we did using pge and nge 
        // the units of trapping will be min(left max, right max) - heights[i];
        // code - 
        int n = height.length;
        int l = 0, r = n-1, leftmax = height[l], rightmax = height[r], units=0;
        while(l <= r) {
            leftmax = Math.max(leftmax, height[l]);
            rightmax = Math.max(rightmax, height[r]);
            if(height[l] <= height[r]) {
                units += (Math.min(leftmax, rightmax) - height[l]);
                System.out.println("units " + units);
                l++;
            } else {
                units += (Math.min(leftmax, rightmax) - height[r]);
                System.out.println("units " + units);
                r--;
            }
        }
        return units;

        
    }
}
